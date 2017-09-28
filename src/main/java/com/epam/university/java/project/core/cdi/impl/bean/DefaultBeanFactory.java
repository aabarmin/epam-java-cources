package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;
import com.epam.university.java.project.core.cdi.bean.InitializingBean;
import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.utils.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Create bean instances by definitions.
 */
public class DefaultBeanFactory implements BeanFactory {

    private final BeanDefinitionRegistry registry;
    private final Map<BeanDefinition, Object> singletons;
    private static final String singletonScope = "singleton";

    public DefaultBeanFactory(BeanDefinitionRegistry registry) {
        this.registry = registry;
        singletons = new HashMap<>();
    }

    /**
     * Get bean instances by bean definition.
     * @param definition bean class to get
     * @param <T> bean type
     * @return bean instance
     */
    @SuppressWarnings("unchecked")
    private <T> T getBean(final BeanDefinition definition) {
        try {
            final String beanClassName = definition.getClassName();
            final Class<T> beanClass = (Class<T>) Class.forName(beanClassName);
            final T instance;
            if (singletonScope.equals(definition.getScope())
                && singletons.containsKey(definition)) {
                instance = (T) singletons.get(definition);
            } else {
                instance = beanClass.newInstance();
                if (singletonScope.equals(definition.getScope())) {
                    singletons.put(definition, instance);
                }
            }
            // inject dependencies
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

                if (StringUtils.isEmpty(property.getValue())
                    && StringUtils.isEmpty(property.getRef())
                    && property.getData() == null) {
                    throw new RuntimeException(String.format(
                        "Definition of property %s of bean %s is invalid",
                        property.getName(),
                        definition.getClassName()
                    ));
                }

                if (StringUtils.isNonEmpty(property.getValue())) {
                    try {
                        beanField.set(instance, Integer.parseInt(property.getValue()));
                    } catch (Exception ignored) {
                        beanField.set(instance, property.getValue());
                    }
                } else if (StringUtils.isNonEmpty(property.getRef())) {
                    Object dependency = getBean(property.getRef());
                    beanField.set(instance, dependency);
                } else if (property.getData() != null) {
                    if (property.getData() instanceof ListDefinition) {
                        ListDefinition listDefinition = (ListDefinition) property.getData();
                        if (listDefinition.getItems() == null) {
                            throw new RuntimeException(String.format(
                                "Definition of property %s of bean %s is invalid",
                                property.getName(),
                                definition.getClassName()
                            ));
                        }
                        Collection<String> items = new ArrayList<>();
                        for (ListDefinition.ListItemDefinition itemDefinition
                            : listDefinition.getItems()) {
                            items.add(itemDefinition.getValue());
                        }
                        beanField.set(instance, items);
                    } else if (property.getData() instanceof MapDefinition) {
                        MapDefinition mapDefinition = (MapDefinition) property.getData();
                        Map<String, Object> itemMap = new HashMap<>();
                        for (MapDefinition.MapEntryDefinition entryDefinition
                            : mapDefinition.getValues()) {
                            if (StringUtils.isEmpty(entryDefinition.getKey())
                                || StringUtils.isEmpty(entryDefinition.getValue())
                                && StringUtils.isEmpty(entryDefinition.getRef())) {
                                throw new RuntimeException(String.format(
                                    "Definition of property %s of bean %s is invalid",
                                    property.getName(),
                                    definition.getClassName()
                                ));
                            }

                            if (StringUtils.isNonEmpty(entryDefinition.getValue())) {
                                itemMap.put(entryDefinition.getKey(), entryDefinition.getValue());
                            } else if (StringUtils.isNonEmpty(entryDefinition.getRef())) {
                                Object dependency = getBean(entryDefinition.getRef());
                                itemMap.put(entryDefinition.getKey(), dependency);
                            }
                        }
                        beanField.set(instance, itemMap);
                    }
                }
            }

            if (StringUtils.isNonEmpty(definition.getPostConstruct())) {
                final Method method =
                    beanClass.getDeclaredMethod(definition.getPostConstruct());
                if (method == null) {
                    throw new RuntimeException(String.format(
                        "Can't get post-construct method %s of bean %s",
                        definition.getPostConstruct(),
                        definition.getClassName()
                    ));
                }
                method.invoke(instance);
            }

            if (instance instanceof InitializingBean) {
                final InitializingBean initializingBean = (InitializingBean) instance;
                initializingBean.afterPropertiesSet();
            }

            return instance;

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
            | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get bean instances by class.
     * @param beanClass bean class to get
     * @param <T> bean type
     * @return bean instance
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    /**
     * Get bean instance by  definition name.
     * @param beanName bean definition name
     * @return bean instance
     */
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

    /**
     * Get bean instance by definition name and target class.
     * @param beanName bean definition name
     * @param beanClass target bean class
     * @param <T> bean type
     * @return bean instance
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }

}
