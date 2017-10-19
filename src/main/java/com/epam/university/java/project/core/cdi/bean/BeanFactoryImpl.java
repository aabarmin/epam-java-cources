package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Александр on 30.09.2017.
 * Bean factory
 */
public class BeanFactoryImpl implements BeanFactory {
    private BeanDefinitionRegistry registry;
    private Map<String, Object> singletons;

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
        singletons = new HashMap<>();
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    //check in getBeanDefinition
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        BeanDefinitionRegistryImpl registryImpl = (BeanDefinitionRegistryImpl) registry;
        BeanDefinition definition = registryImpl.getBeanDefinition(beanClass);
        return (T) getBean(definition.getId());
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

        try {
            Class<?> clazz = Class.forName(definition.getClassName());
            Object beanInstance = clazz.newInstance();

            //scope
            if ("singleton".equals(definition.getScope())) {
                if (singletons.containsKey(definition.getId())) {
                    return singletons.get(definition.getId());
                } else {
                    singletons.put(definition.getId(), beanInstance);
                }
            }


            for (BeanPropertyDefinition property : definition.getProperties()) {
                Field field = clazz.getDeclaredField(property.getName());
                field.setAccessible(true);

                if ((property.getRef() == null)
                        && (property.getValue() == null)
                        && (property.getData() == null)) {
                    throw new RuntimeException("Illegal bean property definition");
                }

                if (field.getType().isPrimitive()) {
                    if (field.getType().equals(int.class)) {
                        field.setInt(beanInstance, Integer.valueOf(property.getValue()));
                    } else if (field.getType().equals(long.class)) {
                        field.setLong(beanInstance, Long.valueOf(property.getValue()));
                    } else if (field.getType().equals(float.class)) {
                        field.setFloat(beanInstance, Float.valueOf(property.getValue()));
                    } else if (field.getType().equals(double.class)) {
                        field.setDouble(beanInstance, Double.valueOf(property.getValue()));
                    }
                } else if (field.getType().equals(String.class)) {
                    field.set(beanInstance, property.getValue());
                }

                //Inject property with class
                if (property.getRef() != null) {
                    field.setAccessible(true);
                    field.set(beanInstance, getBean(property.getRef()));
                }

                //Injects property with collection.

                if (property.getData() == null) {
                    continue;
                }

                if (property.getData() instanceof ListDefinition) {
                    ListDefinition listDefinition = (ListDefinition) property.getData();
                    Collection<String> items = new ArrayList<>(
                            listDefinition.getItems()
                                    .stream()
                                    .map(n -> n.getValue())
                                    .collect(Collectors.toList()));
                    field.set(beanInstance, items);
                }

                if (property.getData() instanceof MapDefinition) {
                    MapDefinition mapDefinition = (MapDefinition) property.getData();
                    Map<String, Object> itemMap = new HashMap<>();
                    for (MapDefinition.MapEntryDefinition entryDefinition
                            : mapDefinition.getValues()) {
                        if (entryDefinition.getValue() != null) {
                            itemMap.put(entryDefinition.getKey(), entryDefinition.getValue());
                        } else if (entryDefinition.getRef() != null) {
                            itemMap.put(entryDefinition.getKey(),
                                    getBean(entryDefinition.getRef()));
                        } else {
                            throw new RuntimeException("value and ref are null in map entry");
                        }
                    }
                    field.set(beanInstance, itemMap);
                }
            }

            //Post construct
            if (definition.getPostConstruct() != null) {
                beanInstance.getClass()
                        .getDeclaredMethod(definition.getPostConstruct())
                        .invoke(beanInstance);
            }

            return beanInstance;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
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
        try {
            return (T) getBean(beanName);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
