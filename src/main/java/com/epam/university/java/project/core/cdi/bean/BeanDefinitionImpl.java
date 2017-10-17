package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessType;

import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bean")
public class BeanDefinitionImpl implements BeanDefinition {
    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlElement(type = BeanPropertyDefinitionImpl.class, name = "property")
    private Collection<BeanPropertyDefinition> property;
    @XmlAttribute
    private String scope;
    @XmlAttribute
    private String postConstruct;


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
        return property;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.property = (ArrayList<BeanPropertyDefinition>) properties;

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
