package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.XmlListAdapter;
import com.epam.university.java.project.core.cdi.structure.XmlMapAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for BeanPropertyDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "property")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String value;

    @XmlAttribute
    private String ref;

    // for ListDefinition
    @XmlElements({
            @XmlElement(type = ListDefinitionImpl.class, name = "list")
    })
    @XmlJavaTypeAdapter(XmlListAdapter.class)
    private Collection<String> collectionData = new ArrayList<>();

    // for MapDefinition
    @XmlElements({
            @XmlElement(type = MapDefinitionImpl.class, name = "map")
    })
    @XmlJavaTypeAdapter(XmlMapAdapter.class)
    private Map<String, String> mapData = new HashMap<>();

    private Map<String, Object> objectMap = new HashMap<>();

    // not needed actually
    //StructureDefinition data;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StructureDefinition getData() {
        return null; //data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(StructureDefinition data) {
        //this.data = data;
    }

    public Collection<String> getPropCollection() {
        return collectionData;
    }

    public Map<String, String> getPropMap() {
        return mapData;
    }

    // getObjectMap
    public Map<String, Object> getObjectMap() {
        return objectMap;
    }
}
