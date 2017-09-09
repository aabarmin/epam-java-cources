package com.epam.university.java.project.core.cdi.impl;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

/**
 * Demo implementation of application context.
 */
public class XmlApplicationContext implements ApplicationContext {
    private final BeanDefinitionReader beanDefinitionReader;
    private final BeanDefinitionRegistry registry;
    private final BeanFactory beanFactoryDelegate;

    public XmlApplicationContext() {
        registry = new DefaultBeanDefinitionRegistry();
        beanFactoryDelegate = new DefaultBeanFactory(registry);
        beanDefinitionReader = new XmlBeanDefinitionReader(registry);
    }

    public XmlApplicationContext(Resource resource) {
        this();
        beanDefinitionReader.loadBeanDefinitions(resource);
    }

    public XmlApplicationContext(Collection<Resource> resources) {
        this();
        beanDefinitionReader.loadBeanDefinitions(resources);
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return beanFactoryDelegate.getBean(beanClass);
    }

    @Override
    public Object getBean(String beanName) {
        return beanFactoryDelegate.getBean(beanName);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        return beanDefinitionReader.loadBeanDefinitions(resource);
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return beanDefinitionReader.loadBeanDefinitions(resources);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return beanFactoryDelegate.getBean(beanName, beanClass);
    }
}
