package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory {
    private final Map<String, Object> singletones = new HashMap<>();
    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public BeanFactoryImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        try {
            return getBean(beanDefinitionRegistry.getBeanDefinition(beanClass.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getBean(String beanName) {
        try {
            return getBean(beanDefinitionRegistry.getBeanDefinition(beanName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }

    @SuppressWarnings("unchecked")
    private <T> T getBean(BeanDefinition beanDefinition) throws Exception {
        final String id = beanDefinition.getId();
        final String className = beanDefinition.getClassName();
        final String postConstruct;
        if (beanDefinition.getPostConstruct() == null) {
            postConstruct = "";
        } else {
            postConstruct = beanDefinition.getPostConstruct();
        }
        final Class<T> bClass = (Class<T>) Class.forName(className);
        final T bean = bClass.newInstance();
        if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
            if (singletones.containsKey(id)) {
                return (T) singletones.get(id);
            } else {
                singletones.put(id, bean);
            }
        }
        for (BeanPropertyDefinition beanPropertyDefinition : beanDefinition.getProperties()) {
            final Field field
                    = bClass.getDeclaredField(beanPropertyDefinition.getName());
            field.setAccessible(true);
            final String value;
            if (beanPropertyDefinition.getValue() == null) {
                value = "";
            } else {
                value = beanPropertyDefinition.getValue();
            }
            final String ref;
            if (beanPropertyDefinition.getRef() == null) {
                ref = "";
            } else {
                ref = beanPropertyDefinition.getRef();
            }
            final StructureDefinition data = beanPropertyDefinition.getData();
            if (!value.trim().isEmpty()) {
                if (field.getType().isAssignableFrom(Integer.TYPE)) {
                    field.set(bean, Integer.parseInt(value));
                } else if (field.getType().isAssignableFrom(Long.TYPE)) {
                    field.set(bean, Long.parseLong(value));
                } else if (field.getType().isAssignableFrom(Float.TYPE)) {
                    field.set(bean, Float.parseFloat(value));
                } else if (field.getType().isAssignableFrom(Double.TYPE)) {
                    field.set(bean, Double.parseDouble(value));
                } else {
                    field.set(bean, value);
                }
            } else if (!ref.trim().isEmpty()) {
                field.set(bean, getBean(ref));
            } else if (data != null) {
                if (data instanceof ListDefinition) {
                    ListDefinition listDefinition = (ListDefinition) data;
                    List<Object> list = new ArrayList<>();
                    for (ListDefinition.ListItemDefinition itemDefinition
                            : listDefinition.getItems()) {
                        list.add(itemDefinition.getValue());
                    }
                    field.set(bean, list);
                } else if (data instanceof MapDefinition) {
                    MapDefinition mapDefinition = (MapDefinition) data;
                    Map<Object, Object> map = new HashMap<>();
                    for (MapDefinition.MapEntryDefinition entryDefinition
                            : mapDefinition.getValues()) {
                        final String entryKey = entryDefinition.getKey();
                        final String entryValue;
                        if (entryDefinition.getValue() == null) {
                            entryValue = "";
                        } else {
                            entryValue = entryDefinition.getValue();
                        }
                        final String entryRef;
                        if (entryDefinition.getRef() == null) {
                            entryRef = "";
                        } else {
                            entryRef = entryDefinition.getRef();
                        }
                        if (!entryValue.trim().isEmpty()) {
                            map.put(entryKey, entryValue);
                        } else if (!entryRef.trim().isEmpty()) {
                            map.put(entryKey, getBean(entryRef));
                        } else {
                            throw new RuntimeException("Doesn't received value"
                                    + " for the property in bean ");
                        }
                    }
                    field.set(bean, map);
                } else {
                    throw new RuntimeException("Incorrect instance of StructureDefinition");
                }
            } else {
                throw new RuntimeException("Doesn't received value for the property in bean");
            }
        }
        if (!postConstruct.trim().isEmpty()) {
            bClass.getDeclaredMethod(postConstruct).invoke(bean);
        }
        if (InitializingBean.class.isAssignableFrom(bClass)) {
            ((InitializingBean) bean).afterPropertiesSet();
        }
        return bean;
    }
}