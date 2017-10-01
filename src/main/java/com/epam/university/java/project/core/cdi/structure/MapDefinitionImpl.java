package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)

public class MapDefinitionImpl implements MapDefinition {

    //    @XmlJavaTypeAdapter(MapAdapter.class)
    //    private Map<String, MapEntryDefinition> map = new HashMap<>();

    @XmlElement(type = MapEntryDefinitionImpl.class,
            name = "entry")
    private List<MapEntryDefinition> list = new ArrayList<>();

    @Override
    //    public Collection<MapEntryDefinition> getValues() {
    //        return map.values();
    //    }

    public Collection<MapEntryDefinition> getValues() {
        return list;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        //        values.forEach(s -> map.put(s.getKey(), s));
        list.addAll(values);
    }
}
