package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 03.10.2017.
 */
@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionDocument {
    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
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
    public void setBeanDefinitions(List<BeanDefinitionImpl> beanDefinitions) {
        this.beanDefinitions = beanDefinitions;
    }
}
