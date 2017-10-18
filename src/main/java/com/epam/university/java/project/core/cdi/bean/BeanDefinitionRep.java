package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class with beans definitions.
 */
@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionRep {
    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> definitions = new ArrayList<>();

    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }
}