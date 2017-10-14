package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Александр on 29.09.2017.
 * Bean definition with xml annotations
 */

@XmlRootElement(name = "bean")
public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
    private String scope;
    private String postConstruct;
    Collection<BeanPropertyDefinition> properties;

    public BeanDefinitionImpl() {
        properties = new ArrayList<>();
    }

    /**
     * Get the bean id.
     *
     * @return id of bean
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Set the bean id.
     *
     * @param id id of bean
     */
    @XmlAttribute(name = "id")
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get bean class name.
     *
     * @return name of class
     */
    @Override
    public String getClassName() {
        return className;
    }

    /**
     * Set bean class name.
     *
     * @param className name of class
     */
    @XmlAttribute(name = "class")
    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get bean properties.
     *
     * @return collection of bean properties
     */
    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return properties;
    }

    /**
     * Set bean properties.
     *
     * @param properties collection of bean properties
     */
    @XmlAnyElement(lax = true)
    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = properties;
    }

    /**
     * Get method name which is called after bean created and dependencies injected.
     *
     * @return method name
     */
    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    /**
     * Set post-construct method name.
     *
     * @param methodName method name
     */
    @XmlAttribute(name = "init")
    @Override
    public void setPostConstruct(String methodName) {
        postConstruct = methodName;
    }

    /**
     * Get the bean scope.
     *
     * @return bean scope
     */
    @Override
    public String getScope() {
        return scope;
    }

    /**
     * Set the bean scope.
     *
     * @param scope bean scope
     */
    @XmlAttribute(name = "scope")
    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }
}
