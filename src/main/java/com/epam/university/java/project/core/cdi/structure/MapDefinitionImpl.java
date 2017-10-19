package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Collection;

/**
 * Implementation class for MapDefinition.
 *
 * @author Sergei Titov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    // @XmlElement(type = ListItemDefinitionImpl.class, name = "value")
    // private Collection<MapItemDefinition> list = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {

    }
}

