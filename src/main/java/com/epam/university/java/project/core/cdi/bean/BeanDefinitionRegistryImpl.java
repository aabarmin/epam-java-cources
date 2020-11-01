package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    Map<String, BeanDefinition> register = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        register.put(definition.getId(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return register.get(beanId);
    }
}
