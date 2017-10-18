package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beans = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        beans.put(definition.getId(), definition);

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beans.get(beanId);
    }
}
