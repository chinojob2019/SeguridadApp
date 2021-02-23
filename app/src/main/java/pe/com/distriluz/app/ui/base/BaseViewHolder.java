package pe.com.distriluz.app.ui.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import pe.com.distriluz.app.injection.components.DaggerViewHolderComponent;
import pe.com.distriluz.app.injection.components.ViewHolderComponent;
import pe.com.distriluz.app.ui.base.view.MvvmView;
import pe.com.distriluz.app.ui.base.viewmodel.MvvmViewModel;
import pe.com.distriluz.app.ui.base.viewmodel.NoOpViewModel;
import pe.com.distriluz.app.utils.Utils;


/* Base class for ViewHolders when using a view model with data binding.
 * This class provides the binding and the view model to the subclass. The
 * view model is injected and the binding is created when the content view is bound.
 * Each subclass therefore has to call the following code in the constructor:
 *    viewHolderComponent().inject(this);
 *    bindContentView(view);
 *
 * After calling these methods, the binding and the view model is initialized.
 * saveInstanceState() and restoreInstanceState() are not called/used for ViewHolder
 * view models.
 *
 * Your subclass must implement the MvvmView implementation that you use in your
 * view model. */
public abstract class BaseViewHolder<B extends ViewDataBinding, V extends MvvmViewModel> extends RecyclerView.ViewHolder {

    protected final View itemView;
    protected B binding;
    @Inject
    protected V viewModel;
    private ViewHolderComponent viewHolderComponent;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    protected final ViewHolderComponent viewHolderComponent() {
        if (viewHolderComponent == null) {
            viewHolderComponent = DaggerViewHolderComponent.builder()
                    .activityComponent(Utils.castActivityFromContext(itemView.getContext(), BaseActivity.class).activityComponent())
                    .build();
        }

        return viewHolderComponent;
    }

    protected final void bindContentView(@NonNull View view) {
        if (viewModel == null) {
            throw new IllegalStateException("viewModel must not be null and should be injected via viewHolderComponent().inject(this)");
        }
        binding = DataBindingUtil.bind(view);
        binding.setVariable(pe.com.distriluz.app.BR.vm, viewModel);

        try {
            //noinspection unchecked
            viewModel.attachView((MvvmView) this, null);
        } catch (ClassCastException e) {
            if (!(viewModel instanceof NoOpViewModel)) {
                throw new RuntimeException(getClass().getSimpleName() + " must implement MvvmView subclass as declared in " + viewModel.getClass().getSimpleName());
            }
        }
    }

    public final V viewModel() {
        return viewModel;
    }

    public final void executePendingBindings() {
        if (binding != null) {
            binding.executePendingBindings();
        }
    }
}
