package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapAdapter extends XmlAdapter<MapAdapter.AdaptedMap,
        Map<String, MapDefinition.MapEntryDefinition>> {
    static class AdaptedMap {
        @XmlElement(type = MapEntryDefinitionImpl.class, name = "entry")
        List<MapDefinition.MapEntryDefinition> entry = new ArrayList<>();
    }

    @Override
    public Map<String, MapDefinition.MapEntryDefinition>
        unmarshal(AdaptedMap adaptedMap) throws Exception {
        Map<String, MapDefinition.MapEntryDefinition> map = new HashMap<>();
        for (MapDefinition.MapEntryDefinition entry : adaptedMap.entry) {
            map.put(entry.getKey(), entry);
        }
        return map;
    }

    @Override
    public AdaptedMap marshal(Map<String,
            MapDefinition.MapEntryDefinition> map) throws Exception {
        AdaptedMap adaptedMap = new AdaptedMap();
        for (Map.Entry<String, MapDefinition.MapEntryDefinition> mapEntry : map.entrySet()) {
            adaptedMap.entry.add(mapEntry.getValue());
        }
        return adaptedMap;
    }

}

