package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage of context's bean definitions.
 */
public class DefaultBeanDefinitionRegistry implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> storage = new HashMap<>();

    /**
     * Add bean definition to registry.
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        if (StringUtils.isNonEmpty(definition.getId())) {
            // store by name
            storage.put(definition.getId(), definition);
        }
        if (StringUtils.isNonEmpty(definition.getClassName())) {
            // store by class name
            storage.put(definition.getClassName(), definition);
            try {
                final Class<?> beanClass = Class.forName(definition.getClassName());
                final Class<?> beanClassSuperclass = beanClass.getSuperclass();
                // store by superclass name
                if (beanClassSuperclass != null && beanClassSuperclass != Object.class) {
                    storage.put(beanClassSuperclass.getName(), definition);
                }
                final Class<?>[] beanClassInterfaces = beanClass.getInterfaces();
                // store by names of implemented interfaces
                if (beanClassInterfaces != null) {
                    for (Class<?> bci : beanClassInterfaces) {
                        if (bci != null) {
                            storage.put(bci.getName(), definition);
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get bean definition by id from registry.
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return storage.get(beanId);
    }

}
