package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class BeanFactoryImpl {
//    BeanPropertiesSetter setter = new BeanPropertiesSetterImpl();
//
//
//    @Override
//    public <T> T getBean(Class<T> beanClass) {
//        if (beanClass == null) {
//            return null;
//        }
//        try {
//            return beanClass.getDeclaredConstructor().newInstance();
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Object getBean(String beanName) {
//        if (beanName == null) {
//            return null;
//        }
//        for (BeanDefinition beanDefinition:
//                beanDefinitions) {
//            if (beanName.equalsIgnoreCase(beanDefinition.getId())) {
//                try {
//                    Class c = Class.forName(beanDefinition.getClassName());
//                    Object o = c.getDeclaredConstructor().newInstance();
//                    Field[] fields = o.getClass().getDeclaredFields();
//                    Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();
//
//                    for (Field field : fields) {
//                        for (BeanPropertyDefinition property : properties) {
//                            if (property.getName().equalsIgnoreCase(field.getName())){
//                                if (property.getValue() != null) {
//                                    setter.setValue(o, field, property);
//                                }
//                                else if (property.getRef() != null) {
//                                    setter.setReference(o, field, property);
//                                }
//                                else if (property.getData() != null) {
//                                    field.setAccessible(true);
//                                    field.set(o, property.getData());
//                                }
//
//                            }
//                        }
//                    }
//
//                    return o;
//                } catch (ClassNotFoundException
//                        | InstantiationException
//                        | InvocationTargetException
//                        | NoSuchMethodException
//                        | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public <T> T getBean(String beanName, Class<T> beanClass) {
//        if (beanName == null || beanClass == null) {
//            return null;
//        }
//        for (BeanDefinition beanDefinition:
//                beanDefinitions) {
//            if (beanDefinition.getId().equals(beanName)) {
//                if (beanDefinition.getClassName().equals(beanClass.getName())){
//                    try {
//                        return beanClass.getDeclaredConstructor().newInstance();
//                    } catch (InstantiationException
//                            | IllegalAccessException
//                            | InvocationTargetException
//                            | NoSuchMethodException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        return null;
//    }
//    }
}
