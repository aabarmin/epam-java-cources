package com.epam.university.java.project.core.cdi.bean;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;

/**
 * Created by Вера on 16.10.2017.
 */

@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionImpl implements BeanDefinition {

    @XmlAttribute
    private String id;

    @XmlAttribute(name = "class")
    private String className;

    @XmlElement(name = "property", type = BeanPropertyDefinitionImpl.class)
    private Collection<BeanPropertyDefinition> properties;

    @XmlAttribute(name = "init")
    private String postConstruct;

    @XmlAttribute
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
        this.properties = properties;
    }

    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    @Override
    public void setPostConstruct(String methodName) {
        this.postConstruct = postConstruct;
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
