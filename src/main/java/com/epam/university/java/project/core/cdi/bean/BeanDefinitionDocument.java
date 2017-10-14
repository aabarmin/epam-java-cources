package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 03.10.2017.
 * XML document parsing
 */
@XmlRootElement(name = "beans")
public class BeanDefinitionDocument {

    List<BeanDefinitionImpl> beanDefinitions = new ArrayList<>();

    /**
     * Get beans definitions.
     * @return list of bean definitions.
     */
    public List<BeanDefinitionImpl> getBeanDefinitions() {
        return beanDefinitions;
    }

    /**
     * Set bean definitions.
     * @param beanDefinitions list of definitions
     */
    @XmlAnyElement(lax = true)
    public void setBeanDefinitions(List<BeanDefinitionImpl> beanDefinitions) {
        this.beanDefinitions = beanDefinitions;
    }
}
