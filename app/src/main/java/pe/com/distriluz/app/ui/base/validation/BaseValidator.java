package pe.com.distriluz.app.ui.base.validation;

import androidx.annotation.NonNull;

import io.reactivex.Completable;

/***
 * Base class for validators of a view state.
 *
 * @param <S> The state class to be validated
 */
public abstract class BaseValidator<S> {

    /***
     * Validates the state.
     *
     * @param state The state to be validated.
     * @return A Completable that completes when the state is valid and
     *     provides a ValidationException in onError when the state is invalid.
     */
    public final Completable validate(@NonNull S state) {
        return Completable.fromAction(() -> validateState(state));
    }

    /***
     * Implement this method to validate the state. Here you can also
     * set error fields, e.g. for showing errors on an EditText.
     * If the state is invalid, throw a ValidationException.
     *
     * @param state The state to be validated.
     * @throws ValidationException When the state is invalid.
     */
    protected abstract void validateState(@NonNull S state) throws ValidationException;
}
