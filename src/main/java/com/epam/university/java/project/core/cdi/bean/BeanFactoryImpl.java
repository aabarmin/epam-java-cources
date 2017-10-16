package com.epam.university.java.project.core.cdi.bean;

/**
 * Created by Вера on 16.10.2017.
 */
public class BeanFactoryImpl implements BeanFactory {
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
