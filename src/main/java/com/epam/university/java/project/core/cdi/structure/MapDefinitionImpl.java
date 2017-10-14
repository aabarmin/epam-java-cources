package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by Александр on 06.10.2017.
 * MapDefinition.
 */
@XmlRootElement(name = "map")
public class MapDefinitionImpl implements MapDefinition {
    Collection<MapEntryDefinition> data;

    /**
     * Get map entry collection.
     *
     * @return entry collection
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return data;
    }

    /**
     * Set map entry collection.
     *
     * @param values entry collection
     */
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        data = values;
    }
}
