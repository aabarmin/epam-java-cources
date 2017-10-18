package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeansCollection {

    @XmlElement(type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> bean = new ArrayList<>();

    /**
     * Get the beans.
     * @return beans
     */
    public Collection<BeanDefinition> getBeans() {
        return bean;
    }

    /**
     * Set the beans.
     * @param beans beans
     */
    public void setBeans(Collection<BeanDefinition> beans) {
        this.bean = beans;
    }
}
