package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> idRegistry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        if (!"".equals(definition.getId())) {
            idRegistry.put(definition.getId(), definition);
        }
        if (!"".equals(definition.getClassName())) {
            idRegistry.put(definition.getClassName(), definition);
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return idRegistry.get(beanId);
    }

    /**
     * Find in registry inherited classes.
     *
     * @param className parent class name
     * @return bean definition or null
     */
    public BeanDefinition getByInferitance(String className) {
        try {
            Class findClass = Class.forName(className);
            String child = idRegistry.keySet().stream()
                .filter(s -> s.contains("."))
                .filter(s -> {
                    try {
                        Class aClass = Class.forName(s);
                        List<Class> classList = Stream.of(aClass.getInterfaces())
                            .filter(i -> i.equals(findClass)).collect(Collectors.toList());
                        if (!classList.isEmpty()) {
                            return true;
                        }
                        return false;
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).findFirst().get();
            if (child != null) {
                return idRegistry.get(child);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
