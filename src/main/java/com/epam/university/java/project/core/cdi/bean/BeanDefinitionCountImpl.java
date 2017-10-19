package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Вера on 17.10.2017.
 */

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionCountImpl {

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> definitions = new ArrayList<>();

    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }
}
