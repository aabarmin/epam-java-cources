package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.Collection;

public class BeanDefinitionImpl implements BeanDefinition {
    private String mId = "";
    private String mClassName = "";
    private Collection<BeanPropertyDefinition> mProperties = new ArrayList<>();
    private String mPostContract = "";
    private String mScope = "";

    @Override
    public String getId() {
        return mId;
    }

    @Override
    public void setId(String id) {
        this.mId = id;
    }

    @Override
    public String getClassName() {
        return mClassName;
    }

    @Override
    public void setClassName(String className) {
        this.mClassName = className;
    }

    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return mProperties;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.mProperties = properties;
    }

    @Override
    public String getPostConstruct() {
        return mPostContract;
    }

    @Override
    public void setPostConstruct(String methodName) {
        this.mPostContract = methodName;
    }

    @Override
    public String getScope() {
        return mScope;
    }

    @Override
    public void setScope(String scope) {
        this.mScope = scope;
    }
}
