package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.HashMap;
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
            className = className.substring(0, className.length() - "Interface".length());
        }
        //beanName.toLowerCase()

        BeanDefinition beanDefinition = registry.getBeanDefinition(className);
        if ("singleton".equals(beanDefinition.getScope())
                && map.containsKey(beanDefinition.getId())) {
            return map.get(beanDefinition.getId());
        }
        Object instance;
        try {
            Class<?> aClass = Class.forName(beanDefinition.getClassName());
            instance = aClass.newInstance();
            Field f;
            boolean isNotUsedProperty = true;
            if (beanDefinition.getProperties() != null) {
                for (BeanPropertyDefinition definition : beanDefinition.getProperties()) {
                    try {
                        f = aClass.getDeclaredField(definition.getName());
                        f.setAccessible(true);
                        if (definition.getValue() != null) {
                            isNotUsedProperty = false;
                            Class classField = f.getType();
                            if ("int".equals(classField.toString())) {
                                // f.setInt(instance,);
                            }
                        }

                    } catch (NoSuchFieldException ignored) {
                        ignored.printStackTrace();
                    }
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
