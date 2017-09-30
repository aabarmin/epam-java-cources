package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;

public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionRegistry beanRegistry;

    public BeanFactoryImpl(BeanDefinitionRegistry beanRegistry) {
        this.beanRegistry = beanRegistry;
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    //TODO: Suppress warnings or code duplicates
    @Override
    public <T> T getBean(Class<T> beanClass) {
        String beanName = beanClass.getSimpleName().substring(0, 1).toLowerCase()
                + beanClass.getSimpleName().substring(1);
        return (T) getBean(beanName);
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        try {
            BeanDefinition beanDefinition = beanRegistry.getBeanDefinition(beanName);
            Object object = Class.forName(beanDefinition.getClassName()).newInstance();

            //TODO: if ref?
            for (BeanPropertyDefinition beanPropertyDefinition : beanDefinition.getProperties()) {
                String propertyName = beanPropertyDefinition.getName();
                String propertyValue = beanPropertyDefinition.getValue();
                Method[] methods = object.getClass().getDeclaredMethods();

                for (Method method : methods) {
                    if (method.getName().equals("set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1))) {
                        Class[] paramTypes = method.getParameterTypes();
                        if (paramTypes.length > 0) {
                            if (paramTypes[0].equals(Integer.TYPE)) {
                                method.invoke(object, Integer.parseInt(propertyValue));
                            } else if (paramTypes[0].equals(String.class)) {
                                method.invoke(object, propertyValue);
                            } else {
                                method.invoke(object, getBean(beanPropertyDefinition.getRef()));
                            }
                        }
                    }
                }
            }

            return object;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    //TODO: Suppress warnings or code duplicates
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
