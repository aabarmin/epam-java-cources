package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
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
            Class<?> objClass = Class.forName(definition.getClassName());
            Object object = objClass.newInstance();

            if (definition.getProperties() != null) {
                for (BeanPropertyDefinition propertyDefinition : definition.getProperties()) {
                    //check for valid property
                    if (propertyDefinition.getValue() == null
                            && propertyDefinition.getRef() == null
                            && propertyDefinition.getData() == null) {
                        throw new RuntimeException("Illegal property was found.");
                    }

                    //fill up collection for factoring object
                    Collection<String> list = new LinkedList<>();
                    Map<Object, Object> map = new HashMap<>();
                    if (propertyDefinition.getData() != null) {
                        fillData(propertyDefinition, list, map);
                    }

                    String propertyName = propertyDefinition.getName();
                    String propertyValue = propertyDefinition.getValue();

                    //find setter for the property
                    Method method = new PropertyDescriptor(propertyName, objClass).getWriteMethod();

                    //choosing the correct type to inject property
                    Class methodParamType = method.getParameterTypes()[0];
                    if (methodParamType.isPrimitive()) {
                        if (methodParamType == int.class) {
                            method.invoke(object, Integer.parseInt(propertyValue));
                        } else if (methodParamType == double.class) {
                            method.invoke(object, Double.parseDouble(propertyValue));
                        }
                    } else if (methodParamType.equals(String.class)) {
                        method.invoke(object, propertyValue);
                    } else if (methodParamType.equals(Collection.class)) {
                        method.invoke(object, list);
                    } else if (methodParamType.equals(Map.class)) {
                        method.invoke(object, map);
                    } else {
                        method.invoke(object, getBean(propertyDefinition.getRef()));
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

    /**
     * Filling up the data for factoring class from property definition.
     *
     * @param property   property definition where data is recorded
     * @param listToFill list to fill
     * @param mapToFill  map to fill
     */
    private void fillData(BeanPropertyDefinition property,
                          Collection<String> listToFill,
                          Map<Object, Object> mapToFill) {
        //fill list or map from property definition
        if (property.getData() instanceof ListDefinition) {
            ListDefinition list = (ListDefinition) property.getData();
            //fill the list
            for (ListDefinition.ListItemDefinition item : list.getItems()) {
                listToFill.add(item.getValue());
            }
        } else if (property.getData() instanceof MapDefinition) {
            MapDefinition map = (MapDefinition) property.getData();
            //fill the map
            for (MapDefinition.MapEntryDefinition entry : map.getValues()) {
                if (entry.getRef() == null) {
                    mapToFill.put(entry.getKey(), entry.getValue());
                } else {
                    mapToFill.put(entry.getKey(), getBean(entry.getRef()));
                }
            }
        }
    }
}
