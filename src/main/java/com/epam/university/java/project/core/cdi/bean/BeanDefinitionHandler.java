package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class BeanDefinitionHandler extends DefaultHandler {
    public static final String BEAN_ELEMENT = "bean";
    public static final String BEANS = "beans";
    public static final String ID_ATTRIBUTE = "id";
    public static final String INIT_ATTRIBUTE = "init";
    public static final String SCOPE_ATTRIBUTE = "scope";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String PROPERTY_ATTRIBUTE = "property";
    public static final String PROPERTY_NAME_ATTRIBUTE = "name";
    public static final String PROPERTY_REFERENCE_ATTRIBUTE = "ref";
    public static final String PROPERTY_VALUE_ATTRIBUTE = "value";
    //    public static final String PROPERTY_DATA_ATTRIBUTE = "data";
    public static final String LIST = "list";
    public static final String COLLECTION_VALUE = "value";
    public static final String MAP = "map";
    public static final String ENTRY = "entry";
    public static final String KEY = "key";
    public static final String REF = "ref";

    private StringBuilder data = null;

    BeanDefinition beanDefinition;
    String id = "";
    String beanClass = "";
    String postConstruct = "";
    String scope = "";

    BeanPropertyDefinition propertyDefinition;
    String propertyName = null;
    String propertyRef = null;
    String propertyValue = null;


    ListDefinition listDefinition;
    ListDefinition.ListItemDefinition listItemDefinition;
    Collection<ListDefinition.ListItemDefinition> listItemDefinitions;
    Boolean bCollectionValue = false;
    Boolean bListDefinition = false;

    MapDefinition mapDefinition;
    MapDefinition.MapEntryDefinition mapEntryDefinition;
    Collection<MapDefinition.MapEntryDefinition> mapEntryDefinitions;

    Boolean bMapDefinition = false;
    Boolean bMapEntryDefinition = false;
    Boolean bKey = false;
    Boolean bRef = false;

    Collection<BeanPropertyDefinition> propertyDefinitions;
    Collection<BeanDefinition> beanDefinitions = new ArrayList<>();
    Map<String, String> mapOfReferences;


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes) throws SAXException {
        switch (qName) {
            case BEAN_ELEMENT:
                startParseBeanElement(attributes);
                break;
            case PROPERTY_ATTRIBUTE:
                startParseBeanElementProperty(attributes);
                break;
            case LIST:
                startParseList();
                break;
            case MAP:
                startParseMap();
                break;
            case ENTRY:
                startParseEntry();
                break;
            case KEY:
                bKey = true;
                break;
            case REF:
                bRef = true;
                break;
            case COLLECTION_VALUE:
                startParseValue();
                break;
            default:
                break;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case BEAN_ELEMENT:
                endParseBeanElement();
                break;
            case PROPERTY_ATTRIBUTE:
                endParseBeanElementProperty();
                break;
            case COLLECTION_VALUE:
                endParseValue();
                break;
            case LIST:
                endParseList();
                break;
            case KEY:
                mapEntryDefinition.setKey(data.toString());
                bKey = false;
                break;
            case REF:
                mapEntryDefinition.setRef(data.toString());
                bRef = false;
                break;
            case ENTRY:
                endParseEntry();
                break;
            case MAP:
                endParseMap();
                break;
            case BEANS:
                endParseBeans();
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public Collection<BeanDefinition> getBeanDefinitions() {
        return this.beanDefinitions;
    }

    private void startParseBeanElement(Attributes attributes) {
        beanDefinition = new BeanDefinitionImpl();
        propertyDefinitions = new ArrayList<>();
        beanDefinition.setProperties(propertyDefinitions);
        if (attributes.getValue(ID_ATTRIBUTE) != null) {
            id = attributes.getValue(ID_ATTRIBUTE);
        }
        if (attributes.getValue(CLASS_ATTRIBUTE) != null) {
            beanClass = attributes.getValue(CLASS_ATTRIBUTE);
        }
        if (attributes.getValue(INIT_ATTRIBUTE) != null) {
            postConstruct = attributes.getValue(INIT_ATTRIBUTE);
        }
        if (attributes.getValue(SCOPE_ATTRIBUTE) != null) {
            scope = attributes.getValue(SCOPE_ATTRIBUTE);
        }
    }

    private void startParseBeanElementProperty(Attributes attributes) {
        if (attributes.getValue(PROPERTY_NAME_ATTRIBUTE) != null) {
            propertyName = attributes.getValue(PROPERTY_NAME_ATTRIBUTE);
        }
        if (attributes.getValue(PROPERTY_REFERENCE_ATTRIBUTE) != null) {
            propertyRef = attributes.getValue(PROPERTY_REFERENCE_ATTRIBUTE);
        }
        if (attributes.getValue(PROPERTY_VALUE_ATTRIBUTE) != null) {
            propertyValue = attributes.getValue(PROPERTY_VALUE_ATTRIBUTE);
        }
    }

    private void startParseList() {
        listItemDefinitions = new ArrayList<>();
        listDefinition = new ListDefinitionImpl();
        bListDefinition = true;
    }

    private void startParseMap() {
        mapEntryDefinitions = new ArrayList<>();
        mapDefinition = new MapDefinitionImpl();
        bMapDefinition = true;
    }

    private void startParseEntry() {
        mapEntryDefinition = new MapDefinitionImpl.MapEntryDefinitionImpl();
        bMapEntryDefinition = true;
    }

    private void startParseValue() {
        if (bListDefinition) {
            listItemDefinition = new ListDefinitionImpl.ListItemDefinitionImpl();
            bCollectionValue = true;
        } else if (bMapDefinition) {
            bCollectionValue = true;
        }
    }

    private void endParseBeanElement() {
        if (!id.isEmpty()) {
            beanDefinition.setId(id);
        }
        if (!beanClass.isEmpty()) {
            beanDefinition.setClassName(beanClass);
        }
        if (!postConstruct.isEmpty()) {
            beanDefinition.setPostConstruct(postConstruct);
        }
        if (!scope.isEmpty()) {
            beanDefinition.setScope(scope);
        }
        if (!propertyDefinitions.isEmpty()) {
            beanDefinition.setProperties(propertyDefinitions);
        }
        beanDefinitions.add(beanDefinition);
        id = "";
        beanClass = "";
        postConstruct = "";
        scope = "";
    }

    private void endParseBeanElementProperty() {
        propertyDefinition = new BeanPropertyDefinitionImpl();
        if (propertyName != null) {
            propertyDefinition.setName(propertyName);
        }
        if (propertyRef != null) {
            propertyDefinition.setRef(propertyRef);
        }
        if (propertyValue != null) {
            propertyDefinition.setValue(propertyValue);
        }
        if (listItemDefinitions != null && !listItemDefinitions.isEmpty()) {
            propertyDefinition.setData(listDefinition);
            listItemDefinitions = null;
        }
        if (mapEntryDefinitions != null && !mapEntryDefinitions.isEmpty()) {
            propertyDefinition.setData(mapDefinition);
            mapEntryDefinitions = null;
        }
        propertyDefinitions.add(propertyDefinition);
        propertyName = null;
        propertyRef = null;
        propertyValue = null;
    }

    private void endParseList() {
        listDefinition.setItems(listItemDefinitions);
        bListDefinition = false;
    }

    private void endParseMap() {
        mapDefinition.setValues(mapEntryDefinitions);
        bMapDefinition = false;
    }

    private void endParseEntry() {
        if (mapEntryDefinition.getRef() != null && mapEntryDefinition.getValue() != null) {
            throw new RuntimeException();
        }
        mapEntryDefinitions.add(mapEntryDefinition);
        bMapEntryDefinition = false;
    }

    private void endParseValue() {
        if (bListDefinition) {
            listItemDefinition.setValue(data.toString());
            listItemDefinitions.add(listItemDefinition);
        } else if (bMapEntryDefinition) {
            mapEntryDefinition.setValue(data.toString());
        }
        bCollectionValue = false;
    }

    private void endParseBeans() {

    }
}
