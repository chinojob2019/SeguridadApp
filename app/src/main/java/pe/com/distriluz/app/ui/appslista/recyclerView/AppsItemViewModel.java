package pe.com.distriluz.app.ui.appslista.recyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;
import pe.com.distriluz.app.R;
import pe.com.distriluz.app.injection.qualifier.AppContext;
import pe.com.distriluz.app.injection.scopes.PerViewHolder;
import pe.com.distriluz.app.ui.alerts.AlertEmailErrorDialog;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.appslista.AppsObservableModel;
import pe.com.distriluz.app.ui.base.navigator.Navigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseViewHolderViewModel;
import pe.com.distriluz.domain.interactor.AddContadorUseCase;
import pe.com.distriluz.domain.interactor.SetDestacadoUseCase;
import pe.com.distriluz.domain.interactor.baseinteractors.DefaultObserverSingle;


@PerViewHolder
public class AppsItemViewModel extends BaseViewHolderViewModel<AppsItemMvvm.View> implements AppsItemMvvm.ViewModel {

    private AddContadorUseCase addContadorUseCase;
    private AppsObservableModel.AppObservable app;
    private SetDestacadoUseCase setDestacadoUseCase;
    private AlertLoadingDialog dialog;
private Context context;
    @Inject
    public AppsItemViewModel(@AppContext Context context, Navigator navigator, SetDestacadoUseCase setDestacadoUseCase, AddContadorUseCase addContadorUseCase) {
        super(context, navigator);
        this.setDestacadoUseCase = setDestacadoUseCase;
        this.addContadorUseCase = addContadorUseCase;
        this.context=context;
    }

    @Override
    public void detachView() {
        this.setDestacadoUseCase.dispose();
        this.addContadorUseCase.dispose();
        super.detachView();
    }

    @Override
    public void onClickApp(View v) {


        if(getModel().getDespliegues().size()>0) {

            Snackbar snackbar = Snackbar.make(v, "", Snackbar.LENGTH_LONG);
            LinearLayout ly = new LinearLayout(context);
            ly.setOrientation(LinearLayout.VERTICAL);
            ly.setGravity(Gravity.LEFT);
            ly.setPadding(0, 32, 0, 32);

            for (int i = 0; i < getModel().getDespliegues().size(); i++) {
                TextView bt = new TextView(context);
                bt.setText(getModel().getDespliegues().get(i).getNombreEmpresa().toUpperCase());
                bt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                bt.setPadding(64, 32, 64, 32);

                bt.setTextColor(Color.BLACK);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    bt.setTypeface(context.getResources().getFont(R.font.roboto_mediun), Typeface.BOLD);
                }
                bt.setGravity(Gravity.LEFT);
                bt.setTag(getModel().getDespliegues().get(i).getUrlEmpresa());
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(v.getTag().toString()));
                        navigator.startActivity(i);
                        showLoading();
                        addContadorUseCase.execute(new DisposableSingleObserver<Boolean>() {
                            @Override
                            public void onSuccess(Boolean aBoolean) {
                                hideLoading();
                                getView().reloadApps();
                            }

                            @Override
                            public void onError(Throwable e) {
                                validateErrorToken(e);
                                hideLoading();
                                e.printStackTrace();
                                showError(e);
                            }
                        }, AddContadorUseCase.Params.datos(getModel().getId() + ""));

                        snackbar.dismiss();
                    }
                });
                ly.addView(bt);
            }
            snackbar.getView().setBackgroundColor(Color.WHITE);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
            snackbarLayout.setPadding(16, 24, 16, 24);
            snackbarLayout.addView(ly, 0);
            snackbar.show();
        }
        else
        {

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(getModel().getUrl()));
            navigator.startActivity(i);
            showLoading();
            addContadorUseCase.execute(new DisposableSingleObserver<Boolean>() {
                @Override
                public void onSuccess(Boolean aBoolean) {
                    hideLoading();
                    getView().reloadApps();
                }

                @Override
                public void onError(Throwable e) {
                    validateErrorToken(e);
                    hideLoading();
                    e.printStackTrace();
                    showError(e);
                }
            },AddContadorUseCase.Params.datos(getModel().getId()+""));
        }
    }

    @Override
    public void onClickItem(View v) {
        navigator.startDialog(
                new AlertEmailErrorDialog("Destacados",
                        getModel().getDestacadas() == 0 ? "¿Desea destacar la aplicación?" : "¿Desea quitar la aplicación de destacados?",
                        "Aceptar", this, R.drawable.ic_edit));
    }

    @Override
    public void okAlertGeneric() {
        showLoading();
        this.setDestacadoUseCase.execute(new DefaultObserverSingle<Boolean>(){
            @Override
            public void onError(Throwable e) {
                validateErrorToken(e);
                hideLoading();
                e.printStackTrace();
                showError(e);
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                hideLoading();
                getView().reloadApps();
            }
        }, SetDestacadoUseCase.Params.datos("" + getModel().getId(), getModel().getDestacadas() == 0 ? "1" : "0"));
    }

    @Override
    public void closeAlertGeneric() {

    }

    @Override
    public void update(AppsObservableModel.AppObservable app) {
        this.app = app;
        notifyChange();
    }

    @Override
    public AppsObservableModel.AppObservable getModel() {
        return app;
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
}
