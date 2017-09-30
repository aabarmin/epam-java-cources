package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReaderImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.bean.BeanFactoryImpl;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {
    private final BeanDefinitionReader beanReader;
    private final BeanFactory beanFactory;

    ApplicationContextImpl() {
        BeanDefinitionRegistry beanRegistry = new BeanDefinitionRegistryImpl();
        beanReader = new BeanDefinitionReaderImpl(beanRegistry);
        beanFactory = new BeanFactoryImpl(beanRegistry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        return beanReader.loadBeanDefinitions(resource);
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
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
