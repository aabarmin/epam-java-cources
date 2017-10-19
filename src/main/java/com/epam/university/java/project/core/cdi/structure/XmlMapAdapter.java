package com.epam.university.java.project.core.cdi.structure;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;


/**
 * Implementation class for XmlAdapter<MapDefinitionImpl, Map<String, String>>.
 *
 * @author Sergei Titov
 */
public class XmlMapAdapter extends XmlAdapter<MapDefinitionImpl, Map<String, String>> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> unmarshal(MapDefinitionImpl v) throws Exception {

        Map<String, String> map = new HashMap<>();

        return map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MapDefinitionImpl marshal(Map<String, String> map) throws Exception {
        throw new NotImplementedException();
    }
}
