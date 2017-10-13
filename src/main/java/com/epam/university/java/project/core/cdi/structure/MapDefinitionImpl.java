package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "map")
public class MapDefinitionImpl implements MapDefinition {
    private Collection<MapEntryDefinition> values;
    
    /**
     * Get map entry collection.
     *
     * @return entry collection
     */
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
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
