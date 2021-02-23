package pe.com.distriluz.app.ui.base;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.LinearLayout;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.components.DaggerDialogComponent;
import pe.com.distriluz.app.injection.components.DialogComponent;
import pe.com.distriluz.app.injection.modules.DialogModule;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.MvvmViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;
import pe.com.distriluz.data.utiles.Constantes;

public abstract class BaseDialog<B extends ViewDataBinding, V extends MvvmViewModel> extends AppCompatDialogFragment {

    protected B binding;
    @Inject
    protected V viewModel;

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(this, tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
       // ActionBar actionBar = getActionBar();
        //actionBar.hide();

//        if(getDialog() != null) {
//
//            View decorView = getDialog().getWindow().getDecorView();
//            // Hide the status bar.
//            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//            //controles detras de la barra de estado.
//        //    getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//         //   getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//          //  getDialog().getWindow().getAttributes().windowAnimations = R.style.FullScreenDialogStyle2;
//
//   //         getDialog().getWindow().setStatusBarColor(Color.RED);
//        }

    }

    private DialogComponent mDialogComponent;

    @Override
    @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            viewModel.saveInstanceState(outState);
        }
    }

    public void removeSession(){
        getActivity().getSharedPreferences(Constantes.PREFERENCES, Context.MODE_PRIVATE).edit().clear().apply();
    }

    @Override
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        if (viewModel != null) {
            viewModel.detachView();
//            if(refWatcher != null) { refWatcher.watch(viewModel);}
        }
        binding = null;
        viewModel = null;
    }

    @Override
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        mDialogComponent = null;
    }


    protected final DialogComponent dialogComponent() {
        if (mDialogComponent == null) {
            mDialogComponent = DaggerDialogComponent.builder()
                    .dialogModule(new DialogModule(this))
                    .activityComponent(((BaseActivity) getActivity()).activityComponent())
                    .build();
        }

        return mDialogComponent;
    }




    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected final View setAndBindContentView(@Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must already be set via injection");
        }
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), layoutResID, null, false);
        binding.setVariable(pe.com.distriluz.app.BR.vm, viewModel);

        try {
            //noinspection unchecked
            viewModel.attachView((MvvmView) this, savedInstanceState);
        } catch (ClassCastException e) {
            if (!(viewModel instanceof NoOpViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + viewModel.getClass().getSimpleName());
            }
        }

        return binding.getRoot();
    }
    public final V viewModel() {
        return viewModel;
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

    protected <T extends Filterable> void configSearchView(SearchView searchView, T adapter) {
        searchView.setIconifiedByDefault(false);
        SearchManager searchManager =(SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        EditText searchBox=(EditText)searchView.findViewById(R.id.search_src_text);
        searchBox.setPadding(0,0,0,0);
        searchBox.setTextSize(12);
        searchBox.setTextColor(getResources().getColor(R.color.plomo_ios_default));
        searchBox.setHintTextColor(getResources().getColor(R.color.plomo_ios_default));

        LinearLayout.LayoutParams searcPlateParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout searchPlate = searchView.findViewById(R.id.search_plate);
        searchPlate.setLayoutParams(searcPlateParams);

        LinearLayout searchEditFrame = searchView.findViewById(R.id.search_edit_frame);
        searchEditFrame.setPadding(0,0,0,0);
        searchEditFrame.setLayoutParams(searcPlateParams);

        LinearLayout searchBar = searchView.findViewById(R.id.search_bar);
        searchBar.setPadding(0,0,0,0);

        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
    }

    protected void hideKeywoard(){
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }
}
