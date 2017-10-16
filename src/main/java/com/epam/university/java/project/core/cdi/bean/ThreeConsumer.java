package com.epam.university.java.project.core.cdi.bean;

import java.util.Objects;

@FunctionalInterface
public interface ThreeConsumer<T, E, V> {
    void accept(T var1, E var2, V var3);

    default ThreeConsumer<T, E, V> andThen(ThreeConsumer<? super T, ? super E, ? super V> var1) {
        Objects.requireNonNull(var1);
        return (var2, var3, var4) -> {
            this.accept(var2, var3, var4);
            var1.accept(var2, var3, var4);
        };
    }
}
