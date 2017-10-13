package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "bean")
public class BeanDefinitionImpl implements BeanDefinition {
    private String id;
    private String className;
    private String scope;
    private String postConstruct;
    private Collection<BeanPropertyDefinition> properties;

    /**
     * Get the bean id.
     *
     * @return id of bean
     */
    @XmlAttribute(name = "id")
    @Override
    public String getId() {
        return id;
    }

    /**
     * Set the bean id.
     *
     * @param id id of bean
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get bean class name.
     *
     * @return name of class
     */
    @XmlAttribute(name = "class")
    @Override
    public String getClassName() {
        return className;
    }

    /**
     * Set bean class name.
     *
     * @param className name of class
     */
    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get bean properties.
     *
     * @return collection of bean properties
     */
    @XmlElement(name = "property", type = BeanPropertyDefinitionImpl.class)
    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return properties;
    }

    /**
     * Set bean properties.
     *
     * @param properties collection of bean properties
     */
    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = properties;
    }

    /**
     * Get method name which is called after bean created and dependencies injected.
     *
     * @return method name
     */
    @XmlAttribute(name = "init")
    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    /**
     * Set post-construct method name.
     *
     * @param methodName method name
     */
    @Override
    public void setPostConstruct(String methodName) {
        this.postConstruct = methodName;
    }

    /**
     * Get the bean scope.
     *
     * @return bean scope
     */
    @XmlAttribute(name = "scope")
    @Override
    public String getScope() {
        return scope;
    }

    /**
     * Set the bean scope.
     *
     * @param scope bean scope
     */
    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }
}
