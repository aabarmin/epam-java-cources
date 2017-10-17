package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.MapEntryDefinitionImpl;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class BeanFactoryImpl implements BeanFactory {
    private BeanDefinitionRegistry registry;
    private Map<String, Object> map = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {

        return (T) getBean(beanName);
    }

    @Override
    public Object getBean(String beanName) {
        String className = beanName.substring(beanName.lastIndexOf(".") + 1);
        if (className.endsWith("Interface")) {
            className = className.substring(0, className.length() - "Interface".length());
        }
        if (className.startsWith("Default")) {
            className = className.substring("Default".length());
        }
        //beanName.toLowerCase()

        BeanDefinition beanDefinition = registry.getBeanDefinition(className.toLowerCase());

        if ("singleton".equals(beanDefinition.getScope())
                && map.containsKey(beanDefinition.getId())) {
            return map.get(beanDefinition.getId());
        }
        Object instance;
        Field f;
        try {
            Class<?> aClass = Class.forName(beanDefinition.getClassName());
            instance = aClass.newInstance();


            if (beanDefinition.getProperties() != null) {
                for (BeanPropertyDefinition definition : beanDefinition.getProperties()) {
                    if (!isPropertyCorrect(definition)) {
                        throw new RuntimeException(definition.getName() + " has no definition");
                    }
                    f = aClass.getDeclaredField(definition.getName());
                    f.setAccessible(true);
                    setPropertyValue(instance, f, definition);
                    setPropertyData(instance, f, definition);

                    //recursive add dependencies
                    if (definition.getRef() != null) {
                        f.set(instance, getBean(definition.getRef()));
                    }
                    f.setAccessible(false);
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if ("singleton".equals(beanDefinition.getScope())) {
            map.put(beanDefinition.getId(), instance);
        }


        return instance;
    }

    private boolean isPropertyCorrect(BeanPropertyDefinition beanPropertyDefinition) {
        return beanPropertyDefinition.getRef() != null
                || beanPropertyDefinition.getValue() != null
                || beanPropertyDefinition.getData() != null;
    }

    /**
     * put property value from definition to field in instance.
     * @param instance object with target field;
     * @param field field in target object;
     * @param definition value for field;
     * @throws IllegalAccessException
     */
    private void setPropertyValue(Object instance, Field field, BeanPropertyDefinition definition) throws IllegalAccessException {
        if (definition.getValue() != null) {
            if (field.getType().isPrimitive()) {
                if ((int.class).equals(field.getType())) {
                    field.set(instance, Integer.parseInt(definition.getValue()));
                } else if ((double.class).equals(field.getType())) {
                    field.set(instance, Double.parseDouble(definition.getValue()));
                }
            } else if ((String.class).equals(field.getType())) {
                field.set(instance, definition.getValue());
            }
        }
    }

    /**
     * put property data to the field in instance.
     * @param instance target bean object;
     * @param field field in target object;
     * @param definition data for field in target object
     * @throws IllegalAccessException when can't find get method for data in definition
     * @throws IntrospectionException then can't find get-method for data in definition
     * @throws InvocationTargetException when field has type incompatible with it's name
     */
    private void setPropertyData(Object instance, Field field, BeanPropertyDefinition definition) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        if (definition.getData() != null) {
            Class propDefClass = definition.getData().getClass();
            Method m = Introspector.getBeanInfo(propDefClass).getPropertyDescriptors()[1].getReadMethod();

            Object result = m.invoke(definition.getData());
            //lists
            if (m.getReturnType().equals(field.getType())) {
                field.set(instance, result);
                return;
            }
            //maps
           if (field.getName().startsWith("string")) {
                Map<Object, Object> resultMap =
                        ((ArrayList<MapEntryDefinitionImpl>) result).stream()
                                .collect(HashMap<Object, Object>::new,
                                        (q, c) -> q.put(c.getKey(),
                                                c.getValue()),
                                        (q, u) -> {
                                        });
                field.set(instance, resultMap);
            }
            if (field.getName().startsWith("object")) {
                Map<String, Object> resultMap =
                        ((ArrayList<MapEntryDefinitionImpl>) result)
                                .stream().collect(HashMap<String, Object>::new,
                                (q, c) -> q.put(c.getKey(),
                                        getBean(c.getRef())),
                                (q, u) -> {
                                });
                field.set(instance, resultMap);
            }


        }

    }

}
