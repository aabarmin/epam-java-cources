package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BeanPropertiesSetterImpl implements BeanPropertiesSetter {


    @Override
    public void setValue(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException {
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
    public void setReference(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException {
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
    public void setComplexData(Object bean,
                               Field field,
                               BeanPropertyDefinition property,
                               BeanFactory factory) throws IllegalAccessException {
        if (field.getName().equalsIgnoreCase("stringCollection")) {
            Collection<String> stringCollection = new ArrayList<>();
            ListDefinition data = (ListDefinition) property.getData();
            Collection<ListDefinition.ListItemDefinition> items = data.getItems();
            for (ListDefinition.ListItemDefinition item : items) {
                stringCollection.add(item.getValue());
            }
            field.setAccessible(true);
            field.set(bean, stringCollection);
        } else if (field.getName().equalsIgnoreCase("stringMap")) {
            Map<String, String> stringMap = new HashMap<>();
            MapDefinition data = (MapDefinition) property.getData();
            Collection<MapDefinition.MapEntryDefinition> values = data.getValues();
            for (MapDefinition.MapEntryDefinition value : values) {
                stringMap.put(value.getKey(), value.getValue());
            }
            field.setAccessible(true);
            field.set(bean, stringMap);
        } else if (field.getName().equalsIgnoreCase("objectMap")) {
            Map<String, Object> objectMap = new HashMap<>();
            MapDefinition data = (MapDefinition) property.getData();
            Collection<MapDefinition.MapEntryDefinition> values = data.getValues();
            for (MapDefinition.MapEntryDefinition value : values) {
                objectMap.put(value.getKey(), factory.getBean(value.getRef()));
            }
            field.setAccessible(true);
            field.set(bean, objectMap);
        }

    }
}
