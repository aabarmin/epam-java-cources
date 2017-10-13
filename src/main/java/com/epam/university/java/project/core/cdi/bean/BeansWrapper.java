package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Wrapper for all beans in xml.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "beans")
public class BeansWrapper {
    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> beans;

    public Collection<BeanDefinition> getBeans() {
        return beans;
    }

    public void setBeans(Collection<BeanDefinition> beans) {
        this.beans = beans;
    }
}
