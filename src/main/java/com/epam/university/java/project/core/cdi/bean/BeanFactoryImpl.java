package com.epam.university.java.project.core.cdi.bean;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanFactoryImpl implements BeanFactory {

    BeanDefinitionRegistry registry;

    public BeanFactoryImpl(
        BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
