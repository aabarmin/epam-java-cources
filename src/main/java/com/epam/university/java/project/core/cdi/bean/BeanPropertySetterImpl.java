package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Romin Nuro on 26.09.2020 17:05.
 */
public class BeanPropertySetterImpl implements BeanPropertySetter {
    private final BeanFactory factory;

    public BeanPropertySetterImpl(BeanFactory factory) {
        this.factory = factory;
    }

    @Override
    public void setValue(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException {
        Object value = null;
        Class<?> type = field.getType();
        if (type.equals(int.class)) {
            value = Integer.parseInt(property.getValue());
        } else {
            value = property.getValue();
        }
        if (value == null) {
            throw new RuntimeException();
        }
        field.setAccessible(true);
        field.set(bean, value);
    }

    @Override
    public void setReference(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException {
        Object value = null;
        String referenceId = property.getRef();
        if (property.getRef() != null) {
            value = factory.getBean(referenceId);
            field.setAccessible(true);
            field.set(bean, value);
        }
    }

    @Override
    public void setComplexData(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException {
        if (field.getName().equals("stringMap")) {
            Map<String, String> dataMap = new HashMap<>();
            MapDefinition data = (MapDefinition) property.getData();
            Collection<MapDefinition.MapEntryDefinition> values = data.getValues();
            for (MapDefinition.MapEntryDefinition value : values) {
                if (value.getRef() != null) {
                    throw new RuntimeException();
                }
                dataMap.put(value.getKey(), value.getValue());
            }
            field.setAccessible(true);
            field.set(bean, dataMap);
        }
        if (field.getName().equals("objectMap")) {
            Map<String, Object> dataMap = new HashMap<>();
            MapDefinition data = (MapDefinition) property.getData();
            Collection<MapDefinition.MapEntryDefinition> values = data.getValues();
            for (MapDefinition.MapEntryDefinition value : values) {
                dataMap.put(value.getKey(), factory.getBean(value.getRef()));
            }
            field.setAccessible(true);
            field.set(bean, dataMap);
        }
        if (field.getName().equals("stringCollection")) {
            Collection<String> dataList = new ArrayList<>();
            ListDefinition data = (ListDefinition) property.getData();
            Collection<ListDefinition.ListItemDefinition> items = data.getItems();
            for (ListDefinition.ListItemDefinition item : items) {
                dataList.add(item.getValue());
            }
            field.setAccessible(true);
            field.set(bean, dataList);
        }

    }
}
