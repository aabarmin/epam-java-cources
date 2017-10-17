package com.epam.university.java.project.core.cdi.structure;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Вера on 17.10.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {

    @XmlValue
    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
