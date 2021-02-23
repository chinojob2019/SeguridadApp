package pe.com.distriluz.app.ui.base;

public class MvvmViewNotAttachedException extends RuntimeException {
    public MvvmViewNotAttachedException() {
        super("Please call ViewModel.attachView(MvvmView) before requesting data to the ViewModel");
    }
}
