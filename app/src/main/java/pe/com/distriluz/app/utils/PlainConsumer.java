package pe.com.distriluz.app.utils;

import io.reactivex.functions.Consumer;

public interface PlainConsumer<T> extends Consumer<T> {
    /**
     * Consume the given value.
     *
     * @param t the value
     */
    @Override
    void accept(T t);
}
