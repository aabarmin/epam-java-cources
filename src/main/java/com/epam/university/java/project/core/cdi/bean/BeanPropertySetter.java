package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;

/**
 * Created by Romin Nuro on 26.09.2020 7:28.
 */
public interface BeanPropertySetter {

    void setValue(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    void setReference(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    void setComplexData(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    //todo implement interface
}
