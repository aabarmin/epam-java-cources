package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Class implements <code>BeanFactory</code> interface.
 */
public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionRegistry registry;
    private final Map<BeanDefinition, Object> singletons = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @SuppressWarnings("unchecked")
    private <T> T getBean(final BeanDefinition definition) {
        try {
            final Class<T> beanClass = (Class<T>) Class.forName(definition
                    .getClassName());
            final T instance;
            if ("singleton".equals(definition.getScope())
                    && singletons.containsKey(definition)) {
                instance = (T) singletons.get(definition);
            } else {
                instance = beanClass.newInstance();
                if ("singleton".equals(definition.getScope())) {
                    singletons.put(definition, instance);
                }
            }
            for (BeanPropertyDefinition beanPropertyDefinition : definition
                    .getProperties()) {
                final Field beanField = beanClass.getDeclaredField(
                        beanPropertyDefinition.getName());
                if (beanField == null) {
                    throw new RuntimeException();
                }
                beanField.setAccessible(true);
                if (Validator.validateStringEmpty(beanPropertyDefinition
                                .getValue(),
                        Validator.MESSAGE_IF_STRING_EMPTY)
                        && Validator.validateStringEmpty(
                        beanPropertyDefinition.getRef(),
                        Validator.MESSAGE_IF_STRING_EMPTY)
                        && beanPropertyDefinition.getData() == null) {
                    throw new RuntimeException();
                }
                if (!Validator.validateStringEmpty(beanPropertyDefinition
                        .getValue(), Validator.MESSAGE_IF_STRING_EMPTY)) {
                    try {
                        beanField.set(instance, Integer.parseInt(
                                beanPropertyDefinition.getValue()));
                    } catch (Exception ignored) {
                        beanField.set(instance, beanPropertyDefinition
                                .getValue());
                    }
                } else if (!Validator.validateStringEmpty(beanPropertyDefinition
                        .getRef(), Validator.MESSAGE_IF_STRING_EMPTY)) {
                    Object dependency = getBean(beanPropertyDefinition
                            .getRef());
                    beanField.set(instance, dependency);
                } else if (beanPropertyDefinition.getData() != null) {
                    if (beanPropertyDefinition.getData()
                            instanceof ListDefinition) {
                        ListDefinition listDefinition = (ListDefinition)
                                beanPropertyDefinition.getData();
                        if (listDefinition.getItems() == null) {
                            throw new RuntimeException();
                        }
                        Collection<String> items = new ArrayList<>();
                        for (ListDefinition.ListItemDefinition itemDefinition
                                : listDefinition.getItems()) {
                            items.add(itemDefinition.getValue());
                        }
                        beanField.set(instance, items);
                    } else if (beanPropertyDefinition.getData()
                            instanceof MapDefinition) {
                        MapDefinition mapDefinition = (MapDefinition)
                                beanPropertyDefinition.getData();
                        Map<String, Object> itemMap = new HashMap<>();
                        for (MapDefinition.MapEntryDefinition entryDefinition
                                : mapDefinition.getValues()) {
                            if (Validator.validateStringEmpty(
                                    entryDefinition.getKey(), Validator
                                            .MESSAGE_IF_STRING_EMPTY)
                                    || Validator.validateStringEmpty(
                                    entryDefinition.getValue(),
                                    Validator.MESSAGE_IF_STRING_EMPTY)
                                    && Validator.validateStringEmpty(
                                    entryDefinition.getRef(),
                                    Validator
                                            .MESSAGE_IF_STRING_EMPTY)) {
                                throw new RuntimeException();
                            }
                            if (!Validator.validateStringEmpty(
                                    entryDefinition.getValue(), Validator
                                            .MESSAGE_IF_STRING_EMPTY)) {
                                itemMap.put(entryDefinition.getKey(),
                                        entryDefinition.getValue());
                            } else if (!Validator.validateStringEmpty(
                                    entryDefinition.getRef(), Validator
                                            .MESSAGE_IF_STRING_EMPTY)) {
                                Object dependency = getBean(entryDefinition
                                        .getRef());
                                itemMap.put(entryDefinition.getKey(),
                                        dependency);
                            }
                        }
                        beanField.set(instance, itemMap);
                    }
                }
            }
            if (!Validator.validateStringEmpty(definition
                    .getPostConstruct(), Validator.MESSAGE_IF_STRING_EMPTY)) {
                final Method method = beanClass.getDeclaredMethod(definition
                        .getPostConstruct());
                if (method == null) {
                    throw new RuntimeException();
                }
                method.invoke(instance);
            }
            if (instance instanceof InitializingBean) {
                final InitializingBean initializingBean = (InitializingBean)
                        instance;
                initializingBean.afterPropertiesSet();
            }
            return instance;

        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | NoSuchFieldException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public Object getBean(String beanName) {
        final BeanDefinition definition = registry.getBeanDefinition(beanName);
        if (definition == null) {
            throw new RuntimeException();
        }
        return getBean(definition);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}