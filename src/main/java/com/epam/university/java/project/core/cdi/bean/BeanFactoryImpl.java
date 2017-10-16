package com.epam.university.java.project.core.cdi.bean;

/**
 * Implementation class for BeanFactory.
 *
 * @author Sergei Titov
 */
public class BeanFactoryImpl implements BeanFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
