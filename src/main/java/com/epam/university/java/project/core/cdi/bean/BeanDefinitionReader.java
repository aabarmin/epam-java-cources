package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

/**
 * Reads bean definitions from some source, ex. XML-file or class annotations.
 */
public interface BeanDefinitionReader {
    /**
     * Load bean definitions from designated resource.
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    int loadBeanDefinitions(Resource resource);

    /**
     * Load bean definitions from collection of resources.
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    int loadBeanDefinitions(Collection<Resource> resources);
}
