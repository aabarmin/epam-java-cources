package com.epam.university.java.project.core.cdi.bean;


import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAnyElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bean")
public class BeanDefinitionImpl implements BeanDefinition {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlAnyElement(lax = true)
    private Collection<BeanPropertyDefinition> properties = new ArrayList<>();
    @XmlAttribute(name = "init")
    private String postConstruct;
    @XmlAttribute(name = "scope")
    private String scope;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id.trim();
    }

    @Override
    public String getClassName() {
        return className;
    }


    @Override
    public void setClassName(String className) {
        this.className = className.trim();
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
        this.postConstruct = methodName.trim();
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope.trim();
    }
}
