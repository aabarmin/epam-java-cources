package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;


public class BeanDefinitionToClassRepositoryImpl implements BeanDefinitionToClassRepository {
    private final Map<Class<?>, String> repository = new HashMap<>();

    /**
     * Get beanId from class.
     * @param clazz class instance
     * @return beanId
     */
    @Override
    public String getBeanId(Class<?> clazz) {
        return repository.get(clazz);
    }

    /**
     * Put new entry in repository.
     * @param clazz bean class
     * @param beanId beanId
     */
    @Override
    public void putBean(Class<?> clazz, String beanId) {
        repository.put(clazz, beanId);
    }
}
