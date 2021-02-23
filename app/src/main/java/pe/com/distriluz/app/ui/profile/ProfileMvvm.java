package pe.com.distriluz.app.ui.profile;

import android.content.Intent;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.IViewModel;

public interface ProfileMvvm {
    interface View extends MvvmView {

        void changeGlobal();
    }

    interface ViewModel extends IViewModel<View> {

        @Override
        ObservableBoolean isLoaded();

        void onClickOpenDrawer(android.view.View view);
        void onClickEditProfile(android.view.View view);

        ObservableField<Boolean> getValidUser();

        ProfileObservableModel getModel();

        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
