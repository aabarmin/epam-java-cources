package com.epam.university.java.core.task021;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created by ilya on 23.09.17.
 */

@FunctionalInterface
public interface ThreeFunction<T, E> {
    E apply(T var1, T var2, T var3);

    /**
     * Function of three arguments.
     *
     * @param var1 function
     * @param <V> Type of return
     * @return return
     */
    default <V> ThreeFunction<T, V> andThen(Function<? super E, ? extends V> var1) {
        Objects.requireNonNull(var1);
        return (var2, var3, var4) -> {
            return var1.apply(this.apply(var2, var3, var4));
        };
    }

}
