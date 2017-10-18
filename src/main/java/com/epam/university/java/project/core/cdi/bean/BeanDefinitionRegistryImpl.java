package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        if (!"".equals(definition.getId())) {
            map.put(definition.getId(), definition);
        }
        if (!"".equals(definition.getClassName())) {
            map.put(definition.getClassName(), definition);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String id) {
        BeanDefinition definition = map.get(id);
        if (definition == null) {
            Class<?> bean;
            try {
                bean = Class.forName(id);
            } catch (ClassNotFoundException e) {
                return null;
            }
            for (BeanDefinition registryBeanDefinition : map.values()) {
                Class<?> registryBeanClass;
                try {
                    registryBeanClass = Class.forName(registryBeanDefinition.getClassName());
                    if (bean.isAssignableFrom(registryBeanClass)) {
                        definition = registryBeanDefinition;
                        break;
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return definition;
    }
}