package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by Александр on 30.09.2017.
 */
public class BeanFactoryImpl implements BeanFactory {
    BeanDefinitionRegistry registry;

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        //registry.getBeanDefinition()

        return null;
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        BeanDefinition definition = registry.getBeanDefinition(beanName);
        definition.getClassName();

        try {
            Class<?> clazz = Class.forName(beanName);
            Object bean = clazz.newInstance();
            for (BeanPropertyDefinition property : definition.getProperties()) {
                Field field = clazz.getDeclaredField(property.getName());
                field.setAccessible(true);

                if (field.getType().isPrimitive()) {

                } else if (field.getType().equals(String.class)) {

                }

                field.getType().n
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        return null;
    }

    void fieldSetValue(Field field, String value) {

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
        return null;
    }
}
