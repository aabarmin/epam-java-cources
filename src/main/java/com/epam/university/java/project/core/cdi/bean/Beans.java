package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.NONE)
public class Beans {
    private Collection<BeanDefinition> beans = new ArrayList<>();

    public Collection<BeanDefinition> getBeans() {
        return beans;
    }

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    public void setDefinitions(Collection<BeanDefinition> beans) {
        this.beans = beans;
    }
}
