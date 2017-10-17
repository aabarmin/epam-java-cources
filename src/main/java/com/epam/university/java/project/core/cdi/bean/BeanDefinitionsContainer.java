package com.epam.university.java.project.core.cdi.bean;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "beans")
public class BeanDefinitionsContainer {
    @XmlElement(type = BeanDefinitionImpl.class, name = "bean")
    private List<BeanDefinition> beans = new ArrayList<>();

    public void setBeans(List<BeanDefinition> beans) {
        this.beans = beans;
    }

    List<BeanDefinition> getBeans() {
        return beans;
    }
}
