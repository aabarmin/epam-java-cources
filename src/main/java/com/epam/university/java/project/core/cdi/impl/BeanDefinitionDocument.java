package com.epam.university.java.project.core.cdi.impl;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ABarmin
 */
public class BeanDefinitionDocument {
    private Collection<BeanDefinition> definitions = new ArrayList<>();

    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }
}
