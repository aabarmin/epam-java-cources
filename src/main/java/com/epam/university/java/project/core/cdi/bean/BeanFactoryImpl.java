package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionRegistry beanRegistry;
    private final Map<String, Object> singletonInstances;

    public BeanFactoryImpl(BeanDefinitionRegistry beanRegistry) {
        this.beanRegistry = beanRegistry;
        singletonInstances = new HashMap<>();
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    //TODO: Not working with interfaces
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        //return by className
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
        BeanDefinition definition = beanRegistry.getBeanDefinition(beanName);

        //check for already existing instance of singleton
        if ("singleton".equals(definition.getScope())
                && singletonInstances.get(definition.getClassName()) != null) {
            return singletonInstances.get(definition.getClassName());
        }

        try {
            Object object = Class.forName(definition.getClassName()).newInstance();

            for (BeanPropertyDefinition propertyDefinition : definition.getProperties()) {
                String propertyName = propertyDefinition.getName();
                String propertyValue = propertyDefinition.getValue();
                //name of setter method
                String propertySetter = "set"
                        + propertyName.substring(0, 1).toUpperCase()
                        + propertyName.substring(1);

                //find setter for the property
                for (Method method : object.getClass().getDeclaredMethods()) {
                    if (propertySetter.equals(method.getName())) {
                        Class methodParamType = method.getParameterTypes()[0];

                        //choosing the correct action to inject property
                        if (methodParamType.equals(Integer.TYPE)) {
                            method.invoke(object, Integer.parseInt(propertyValue));
                        } else if (methodParamType.equals(String.class)) {
                            method.invoke(object, propertyValue);
                        } else {
                            method.invoke(object, getBean(propertyDefinition.getRef()));
                        }
                    }
                }
            }

            //put singleton in the collection
            if ("singleton".equals(definition.getScope())) {
                singletonInstances.put(definition.getClassName(), object);
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
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        //return by className
        return (T) getBean(beanName);
    }
}
