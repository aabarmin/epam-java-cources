package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAnyElement;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanDefinitionDocument {

    @XmlAnyElement
    private Collection<BeanDefinitionImpl> definitions = new ArrayList<>();

    public Collection<BeanDefinitionImpl> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Collection<BeanDefinitionImpl> definitions) {
        this.definitions = definitions;
    }

}
