package pe.com.distriluz.app.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.components.DaggerFragmentComponent;
import pe.com.distriluz.app.injection.components.FragmentComponent;
import pe.com.distriluz.app.injection.modules.FragmentModule;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.MvvmViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;

//import com.squareup.leakcanary.RefWatcher;


/* Base class for Fragments when using a view model with data binding.
 * This class provides the binding and the view model to the subclass. The
 * view model is injected and the binding is created when the content view is set.
 * Each subclass therefore has to call the following code in onCreateView():
 *    if(viewModel == null) { fragmentComponent().inject(this); }
 *    return setAndBindContentView(inflater, container, R.layout.my_fragment_layout, savedInstanceState);
 *
 * After calling these methods, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() methods of the view model
 * are automatically called in the appropriate lifecycle events when above calls
 * are made.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model. */
public abstract class BaseFragment<B extends ViewDataBinding, V extends MvvmViewModel> extends Fragment {

    protected B binding;
    @Inject
    protected V viewModel;

//    @Inject RefWatcher refWatcher;

    private FragmentComponent mFragmentComponent;

    @Override
    @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            viewModel.saveInstanceState(outState);
        }
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
//        if(refWatcher != null) {
//            refWatcher.watch(this);
//            refWatcher.watch(mFragmentComponent);
//        }
        mFragmentComponent = null;
    }


    protected final FragmentComponent fragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = DaggerFragmentComponent.builder()
                    .fragmentModule(new FragmentModule(this))
                    .activityComponent(((BaseActivity) getActivity()).activityComponent())
                    .build();
        }

        return mFragmentComponent;
    }

    /* Sets the content view, creates the binding and attaches the view to the view model */
    protected final View setAndBindContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must already be set via injection");
        }
        binding = DataBindingUtil.inflate(inflater, layoutResID, container, false);
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

    public BaseActivity getBaseActivity(){
        return (BaseActivity)getActivity();
    }

}
