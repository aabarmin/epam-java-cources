package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beans = new HashMap<>();

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        beans.put(definition.getId(), definition);
        
        //TODO: Problem of overriding if several classes implements one interface
        //trying to associate beans definition with it's interfaces names
        try {
            Class<?>[] interfaces = Class.forName(definition.getClassName()).getInterfaces();
            for (Class<?> currInterface : interfaces) {
                String interfaceId = currInterface.getSimpleName().substring(0, 1).toLowerCase()
                        + currInterface.getSimpleName().substring(1);
                beans.put(interfaceId, definition);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
        return beans.get(beanId);
    }
}
