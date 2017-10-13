package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Wrapper for all beans in xml.
 */
@XmlRootElement(name = "beans")
public class BeansWrapper {
    private Collection<BeanDefinition> beans;

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    public Collection<BeanDefinition> getBeans() {
        return beans;
    }

    public void setBeans(Collection<BeanDefinition> beans) {
        this.beans = beans;
    }
}
