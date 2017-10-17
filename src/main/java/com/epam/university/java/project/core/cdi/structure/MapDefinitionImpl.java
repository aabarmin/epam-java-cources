package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "map")
public class MapDefinitionImpl extends StructureDefinitionImpl implements MapDefinition {

    @XmlElement(type = MapEntryDefinitionImpl.class, name = "entry")
    private List<MapEntryDefinition> values = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values.addAll(values);

    }
}
