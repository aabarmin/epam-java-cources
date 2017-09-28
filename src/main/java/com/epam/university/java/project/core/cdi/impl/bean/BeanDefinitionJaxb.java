package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Wrapper for Bean Definitions for JAXB.
 */
@XmlRootElement(name = "beans")
public class BeanDefinitionJaxb {

    private Collection<BeanDefinition> definitions = new ArrayList<>();

    /**
     * Get bean definitions.
     * @return collection of definitions
     */
    public Collection<BeanDefinition> getDefinitions() {
        return definitions;
    }

    /**
     * Set bean definitions.
     * @param definitions collection of definitions
     */
    @XmlAnyElement(lax = true)
    private void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }

}
