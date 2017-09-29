package com.epam.university.java.project.core.cdi.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Александр on 29.09.2017.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    Set<BeanDefinition> beanDefinitions;

    public BeanDefinitionRegistryImpl(){
        beanDefinitions = new HashSet<>();
    }
    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        beanDefinitions.add(definition);
    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitions.stream()
                .filter(v -> (v.getId() == beanId))
                .findFirst()
                .orElse(null);
    }
}
