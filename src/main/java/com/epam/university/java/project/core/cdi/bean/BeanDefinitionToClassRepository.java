package com.epam.university.java.project.core.cdi.bean;

/**
 * Created by Romin Nuro on 24.09.2020 22:10.
 */
public interface BeanDefinitionToClassRepository {
    /**
     * Get beanId from class.
     * @param clazz class instance
     * @return beanId
     */
    String getBeanId(Class<?> clazz);

    /**
     * Put new entry in repository.
     * @param clazz bean class
     * @param beanId beanId
     */
    void putBean(Class<?> clazz, String beanId);
}
