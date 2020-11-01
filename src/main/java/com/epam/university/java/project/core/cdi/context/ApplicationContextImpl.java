package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApplicationContextImpl implements ApplicationContext {
    BeanDefinitionHandler handler = new BeanDefinitionHandler();
    Collection<BeanDefinition> beanDefinitions = new ArrayList<>();
    BeanPropertiesSetter setter = new BeanPropertiesSetterImpl();
    List<Object> listOfSingletons = new ArrayList<>();

    @Override
    public int loadBeanDefinitions(Resource resource) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(resource.getFile(), handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        beanDefinitions.addAll(handler.getBeanDefinitions());
        return handler.getBeanDefinitions().size();
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        for (Resource resource :
                resources) {
            try {
                SAXParser parser = factory.newSAXParser();
                parser.parse(resource.getFile(), handler);
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
            Collection<BeanDefinition> tempDeanDefinitions = handler.getBeanDefinitions();
            beanDefinitions.addAll(tempDeanDefinitions);
        }
        beanDefinitions.addAll(handler.getBeanDefinitions());
        return beanDefinitions.size();
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        if (beanClass == null) {
            return null;
        }
            for (BeanDefinition beanDefinition:
                 beanDefinitions) {
                if (beanClass.getName().equals(beanDefinition.getClassName())) {
                    return (T) getBean(beanDefinition.getId());
                }
                String className = beanDefinition.getClassName();
                try {
                    Class<?> aClass = Class.forName(className);
                    Class<?>[] interfaces = aClass.getInterfaces();
                    for (Class<?> anInterface : interfaces) {
                        if (beanClass.getName().equals(anInterface.getName())) {
                            return (T) getBean(beanDefinition.getId());
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        if (beanName == null) {
            return null;
        }
        for (BeanDefinition beanDefinition:
             beanDefinitions) {
                if (beanName.equalsIgnoreCase(beanDefinition.getId())) {
                    for (Object o:
                         listOfSingletons) {
                        if ((beanDefinition.getScope().equals("singleton") ||
                                beanDefinition.getScope() == null) &&
                        o.getClass().getName().equals(beanDefinition.getClassName())) {
                            return o;
                        }
                    }
                    try {
                        Class c = Class.forName(beanDefinition.getClassName());
                        Object o = c.getDeclaredConstructor().newInstance();
                        Field[] fields = o.getClass().getDeclaredFields();
                        Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();
                        if (fields.length != properties.size()) {
                            throw new RuntimeException();
                        }
                        for (Field field : fields) {
                            for (BeanPropertyDefinition property : properties) {
                                if (property.getName().equalsIgnoreCase(field.getName())){
                                    if (property.getValue() != null) {
                                        setter.setValue(o, field, property);
                                    }
                                    else if (property.getRef() != null) {
                                        Object bean = getBean(field.getName());
                                        field.setAccessible(true);
                                        field.set(o, bean);
                                    }
                                    else if (property.getData() != null) {
                                        setter.setComplexData(o, field, property);
                                    }
                                }
                            }
                        }
                        listOfSingletons.add(o);
                        return o;
                    } catch (ClassNotFoundException
                            | InstantiationException
                            | InvocationTargetException
                            | NoSuchMethodException
                            | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        }
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        if (beanName == null || beanClass == null) {
            return null;
        }
        for (BeanDefinition beanDefinition:
                beanDefinitions) {
            if (beanDefinition.getId().equals(beanName)) {
                if (beanDefinition.getClassName().equals(beanClass.getName())){
                        return (T) getBean(beanDefinition.getId());

                }
            }
        }
        return null;
    }
}
