package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by ilya on 24.09.17.
 */

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.NONE)
public class BeanDefinitionDocument {

    private Collection<BeanDefinition> definitions = new ArrayList<>();

    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    public void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }
}
