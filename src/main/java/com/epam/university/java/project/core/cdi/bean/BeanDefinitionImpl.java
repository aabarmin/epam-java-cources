package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.CollectionAdapter;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.NONE)
public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
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

    @XmlElement(type = BeanPropertyDefinitionImpl.class)
    protected List<BeanPropertyDefinition> getXmlDefinitions(){
        return new CollectionAdapter<BeanPropertyDefinition>(propertyDefinitions);
    }
}
