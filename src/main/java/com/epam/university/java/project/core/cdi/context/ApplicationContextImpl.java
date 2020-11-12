package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {

    private final BeanDefinitionReader beanDefinitionReader;
    private final BeanDefinitionRegistry beanDefinitionRegistry;
    private final BeanFactory beanFactory;

    public ApplicationContextImpl() {
        this.beanDefinitionRegistry = new BeanDefinitionRegistryImpl();
        this.beanDefinitionReader = new BeanDefinitionReaderImpl(beanDefinitionRegistry);
        this.beanFactory = new BeanFactoryImpl(beanDefinitionRegistry);
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
    public <T> T getBean(Class<T> beanClass) {
        return beanFactory.getBean(beanClass);
    }

    @Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return beanFactory.getBean(beanName, beanClass);
    }
}
