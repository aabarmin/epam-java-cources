package com.epam.university.java.project.core.state.machine.domain;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Romin Nuro on 26.09.2020 22:47.
 */
public class HandlerClassAdapter extends XmlAdapter<String, Class<?>> {
    /**
     * Convert a value type to a bound type.
     *
     * @param v The value to be converted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public Class<?> unmarshal(String v) throws Exception {
        return Class.forName(v);
    }

    /**
     * Convert a bound type to a value type.
     *
     * @param v The value to be convereted. Can be null.
     * @throws Exception if there's an error during the conversion. The caller is responsible for
     *                   reporting the error to the user through {@link ValidationEventHandler}.
     */
    @Override
    public String marshal(Class<?> v) throws Exception {
        return v.getName();
    }
}
