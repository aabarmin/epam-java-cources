package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class BeanPropertiesSetterImpl implements BeanPropertiesSetter {


    @Override
    public void setValue(Object bean, Field field, BeanPropertyDefinition property) throws IllegalAccessException {
        String value = property.getValue();
        field.setAccessible(true);
        Class<?> type = field.getType();
        if (type.equals(int.class)) {
            field.setInt(bean, Integer.parseInt(value));
        } else {
            field.set(bean, value);
        }
    }

    @Override
    public void setReference(Object bean, Field field, BeanPropertyDefinition property) throws IllegalAccessException {
        String ref = property.getRef();
        Class<?> type = field.getType();
        field.setAccessible(true);
        if (type.equals(Object.class)) {
            try {
                Object o = type.getDeclaredConstructor().newInstance();
                field.set(bean, o);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setComplexData(Object bean, Field field, BeanPropertyDefinition property) throws IllegalAccessException {
        if (field.getName().equalsIgnoreCase("stringCollection")) {
            Collection<String> stringCollection = new ArrayList<>();
            ListDefinition data = (ListDefinition) property.getData();
            Collection<ListDefinition.ListItemDefinition> items = data.getItems();
            for (ListDefinition.ListItemDefinition item : items) {
                stringCollection.add(item.getValue());
            }
            field.setAccessible(true);
            field.set(bean, stringCollection);
        }

    }
}
