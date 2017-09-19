package com.epam.university.java.project.core.cdi.bean;

import java.util.Collection;

/**
 * Meta information about bean in context environment.
 */
public interface BeanDefinition {
    /**
     * Get the bean id.
     * @return id of bean
     */
    String getId();

    /**
     * Set the bean id.
     * @param id id of bean
     */
    void setId(String id);

    /**
     * Get bean class name.
     * @return name of class
     */
    String getClassName();

    /**
     * Set bean class name.
     * @param className name of class
     */
    void setClassName(String className);

    /**
     * Get bean properties.
     * @return collection of bean properties
     */
    Collection<BeanPropertyDefinition> getProperties();

    /**
     * Set bean properties.
     * @param properties collection of bean properties
     */
    void setProperties(Collection<BeanPropertyDefinition> properties);

    /**
     * Get method name which is called after bean created and dependencies injected.
     * @return method name
     */
    String getPostConstruct();

    /**
     * Set post-construct method name.
     * @param methodName method name
     */
    void setPostConstruct(String methodName);

    /**
     * Get the bean scope.
     * @return bean scope
     */
    String getScope();

    /**
     * Set the bean scope.
     * @param scope bean scope
     */
    void setScope(String scope);
}
