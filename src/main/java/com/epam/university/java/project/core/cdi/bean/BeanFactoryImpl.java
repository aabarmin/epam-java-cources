package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;

public class BeanFactoryImpl implements BeanFactory {

    private final BeanDefinitionRegistry registry;
    private final ArrayList<BeanDefinition> singletonBeans;

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.singletonBeans = new ArrayList<>();
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(registry.getBeanDefinition(beanClass.getName()));
    }

    @Override
    public Object getBean(String beanName) {
        return getBean(registry.getBeanDefinition(beanName));
    }


    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return getBean(registry.getBeanDefinition(beanName));
    }

    private <T> T getBean(BeanDefinition beanDefinition) {

        if (beanDefinition == null) {
            throw new IllegalArgumentException();
        }
        try {
            T instance;
            Class<T> instanceClass = (Class<T>) Class.forName(beanDefinition.getClassName());

            if ("singleton".equalsIgnoreCase(beanDefinition.getScope())
                    && singletonBeans.contains(beanDefinition)) {

            }


            if ("parentBean".equals(beanDefinition.getId())) {

            }

        } catch (Exception e) {

        }


        return null;
    }
}
