package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "beans")
public class BeanDefinitions {
    @XmlAnyElement(lax = true)
    private Collection<BeanDefinition> definitions = new ArrayList<>();

    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    private void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }

}
