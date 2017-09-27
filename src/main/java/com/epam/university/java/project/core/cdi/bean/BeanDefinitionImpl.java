package com.epam.university.java.project.core.cdi.bean;

import java.util.Collection;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement(name = "bean")
public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
    @XmlElement(type = BeanPropertyDefinitionImpl.class)
    private Collection<BeanPropertyDefinition> propertyDefinitions;
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
        return propertyDefinitions;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        propertyDefinitions = properties;
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
