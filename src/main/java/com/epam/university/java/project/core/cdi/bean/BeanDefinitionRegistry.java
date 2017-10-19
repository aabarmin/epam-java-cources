package com.epam.university.java.project.core.cdi.bean;

/**
 * Storage of context's bean definitions.
 */
public interface BeanDefinitionRegistry {
    /**
     * Add bean definition to registry.
     * @param definition bean definition object
     */
    void addBeanDefinition(BeanDefinition definition);

    /**
     * Get bean definition by id from registry.
     * @param beanId bean id
     * @return bean definition
     */
    BeanDefinition getBeanDefinition(String beanId);
}
