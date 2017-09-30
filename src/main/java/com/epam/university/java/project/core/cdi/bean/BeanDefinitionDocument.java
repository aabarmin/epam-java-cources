package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.CollectionAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
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

    public void setDefinitions(Collection<BeanDefinition> definitions) {
        this.definitions = definitions;
    }

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    protected List<BeanDefinition> getXmlDefinitions(){
        return new CollectionAdapter<BeanDefinition>(definitions);
    }

}
