package com.epam.university.java.project.core.cdi.structure;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Implementation XmlAdapter-class for ListDefinitionImpl to Collection of Strings cast.
 *
 * @author Sergei Titov
 */
public class XmlListAdapter extends XmlAdapter<ListDefinitionImpl, Collection<String>> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> unmarshal(ListDefinitionImpl list) throws Exception {

        return list.getItems().stream()
                .map(l -> l.getValue())
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListDefinitionImpl marshal(Collection<String> collection) throws Exception {
        // throw new NotImplementedException();
        return null;
    }
}
