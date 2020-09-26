package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Romin Nuro on 24.09.2020 0:40.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> registry = new HashMap<>();
    private final BeanDefinitionToClassRepository repository;

    public BeanDefinitionRegistryImpl(BeanDefinitionToClassRepository repository) {
        this.repository = repository;
    }

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        registry.put(definition.getId(), definition);
        Class<?> beanClass = null;
        Class<?> beanInterface = null;
        try {
            beanClass = Class.forName(definition.getClassName());
            if (beanClass.getInterfaces().length > 0) {
                beanInterface = beanClass.getInterfaces()[0];
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        repository.putBean(beanClass, definition.getId());
        if (beanInterface != null) {
            repository.putBean(beanInterface, definition.getId());
        }
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
