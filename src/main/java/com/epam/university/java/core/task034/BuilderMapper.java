package com.epam.university.java.core.task034;

public interface BuilderMapper<T> {

    T get();

    BuilderMapper<T> set(String tag, String value);

}
