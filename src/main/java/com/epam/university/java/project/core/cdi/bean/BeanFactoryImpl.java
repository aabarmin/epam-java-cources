package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.*;

import java.lang.reflect.Field;
import java.util.*;

public class BeanFactoryImpl implements BeanFactory {

    private final BeanDefinitionRegistry registry;
    private final Map<BeanDefinition, Object> singletonBeans;

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.singletonBeans = new HashMap<>();
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(registry.getBeanDefinition(beanClass.getName()));
    }

    @Override
    public Object getBean(String beanName) {
        return getBean(registry.getBeanDefinition(beanName));
    }


    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return getBean(registry.getBeanDefinition(beanName));
    }

    private <T> T getBean(BeanDefinition beanDefinition) {

        try {
            T instance;
            Class<T> instanceClass = (Class<T>) Class.forName(beanDefinition.getClassName());

            if ("singleton".equalsIgnoreCase(beanDefinition.getScope())
                    && singletonBeans.containsKey(beanDefinition)) {
                instance = (T) singletonBeans.get(beanDefinition);
                return instance;
            } else {
                instance = instanceClass.getDeclaredConstructor().newInstance();
                if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
                    singletonBeans.put(beanDefinition, instance);
                }
            }

            Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();

            if (properties == null) {
                return instance;
            } else {
                if (propertiesHasNull(properties)) {
                    throw new RuntimeException();
                }
            }

            for (BeanPropertyDefinition property : properties) {
                Field field = instanceClass.getDeclaredField(property.getName());
                field.setAccessible(true);
                String propertyValue = property.getValue();

                if (propertyValue != null) {
                    boolean isParseable = true;
                    try {
                        Integer value = Integer.parseInt(propertyValue);
                    } catch (NumberFormatException e) {
                        isParseable = false;
                    }

                    if (isParseable) {
                        field.set(instance, Integer.parseInt(propertyValue));
                    } else {
                        field.set(instance, propertyValue);
                    }
                }

                String propertyRef = property.getRef();

                if (propertyRef != null) {
                    field.set(instance, getBean(propertyRef));
                }


                StructureDefinition dataStructure = property.getData();

                if (dataStructure != null) {
                    if (dataStructure.getClass() == ListDefinitionImpl.class) {
                        List<String> tmpList = new ArrayList<>();
                        ListDefinition listDefinition = (ListDefinition) dataStructure;
                        for (ListDefinition.ListItemDefinition item : listDefinition.getItems()) {
                            tmpList.add(item.getValue());
                        }
                        field.set(instance, tmpList);
                    }

                    if (dataStructure.getClass() == MapDefinitionImpl.class) {
                        Map<String, Object> tmpMap = new HashMap<>();
                        MapDefinition mapDefinition = (MapDefinition) dataStructure;
                        for (MapDefinition.MapEntryDefinition entry : mapDefinition.getValues()) {
                            String key = entry.getKey();

                            if (entry.getValue() == null
                                    && entry.getRef() == null) {
                                throw new RuntimeException();
                            }
                            if (entry.getRef() != null
                                    && entry.getValue() != null) {
                                throw new RuntimeException();
                            }

                            if (entry.getValue() != null) {
                                String value = entry.getValue();
                                tmpMap.put(key, value);
                            }
                            if (entry.getRef() != null) {
                                Object value = getBean(entry.getRef());
                                tmpMap.put(key, value);
                            }
                        }
                        field.set(instance, tmpMap);
                    }
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private boolean propertiesHasNull(Collection<BeanPropertyDefinition> properties) {
        for (BeanPropertyDefinition property : properties) {
            if (property.getData() == null
                    && property.getValue() == null
                    && property.getRef() == null) {
                return true;
            }
        }
        return false;
    }
}
