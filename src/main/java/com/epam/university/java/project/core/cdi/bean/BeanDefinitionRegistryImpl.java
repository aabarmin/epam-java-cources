package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> reg = new HashMap<>();
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        reg.put(definition.getId(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return reg.get(beanId);
    }

}
