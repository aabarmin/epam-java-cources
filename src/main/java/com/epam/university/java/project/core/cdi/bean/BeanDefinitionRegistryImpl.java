package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Romin Nuro on 24.09.2020 0:40.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    Map<String, BeanDefinition> registry = new HashMap<>();
    Map<Class<?>, String> types = new HashMap<>();

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        registry.put(definition.getId(), definition);
    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return registry.get(beanId);
    }
}
