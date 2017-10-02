package com.epam.university.java.project.core.cdi.structure;

import com.epam.university.java.project.core.cdi.structure.ListDefinition.ListItemDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl.ListItemDefinitionImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ilya on 01.10.17.
 */
public class ListDefinitionAdapter extends XmlAdapter<List<String>, Collection<ListItemDefinition>> {

    @Override
    public Collection<ListItemDefinition> unmarshal(List<String> strings) throws Exception {

        List<ListItemDefinition> collect = strings.stream()
            .map(s -> {
                ListItemDefinition impl = new ListItemDefinitionImpl();
                impl.setValue(s);
                return impl;
            })
            .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<String> marshal(Collection<ListItemDefinition> listDefinition) throws Exception {
        List<String> list= listDefinition.stream()
            .map(item -> item.getValue())
            .collect(Collectors.toList());
        return list;

    }
}
