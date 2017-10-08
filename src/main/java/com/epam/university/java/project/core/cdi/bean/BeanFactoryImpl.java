package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.MapEntryDefinitionImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    public Object getBean(String beanName) {
        String className = beanName.substring(beanName.lastIndexOf(".") + 1);
        if (className.endsWith("Interface")) {
            className = className.substring(0, className.length() - 9);
        }
        char[] chars = className.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        String className2 = new String(chars);
        BeanDefinition beanDefinition = registry.getBeanDefinition(className2);
        if ("singleton".equals(beanDefinition.getScope())
                && map.containsKey(beanDefinition.getId())) {
            return map.get(beanDefinition.getId());
        }
        Object instance;
        Field f;
        try {
            Class clazz = Class.forName(beanDefinition.getClassName());
            instance = clazz.newInstance();
            if (beanDefinition.getProperties() != null) {
                prop:
                for (BeanPropertyDefinition propertyDefinition : beanDefinition.getProperties()) {
                    if (!isCorrectPropDef(propertyDefinition)) {
                        throw new RuntimeException(propertyDefinition.getName()
                                + " has no definition");
                    }
                    f = clazz.getDeclaredField(propertyDefinition.getName());
                    f.setAccessible(true);

                    //Injects propertyDefinitions with Value.
                    if (propertyDefinition.getValue() != null) {
                        if (f.getType().isPrimitive()) {
                            if (f.getType().equals(int.class)) {
                                f.set(instance, Integer.parseInt(propertyDefinition.getValue()));
                            } else if (f.getType().equals(double.class)) {
                                f.set(instance, Double.parseDouble(propertyDefinition.getValue()));
                            }
                        } else if (f.getType().equals(String.class)) {
                            f.set(instance, propertyDefinition.getValue());
                        }
                    }

                    //Injects propertyDefinitions with Data.
                    if (propertyDefinition.getData() != null) {
                        Class propDefClass = propertyDefinition.getData().getClass();
                        for (Method m : propDefClass.getDeclaredMethods()) {

                            // for list
                            if (m.getReturnType().equals(f.getType())
                                    && m.getName().startsWith("get")) {
                                f.set(instance, m.invoke(propertyDefinition.getData()));
                                continue prop;
                            }
                            // for map
                            if (m.getName().startsWith("get")) {
                                //StringMap
                                if (f.getName().startsWith("string")) {
                                    Map<String, String> result =
                                            ((ArrayList<MapEntryDefinitionImpl>) m.invoke(propertyDefinition.getData()))
                                                    .stream().collect(HashMap<String, String>::new,
                                                    (q, c) -> q.put(c.getKey(), c.getValue()),
                                                    (q, u) -> {
                                                    });
                                    f.set(instance, result);
                                }
                                //ObjectMap
                                if (f.getName().startsWith("object")) {
                                    Map<String, Object> result =
                                            ((ArrayList<MapEntryDefinitionImpl>) m.invoke(propertyDefinition.getData()))
                                                    .stream().collect(HashMap<String, Object>::new,
                                                    (q, c) -> q.put(c.getKey(), getBean(c.getRef())),
                                                    (q, u) -> {
                                                    });
                                    f.set(instance, result);
                                }
                            }
                        }
                    }

                    //Injects propertyDefinitions with References.
                    if (propertyDefinition.getRef() != null) {
                        f.set(instance, getBean(propertyDefinition.getRef()));
                    }
                    f.setAccessible(false);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if ("singleton".equals(beanDefinition.getScope())) {
            map.put(beanDefinition.getId(), instance);
        }
        return instance;
    }

    private boolean isCorrectPropDef(BeanPropertyDefinition beanPropertyDefinition) {
        return beanPropertyDefinition.getRef() != null
                || beanPropertyDefinition.getValue() != null
                || beanPropertyDefinition.getData() != null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
