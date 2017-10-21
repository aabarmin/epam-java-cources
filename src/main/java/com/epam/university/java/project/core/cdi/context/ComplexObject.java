package com.epam.university.java.project.core.cdi.context;

import java.util.Collection;
import java.util.Map;


public class ComplexObject {
    private Collection<String> stringCollection;
    private Map<String, String> stringMap;
    private Map<String, ComplexObject> objectMap;

    public Collection<String> getStringCollection() {
        return stringCollection;
    }

    public void setStringCollection(Collection<String> stringCollection) {
        this.stringCollection = stringCollection;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<String, ComplexObject> getObjectMap() {
        return objectMap;
    }

    public void setObjectMap(Map<String, ComplexObject> objectMap) {
        this.objectMap = objectMap;
    }
}
