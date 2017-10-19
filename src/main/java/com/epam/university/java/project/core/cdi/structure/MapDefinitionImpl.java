package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Вера on 17.10.2017.
 */
//@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(type = MapEntryDefinitionImpl.class,
            name = "entry")
    Collection<MapEntryDefinition> list = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return list;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        list.addAll(values);
    }
}
