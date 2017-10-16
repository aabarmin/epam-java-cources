package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Implementation class for BeanDefinitionReader.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.NONE)
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, String> map = new HashMap<>();

    @XmlElement(name = "bean")
    public MapEntry[] getMap() {
        List<MapEntry> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {

            MapEntry mapEntry = new MapEntry();
            mapEntry.id = entry.getKey();
            mapEntry.value = entry.getValue();

            list.add(mapEntry);
        }
        return list.toArray(new MapEntry[list.size()]);
    }

    public void setMap(MapEntry[] arr) {
        for(MapEntry entry : arr) {
            this.map.put(entry.id, entry.value);
        }
        return;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {

     /*   if (!registry.containsKey(definition.getId())) {
            registry.put(definition.getId(), definition);
        }*/
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        return null;//registry.get(beanId);
    }
}

// MapEntry
class MapEntry {
    @XmlAttribute
    public String id;

    @XmlValue
    public String value;
}