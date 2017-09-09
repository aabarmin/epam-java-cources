package com.epam.university.java.project.core.cdi.impl;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;
import com.epam.university.java.project.core.cdi.bean.InitializingBean;
import com.epam.university.java.project.core.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ABarmin
 */
public class DefaultBeanFactory implements BeanFactory {
    private final BeanDefinitionRegistry registry;

    public DefaultBeanFactory(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    private <T> T getBean(final BeanDefinition definition) {
        try {
            final String beanClassName = definition.getClassName();
            final Class<T> beanClass = (Class<T>) Class.forName(beanClassName);
            final T instance =  beanClass.newInstance();

            // injecting dependencies
            for (BeanPropertyDefinition property : definition.getProperties()) {
                final Field beanField = beanClass.getDeclaredField(property.getName());
                if (beanField == null) {
                    throw new RuntimeException(String.format(
                            "Can't get property with name %s of bean %s",
                            property.getName(),
                            definition.getClassName()
                    ));
                }
                beanField.setAccessible(true);
                // check if we have no value and ref
                if (StringUtils.isEmpty(property.getValue()) && StringUtils.isEmpty(property.getRef())) {
                    throw new RuntimeException(String.format(
                            "Definition of property %s of bean %s is invalid",
                            property.getName(),
                            definition.getClassName()
                    ));
                }
                // we have string property to inject
                if (StringUtils.isNotEmpty(property.getValue())) {
                    final String propertyValue = property.getValue();
                    beanField.set(instance, propertyValue);
                } else if (StringUtils.isNotEmpty(property.getRef())) {
                    final Object dependentBean = getBean(property.getRef());
                    beanField.set(instance, dependentBean);
                }
            }

            // invocation of post-construct method
            if (StringUtils.isNotEmpty(definition.getPostConstruct())) {
                final Method method = beanClass.getDeclaredMethod(definition.getPostConstruct());
                if (method == null) {
                    throw new RuntimeException(String.format(
                            "Can't get post-construct method %s of bean %s",
                            definition.getPostConstruct(),
                            definition.getClassName()
                    ));
                }
                method.invoke(instance);
            }

            // if bean is instance of InitializingBean, invoke callback
            if (instance instanceof InitializingBean) {
                final InitializingBean initializingBean = (InitializingBean) instance;
                initializingBean.afterPropertiesSet();
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public Object getBean(String beanName) {
        final BeanDefinition definition = registry.getBeanDefinition(beanName);
        if (definition == null) {
            throw new RuntimeException(String.format(
                    "Can't get bean definition with name %s",
                    beanName
            ));
        }
        return getBean(definition);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
