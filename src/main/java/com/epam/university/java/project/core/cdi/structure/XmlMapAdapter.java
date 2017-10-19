package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Implementation XmlAdapter-class for MapDefinitionImpl to Map of Strings cast.
 *
 * @author Sergei Titov
 */
public class XmlMapAdapter extends XmlAdapter<MapDefinitionImpl, Map<String, String>> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> unmarshal(MapDefinitionImpl v) throws Exception {

        return v.getValues().stream()
                .map(l -> (MapEntryDefinitionImpl)l)
                .collect(Collectors.toMap(
                        MapDefinition.MapEntryDefinition::getKey,
                        MapEntryDefinitionImpl::getBody));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapDefinitionImpl marshal(Map<String, String> map) throws Exception {
        // throw new NotImplementedException();
        return null;
    }
}
