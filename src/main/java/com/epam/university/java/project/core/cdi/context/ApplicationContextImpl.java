package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReaderImpl;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

/**
 * Implementation class for ApplicationContext.
 *
 * @author Sergei Titov
 */
public class ApplicationContextImpl implements ApplicationContext {

    BeanDefinitionReader beanDefinitionReader = new BeanDefinitionReaderImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        return beanDefinitionReader.loadBeanDefinitions(resource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }

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
