package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> registry = new HashMap<>();

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {

        String beanId = definition.getId();

        if (beanId == null || beanId.trim().isEmpty()) {
            throw new RuntimeException("beanId is not provided");
        }

        registry.put(beanId, definition);

    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        BeanDefinition beanDefinition = registry.get(beanId);

        if (beanDefinition == null) {

            Class<?> beanClass;

            try {
                beanClass = Class.forName(beanId);
            } catch (ClassNotFoundException e) {
                return null;
            }

            for (BeanDefinition registryBeanDefinition : registry.values()) {

                Class<?> registryBeanClass;

                try {
                    registryBeanClass = Class.forName(registryBeanDefinition.getClassName());

                    if (beanClass.isAssignableFrom(registryBeanClass)) {
                        beanDefinition = registryBeanDefinition;
                        break;
                    }

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Can't find class: "
                            + registryBeanDefinition.getClassName());
                }

            }

        }

        return beanDefinition;

    }

}
