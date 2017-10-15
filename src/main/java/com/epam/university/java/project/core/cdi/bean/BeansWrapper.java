package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeansWrapper {

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> beanDefinitions = new ArrayList<>();

    /**
     * Get the bean definitions.
     *
     * @return bean definitions
     */
    public Collection<BeanDefinition> getBeanDefinitions() {
        return new ArrayList<BeanDefinition>(beanDefinitions);
    }

    /**
     * Set the bean definitions.
     *
     * @param beanDefinitions bean definitions
     */
    public void setBeanDefinitions(Collection<BeanDefinition> beanDefinitions) {
        this.beanDefinitions = new ArrayList<BeanDefinition>(beanDefinitions);
    }

    /**
     * Get beans quantity.
     *
     * @return beans quantity
     */
    public int getBeansQuantity() {
        return beanDefinitions.size();
    }

}
