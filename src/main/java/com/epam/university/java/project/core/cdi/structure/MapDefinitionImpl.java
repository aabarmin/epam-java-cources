package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for MapDefinition.
 *
 * @author Sergei Titov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(type = MapEntryDefinitionImpl.class, name = "entry")
    private Collection<MapEntryDefinition> values = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }
}

