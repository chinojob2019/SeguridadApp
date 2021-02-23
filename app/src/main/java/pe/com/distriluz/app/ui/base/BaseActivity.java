package pe.com.distriluz.app.ui.base;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.LinearLayout;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import javax.inject.Inject;

import pe.com.distriluz.app.ApplicationContext;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.components.ActivityComponent;
import pe.com.distriluz.app.injection.components.DaggerActivityComponent;
import pe.com.distriluz.app.injection.modules.ActivityModule;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.MvvmViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;

public abstract class BaseActivity<B extends ViewDataBinding, V extends MvvmViewModel> extends AppCompatActivity  {

    protected B binding;
    @Inject
    protected V viewModel;
    private ActivityComponent mActivityComponent;
    private SearchView searchview;

    public static final String[] PERMISSIONS_INSPECTION = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.WAKE_LOCK
    };
    public static final int REQUEST_INSPECTION_CODE = 666;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        binding.getRoot().requestFocus();
        Log.i("BaseActivity", "onResume: BaseActivity");
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        Log.i("BaseActivity", "onStart: BaseActivity");
    }

    @Override
    @CallSuper
    protected void onStop() {
        super.onStop();
        Log.i("BaseActivity", "onStop: BaseActivity");
    }

    @Override
    @CallSuper
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            viewModel.saveInstanceState(outState);
        }
    }
    protected void setTitle(String title) {
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

    }
    protected void setDisplayHomeAsUpEnabled() {
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setHomeButtonEnabled(true);
        }
    }

    protected void notelevationbar() {
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setElevation(0);
        }
    }
    @Override
    @CallSuper
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BaseActivity", "onStop: BaseActivity");
        if (viewModel != null) {
            viewModel.detachView();
        }
        binding = null;
        viewModel = null;
        mActivityComponent = null;
    }

    protected final ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(ApplicationContext.getAppComponent())
                    .build();
        }
        return mActivityComponent;

    }

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected final void setAndBindContentView(@Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must already be set via injection");
        }
        binding = DataBindingUtil.setContentView(this, layoutResID);
        binding.setVariable(pe.com.distriluz.app.BR.vm, viewModel);


        try {
            //noinspection unchecked
            viewModel.attachView((MvvmView) this, savedInstanceState);
        } catch (ClassCastException e) {
            if (!(viewModel instanceof NoOpViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + viewModel.getClass().getSimpleName());
            }
        }
    }

    public int dimen(@DimenRes int resId) {
        return (int) getResources().getDimension(resId);
    }

    public int color(@ColorRes int resId) {
        return getResources().getColor(resId);
    }

    public int integer(@IntegerRes int resId) {
        return getResources().getInteger(resId);
    }

    public String string(@StringRes int resId) {
        return getResources().getString(resId);
    }


    protected void setItemsVisibility(Menu menu, MenuItem exception, boolean visible) {
        for (int i=0; i<menu.size(); ++i) {
            MenuItem item = menu.getItem(i);
            if (item != exception) item.setVisible(visible);
        }
    }


    protected void tintMenuIcon(MenuItem menuItem) {
        menuItem.setIcon(tintIcon(menuItem.getIcon(), R.color.white));
    }
    protected Drawable tintIcon(Drawable icon, int idColor) {
        Drawable favoriteIcon = DrawableCompat.wrap(icon.mutate());
        DrawableCompat.setTint(favoriteIcon, color(idColor));
        return favoriteIcon;
    }

    public <T extends Filterable> void configSearchView(SearchView searchviewinit, T adapter) {
        searchview = searchviewinit;
        searchview.setIconifiedByDefault(false);

        EditText searchBox=(EditText)searchview.findViewById(R.id.search_src_text);
        AppCompatImageView deleteSearch=searchview.findViewById(R.id.search_close_btn);
        deleteSearch.setOnClickListener(v -> searchBox.setText(""));
        searchBox.setPadding(0,0,0,0);
        searchBox.setTextSize(getResources().getDimension(R.dimen.size_6));
        searchBox.setTextColor(getResources().getColor(R.color.plomo_ios_default));
        searchBox.setHintTextColor(getResources().getColor(R.color.plomo_ios_default));

        LinearLayout.LayoutParams searcPlateParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout searchPlate = searchview.findViewById(R.id.search_plate);
        searchPlate.setLayoutParams(searcPlateParams);

        LinearLayout searchEditFrame = searchview.findViewById(R.id.search_edit_frame);
        searchEditFrame.setPadding(0,0,0,0);
        searchEditFrame.setLayoutParams(searcPlateParams);

        LinearLayout searchBar = searchview.findViewById(R.id.search_bar);
        searchBar.setPadding(0,0,0,0);

        searchview.setSearchableInfo(((SearchManager) getSystemService(Context.SEARCH_SERVICE))
                .getSearchableInfo(getComponentName()));
        searchview.setMaxWidth(Integer.MAX_VALUE);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        binding.getRoot().requestFocus();
    }
    public void customSearch() {

        searchview.setIconifiedByDefault(false);
        EditText searchBox=(EditText)searchview.findViewById(R.id.search_src_text);
        AppCompatImageView deleteSearch=searchview.findViewById(R.id.search_close_btn);
        deleteSearch.setOnClickListener(v -> searchBox.setText(""));
        searchBox.setPadding(0,0,0,0);
        searchBox.setTextSize(getResources().getDimension(R.dimen.size_6));
        searchBox.setTextColor(getResources().getColor(R.color.plomo_ios_default));
        searchBox.setHintTextColor(getResources().getColor(R.color.plomo_ios_default));

        LinearLayout.LayoutParams searcPlateParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout searchPlate = searchview.findViewById(R.id.search_plate);
        searchPlate.setLayoutParams(searcPlateParams);

        LinearLayout searchEditFrame = searchview.findViewById(R.id.search_edit_frame);
        searchEditFrame.setPadding(0,0,0,0);
        searchEditFrame.setLayoutParams(searcPlateParams);

        LinearLayout searchBar = searchview.findViewById(R.id.search_bar);
        searchBar.setPadding(0,0,0,0);
        searchview.setSearchableInfo(((SearchManager) getSystemService(Context.SEARCH_SERVICE))
                .getSearchableInfo(getComponentName()));
        searchview.setMaxWidth(Integer.MAX_VALUE);
    }


    @Override
    public void onBackPressed() {
        if (searchview!= null && !searchview.isIconified() && !searchview.getQuery().toString().isEmpty()) {
            searchview.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
    public final V viewModel() {
        return viewModel;
    }


    protected void validPermissions() {
        if (Build.VERSION.SDK_INT < 23) {
            viewModel.onPermissionsSuccess();
        } else {
            getPermissions();
        }
    }

    public boolean checkExternalStoragePermission() {
        boolean onlyDenied=false;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for(String permission : PERMISSIONS_INSPECTION){
            if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED)
                onlyDenied=true;
        }
        if (onlyDenied) {
            getPermissions();
        }

        return !onlyDenied;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length > 0 && requestCode == REQUEST_INSPECTION_CODE && checkExternalStoragePermission()) {
            viewModel.onPermissionsSuccess();
        }
    }

    public void getPermissions() {
        ActivityCompat.requestPermissions(this, PERMISSIONS_INSPECTION, REQUEST_INSPECTION_CODE);
    }
    public void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void saveSearchView(SearchView searchview) {
        this.searchview = searchview;
        customSearch();
    }

    public void showKeyboard() {

//        EditText editText = findViewById(R.id.et_model);
//        editText.requestFocus();
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        View v = getCurrentFocus();
//        if (v != null)
//            imm.showSoftInput(v, 0);

//        editText.post(new Runnable() {
//            @Override
//            public void run() {
//                editText.requestFocus();
//                InputMethodManager imm = (InputMethodManager) editText.getContext()
//                        .getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
//            }
//        });
    }
}
