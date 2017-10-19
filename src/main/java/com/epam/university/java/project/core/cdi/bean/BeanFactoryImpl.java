package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вера on 16.10.2017.
 */
public class BeanFactoryImpl implements BeanFactory {
    private BeanDefinitionRegistry registry = new BeanDefinitionRegistryImpl();
    private Map<String, Object> singletons = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) prepare(null, beanClass);
    }

    @Override
    public Object getBean(String beanName) {

        return prepare(beanName, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {

        return (T) prepare(beanName, beanClass);
    }

    private Object getBean(BeanDefinition definition) {
        Object bean = null;

        try {
            Class a = Class.forName(definition.getClassName());
            bean = a.newInstance();
            Collection<BeanPropertyDefinition> properties = definition.getProperties();

            if (properties == null || properties.size() == 0) {
                return bean;
            }

            long countProperties = properties.stream().filter(s -> {
                return s.getName() == null
                        || (s.getValue() == null && s.getRef() == null && s.getData() == null);
            }).count();

            if (countProperties != 0) {
                throw new IllegalArgumentException("exception incorrect property");
            }
            final Object finalbean = bean;
            properties.forEach(s -> {
                try {
                    Field field = a.getDeclaredField(s.getName());
                    field.setAccessible(true);
                    if (s.getValue() != null) {
                        Class type = field.getType();

                        if (type.equals(int.class)) {
                            field.set(finalbean, Integer.parseInt(s.getValue()));
                        } else if (type.equals(String.class)) {
                            field.set(finalbean, s.getValue());
                        }
                    } else if (s.getRef() != null) {
                        field.set(finalbean, getBean(s.getRef()));
                    }
                    field.setAccessible(false);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });

            bean = finalbean;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return bean;
    }


    private <T> Object prepare(String beanName, Class<T> beanClass) {
        BeanDefinition definition = null;
        if (beanName != null) {
            definition = registry.getBeanDefinition(beanName);
        } else if (beanClass != null) {
            definition = registry.getBeanDefinition(beanClass.getName());

            if (definition.getClassName() == null) {
                BeanDefinition child = ((BeanDefinitionRegistryImpl) registry)
                        .getByInferitance(beanClass.getName());
                if (child != null) {
                    return getBean(child.getClassName());
                }
            }
        }

        if ("singleton".equals(definition.getScope())) {
            if (singletons.containsKey(definition.getClassName())) {
                return singletons.get(definition.getClassName());
            } else {
                Object bean = getBean(definition);
                singletons.put(definition.getClassName(), bean);
                return bean;
            }
        }

        return getBean(definition);
    }
}
