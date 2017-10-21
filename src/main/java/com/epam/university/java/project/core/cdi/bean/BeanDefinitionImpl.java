package com.epam.university.java.project.core.cdi.bean;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "className", "postConstruct", "scope", "properties"})
public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
    private String postConstruct;
    private String scope;
    private Collection<BeanPropertyDefinition> propertyDefinitions;

    @XmlAttribute(name = "id")
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "class")
    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    @XmlAttribute(name = "init")
    @Override
    public void setPostConstruct(String methodName) {
        this.postConstruct = methodName;
    }

    @XmlAttribute(name = "scope")
    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return propertyDefinitions;
    }

    @XmlElement(name = "property", type = BeanPropertyDefinitionImpl.class)
    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        propertyDefinitions = properties;
    }
}
