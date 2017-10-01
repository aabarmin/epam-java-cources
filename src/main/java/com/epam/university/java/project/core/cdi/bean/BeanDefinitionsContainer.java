package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "beans")
public class BeanDefinitionsContainer {
    @XmlElement(type = BeanDefinitionImpl.class)
    private List<BeanDefinition> bean = new ArrayList<>();

    public void setBean(List<BeanDefinition> bean) {
        this.bean = bean;
    }

    List<BeanDefinition> getBeans() {
        return bean;
    }
}
