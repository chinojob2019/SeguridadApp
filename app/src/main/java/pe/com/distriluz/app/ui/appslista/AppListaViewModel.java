package pe.com.distriluz.app.ui.appslista;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.app.ui.clientelistar.ClienteListarObservableModel;
import pe.com.distriluz.domain.interactor.GetAppsUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;
import pe.com.distriluz.domain.model.Apps;


@PerFragment
public class AppListaViewModel extends BaseFragmentViewModel<AppListaMvvm.View> implements AppListaMvvm, AppListaMvvm.ViewModel {

    private Resources res;
    private GetAppsUseCase getAppsUseCase;
    private AlertLoadingDialog dialog;
    private AppsListaMapper mapper;
    private AppsObservableModel model;
    private ClienteListarObservableModel activityModel;

    @Inject
    public AppListaViewModel(Context context, FragmentNavigator navigator, Resources res,
                             GetAppsUseCase getAppsUseCase, AppsListaMapper mapper) {
        super(context,navigator);
        this.res = res;
        this.getAppsUseCase = getAppsUseCase;
        this.mapper = mapper;
        this.model = new AppsObservableModel();
    }

    @Override
    public void detachView() {
        getAppsUseCase.dispose();
        super.detachView();
    }

    @Override
    public AppsObservableModel getModel() {
        return model;
    }

    @Override
    public void attachView(View mvvmView, @Nullable Bundle savedInstanceState) {
        super.attachView(mvvmView, savedInstanceState);
        getAllApps();
    }

    @Override
    public void getAllApps() {
        showLoading();
        getAppsUseCase.execute(new DefaultObserverSingle<Apps>(){
            @Override
            public void onSuccess(Apps apps) {
                hideLoading();
                mapper.mapperApps(model,apps);
                model.notifyChange();
                getView().updateAdapter();
            }

            @Override
            public void onError(Throwable e) {
                validateErrorToken(e);
                hideLoading();
                e.printStackTrace();
                showError(e);
            }
        },null);
    }

    @Override
    public void onClickShowGrid(android.view.View view) {
        this.model.getIsGrid().set(true);
        getView().updateAdapter();
    }

    @Override
    public void onClickShowList(android.view.View view) {
        this.model.getIsGrid().set(false);
        getView().updateAdapter();
    }


    @Override
    protected void showLoading() {
        super.showLoading();
        if(dialog==null) {
            dialog = new AlertLoadingDialog();
            navigator.startDialog(dialog);
        }
    }

    @Override
    protected void hideLoading() {
        if(dialog!=null) {
            dialog.dismissAllowingStateLoss();
            dialog=null;
        }
    }

    @Override
    public void onClickOpenDrawer(android.view.View view) {
        navigator.openDrawer();
    }

    @Override
    public void setActivityModel(ClienteListarObservableModel activityModel) {
        this.activityModel = activityModel;
    }

    @Override
    public ClienteListarObservableModel getActivityModel() {
        return activityModel;
    }
}
