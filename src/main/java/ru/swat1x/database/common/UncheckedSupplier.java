package ru.swat1x.database.common;

import java.util.function.Supplier;

@FunctionalInterface
public interface UncheckedSupplier<T> extends Supplier<T> {
    T supply() throws Throwable;

    default T get() {
        try {
            return this.supply();
        } catch (Throwable var2) {
            throw new RuntimeException("exception due to supplying", var2);
        }
    }
}
