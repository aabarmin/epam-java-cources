package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Romin Nuro on 24.09.2020 16:16.
 */
public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionToClassRepository repository;
    private final BeanDefinitionRegistry registry;
    private final Map<Class<?>, Object> singletons = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionToClassRepository repository,
                           BeanDefinitionRegistry registry) {
        this.repository = repository;
        this.registry = registry;
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        if (singletons.containsKey(beanClass)) {
            return (T) singletons.get(beanClass);
        }
        String beanId = repository.getBeanId(beanClass);
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanId);
        if (beanClass.isInterface()) {
            try {
                beanClass = (Class<T>) Class.forName(beanDefinition.getClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        T bean = null;
        try {
            bean = beanClass.getConstructor().newInstance();
            Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();
            if (properties != null && properties.size() > 0) {
                for (BeanPropertyDefinition property : properties) {
                    Object value;
                    Field field = beanClass.getDeclaredField(property.getName());
                    Class<?> type = field.getType();
                    String referenceId = property.getRef();
                    if (property.getRef() != null) {
                        value = getBean(referenceId);
                        field.setAccessible(true);
                        field.set(bean, value);
                        continue;
                    }
                    if (type.equals(int.class)) {
                        value = Integer.parseInt(property.getValue());
                    } else {
                        value = property.getValue();
                    }
                    field.setAccessible(true);
                    if (value == null) {
                        throw new RuntimeException();
                    }
                    field.set(bean, value);
                }
            }
            if (beanDefinition.getPostConstruct() != null) {
                beanClass.getMethod(beanDefinition.getPostConstruct()).invoke(bean);
            }
            if (beanDefinition.getScope() != null
                    && beanDefinition.getScope().equals("singleton")) {
                singletons.put(beanClass, bean);
            }
        } catch (ReflectiveOperationException e) {
            System.err.println("Something gone wrong with reflection!");
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        Class<?> beanClass = null;
        try {
            beanClass = Class.forName(beanDefinition.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return getBean(beanClass);
    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return getBean(beanClass);
    }
}
