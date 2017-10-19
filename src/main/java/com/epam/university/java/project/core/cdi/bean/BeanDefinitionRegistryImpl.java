package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 29.09.2017.
 * Bean registry with find by class name
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final List<BeanDefinition> storage = new ArrayList<>();



    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        storage.add(definition);
    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return storage.stream()
                .filter(v -> (v.getId().equals(beanId)))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get bean definition by class from registry.
     *
     * @param clazz bean class
     * @return bean definition
     */
    @SuppressWarnings("unchecked")
    public BeanDefinition getBeanDefinition(Class clazz) {
        for (BeanDefinition v : storage) {
            try {
                if (clazz.isAssignableFrom(Class.forName(v.getClassName()))) {
                    return v;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
