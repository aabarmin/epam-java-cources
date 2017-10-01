package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory {
    private BeanDefinitionRegistry registry;
    private Map<String, Object> map = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public Object getBean(String beanName) {
        String className = beanName.substring(beanName.lastIndexOf(".") + 1);
        if (className.endsWith("Interface")) {
            className = className.substring(0, className.length() - 9);
        }
        char[] chars = className.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        String className2 = new String(chars);
        BeanDefinition beanDefinition = registry.getBeanDefinition(className2);
        if ("singleton".equals(beanDefinition.getScope())
                && map.containsKey(beanDefinition.getId())) {
            return map.get(beanDefinition.getId());
        }
        Object instance;
        try {
            Class clazz = Class.forName(beanDefinition.getClassName());
            instance = clazz.newInstance();
            Field f;
            boolean isNotUsedProperty = true;
            if (beanDefinition.getProperties() != null) {
                for (BeanPropertyDefinition beanPropertyDefinition
                        : beanDefinition.getProperties()) {
                    try {
                        f = clazz.getDeclaredField(beanPropertyDefinition.getName());
                        f.setAccessible(true);
                        if (beanPropertyDefinition.getValue() != null) {
                            isNotUsedProperty = false;
                            Class classFiled = f.getType();
                            if (classFiled.toString().equals("int")) {
                                f.setInt(instance,
                                        Integer.valueOf(beanPropertyDefinition.getValue()));
                            } else {
                                f.set(instance, beanPropertyDefinition.getValue());
                            }
                        }
                        if (beanPropertyDefinition.getData() != null) {
                            isNotUsedProperty = false;
                            f.set(instance, beanPropertyDefinition.getData());
                        }
                        if (beanPropertyDefinition.getRef() != null) {
                            isNotUsedProperty = false;
                            f.set(instance, getBean(beanPropertyDefinition.getRef()));
                        }
                        f.setAccessible(false);
                        if (isNotUsedProperty) {
                            throw new RuntimeException(beanPropertyDefinition.getName()
                                    + " has no definition");
                        }
                    } catch (NoSuchFieldException ignored) {
                        ignored.printStackTrace();
                    }
                }
            }
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
        if ("singleton".equals(beanDefinition.getScope())) {
            map.put(beanDefinition.getId(), instance);
        }

        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
