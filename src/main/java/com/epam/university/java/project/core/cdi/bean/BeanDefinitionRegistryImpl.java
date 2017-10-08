package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Александр on 29.09.2017.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> storage = new HashMap<>();

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        //beanDefinitions.add(definition);
    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        System.out.print("1");
        /*return beanDefinitions.stream()
                .filter(v -> (v.getId() == beanId))
                .findFirst()
                .orElse(null);*/
                return null;
    }
}
