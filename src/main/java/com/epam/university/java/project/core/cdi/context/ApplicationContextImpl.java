package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {
    private BeanDefinitionRegistry registry = new BeanDefinitionRegistryImpl();
    private BeanDefinitionReader beanDefinitionReader = new BeanDefinitionReaderImpl(registry);
    private BeanFactory beanFactory = new BeanFactoryImpl(registry);

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
