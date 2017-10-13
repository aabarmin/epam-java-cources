package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "map")
public class MapDefinitionImpl implements MapDefinition {
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> values;

    /**
     * Get map entry collection.
     *
     * @return entry collection
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    /**
     * Set map entry collection.
     *
     * @param values entry collection
     */
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }
}
