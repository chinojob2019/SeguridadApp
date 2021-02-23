package pe.com.distriluz.app.ui.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import androidx.databinding.ObservableField;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.scopes.PerFragment;
import pe.com.distriluz.app.ui.alerts.AlertLoadingDialog;
import pe.com.distriluz.app.ui.base.navigator.FragmentNavigator;
import pe.com.distriluz.app.ui.base.viewmodel.BaseFragmentViewModel;
import pe.com.distriluz.app.ui.editprofile.EditProfileActivity;
import pe.com.distriluz.data.utiles.Utils;


@PerFragment
public class ProfileViewModel extends BaseFragmentViewModel<ProfileMvvm.View> implements ProfileMvvm, ProfileMvvm.ViewModel {

    private final ProfileMapper mapper;
    private Resources res;
    private AlertLoadingDialog dialog;
    private ProfileObservableModel model = new ProfileObservableModel();
    private ObservableField<Boolean> validUser =  new ObservableField<>(true);

    @Inject
    public ProfileViewModel(Context context, FragmentNavigator navigator, Resources res, ProfileMapper mapper) {
        super(context,navigator);
        this.res = res;
        this.mapper = mapper;
        this.validUser.set(!Utils.getIdPerson(context).equals("0"));
    }

    @Override
    public ProfileObservableModel getModel() {
        return model;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == EditProfileActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK){
            this.model = new ProfileObservableModel();
            notifyChange();
            getView().changeGlobal();
        }
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
    public void onClickEditProfile(android.view.View view) {
        navigator.startActivityForResultFromFragment(EditProfileActivity.class, 0, EditProfileActivity.REQUEST_CODE);
    }

    @Override
    public ObservableField<Boolean> getValidUser() {
        return validUser;
    }
}
