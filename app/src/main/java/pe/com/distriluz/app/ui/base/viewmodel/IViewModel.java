package pe.com.distriluz.app.ui.base.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.DialogFragment;

import pe.com.distriluz.app.ui.base.view.MvvmView;


public interface IViewModel<V extends MvvmView> extends MvvmViewModel<V> {
//    void update(FormItemObservableModel itemsForm);
//
//    FormItemObservableModel getBaseModel();
//
//    void onClickChangeDate(android.view.View v);
//    void onClickList(android.view.View v);
//
//    void destroy();
    ObservableBoolean isLoaded();

    void openDialog(DialogFragment dialog);

    void onClickItemMenu(Integer type);

    void openGallery();

    void openCamera();

    void closeAlertGeneric(Integer type);

    void okAlertGeneric(Integer type);
}
