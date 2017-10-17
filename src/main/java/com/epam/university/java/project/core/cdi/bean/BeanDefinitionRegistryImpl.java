package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Вера on 16.10.2017.
 */
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> mapRegistry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        mapRegistry.put(definition.getId(), definition);
        mapRegistry.put(definition.getClassName(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        for (Map.Entry<String, BeanDefinition> pair : mapRegistry.entrySet()) {
            if (beanId.equals(pair.getKey())) {
                return pair.getValue();
            }
        }
        return new BeanDefinitionImpl();
    }

    /**
     * Get child of definition.
     *
     * @param className field name of class
     * @return child of definition, if definition = null
     */
    public BeanDefinition getByInferitance(String className) {
        try {
            Class findClass = Class.forName(className);
            String child = mapRegistry.keySet().stream()
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
                return mapRegistry.get(child);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
