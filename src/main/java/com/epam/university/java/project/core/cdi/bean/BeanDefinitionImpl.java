package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.Collection;

public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
    private ArrayList<BeanPropertyDefinition> properties;
    private String postConstruct;
    private String scope;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;

    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return properties;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = (ArrayList<BeanPropertyDefinition>) properties;

    }

    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    @Override
    public void setPostConstruct(String methodName) {
        this.postConstruct = methodName;

    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;

    }
}
