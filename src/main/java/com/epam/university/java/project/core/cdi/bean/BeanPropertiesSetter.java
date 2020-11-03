package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;

public interface BeanPropertiesSetter {
    public void setValue(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    public void setReference(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    public void setComplexData(Object bean,
                               Field field,
                               BeanPropertyDefinition property,
                               BeanFactory factory)
            throws IllegalAccessException;
}
