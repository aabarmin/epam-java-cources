package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> registry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        try {
            registry.put(definition.getId(), definition);
            registry.put(definition.getClassName(), definition);


            Class<?>[] interfaces = Class.forName(definition.getClassName()).getInterfaces();
            for (Class<?> anInterface : interfaces) {
                registry.put(anInterface.getName(), definition);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return registry.get(beanId);
    }
}
