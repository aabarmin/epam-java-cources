package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.core.utils.common.Validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implements <code>BeanDefinitionRegistry</code> interface.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> registry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        Validator.validateNotNull(definition, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        registry.put(definition.getId(), definition);
        registry.put(definition.getClassName(), definition);
        try {
            Class<?> beanClass = Class.forName(definition.getClassName());
            Arrays.stream(beanClass.getInterfaces()).parallel()
                    .forEach(beanInterface -> registry.put(beanInterface
                            .getName(), definition));
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return registry.get(beanId);
    }
}
