package com.epam.university.java.project.core.cdi.impl;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.utils.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ABarmin
 */
public class DefaultBeanDefinitionRegistry implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> storage = new ConcurrentHashMap<>();

    @Override
    public void addBeanDefinition(final BeanDefinition definition) {
        if (StringUtils.isNotEmpty(definition.getId())) {
            storage.put(definition.getId(), definition);
        }
        if (StringUtils.isNotEmpty(definition.getClassName())) {
            storage.put(definition.getClassName(), definition);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(final String beanId) {
        return storage.get(beanId);
    }
}
