package com.epam.university.java.project.core.cdi.impl.structure;

import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Default definition of map.
 */
@XmlRootElement(name = "map")
public class DefaultMapDefinition implements MapDefinition {

    private Collection<MapEntryDefinition> values;

    /**
     * Get map entry collection.
     * @return entry collection
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    /**
     * Set map entry collection.
     * @param values entry collection
     */
    @Override
    @XmlElement(name = "entry", type = DefaultMapEntryDefinition.class)
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }

}
