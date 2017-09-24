package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> registry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        if (!"".equals(definition.getId())) {
            registry.put(definition.getId(), definition);
        }
        if (!"".equals(definition.getClassName())) {
            registry.put(definition.getClassName(), definition);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return registry.get(beanId);
    }
}
