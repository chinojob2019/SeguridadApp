package pe.com.distriluz.app.ui.clientelistar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.R;
import pe.com.distriluz.app.databinding.ClienteListaActivityBinding;
import pe.com.distriluz.app.ui.base.BaseActivity;
import pe.com.distriluz.app.ui.clientelistar.navigatoritems.NavigatorItemAdapter;

public class ClienteListarActivity extends BaseActivity<ClienteListaActivityBinding, ClienteListarMvvm.ViewModel> implements ClienteListarMvvm.View {

    private static ActionBarDrawerToggle actionbarToggle;

    @Inject
    public NavigatorItemAdapter adapter;

    private final static String TAG = ClienteListarActivity.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setAndBindContentView(savedInstanceState, R.layout.cliente_lista_activity);
        init();
        configRecycler();
        if (savedInstanceState == null) {
            selectItem(0);
        }
        hideKeyboard();
    }


    void init() {
        actionbarToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbarBarra ,
               R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

        };
        actionbarToggle.setDrawerIndicatorEnabled(false);
        binding.drawerLayout.addDrawerListener(actionbarToggle);
    }
    private void configRecycler() {
        adapter.setData(viewModel.getModel(), viewModel);
        binding.listSlidermenu.setHasFixedSize(true);
        binding.listSlidermenu.setLayoutManager(new GridLayoutManager(this,1));
        binding.listSlidermenu.setAdapter(adapter);
        binding.listSlidermenu.setItemAnimator(new DefaultItemAnimator());
        binding.listSlidermenu.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                super.onTouchEvent(rv, e);
            }
        });
    }

    public void selectItem(int position) {
        closeDrawer();
    }

    public void closeDrawer() {
        if (binding.drawerLayout.isDrawerOpen(binding.slider)) {
            binding.drawerLayout.closeDrawer(binding.slider);
        }
    }
    public void openDrawer() {
        if (!binding.drawerLayout.isDrawerOpen(binding.slider)) {
            binding.drawerLayout.openDrawer(binding.slider);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionbarToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionbarToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public void ocultarKeyboard() {
        hideKeyboard();
    }

    @Override
    public void onBackPressed() {
        if(viewModel.getModel().getQuery().isEmpty()){
            super.onBackPressed();
        }else{
            viewModel.getModel().setQuery("");
            hideKeyboard();
        }
    }

    @Override
    public void updateAdapter(){
       // adapter.setData(viewModel.getModel());
        adapter.notifyDataSetChanged();
    }
}
