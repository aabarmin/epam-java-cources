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

public class BeanDefinitionHandler extends DefaultHandler {
    public static final String BEAN_ELEMENT = "bean";
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
    String propertyName = "";
    String propertyRef = "";
    String propertyValue = "";


    ListDefinition listDefinition;
    ListDefinition.ListItemDefinition listItemDefinition;
    Collection<ListDefinition.ListItemDefinition> listItemDefinitions = new ArrayList<>();
    Boolean bCollectionValue = false;
    Boolean bListDefinition = false;

    MapDefinition mapDefinition;
    MapDefinition.MapEntryDefinition mapEntryDefinition;
    Boolean bMapDefinition = false;
    Boolean bMapEntryDefinition = false;
    Boolean bKey = false;
    Boolean bRef = false;

    Collection<BeanPropertyDefinition> propertyDefinitions;
    Collection<BeanDefinition> beanDefinitions = new ArrayList<>();


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(BEAN_ELEMENT)) {
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

        else if (qName.equalsIgnoreCase(PROPERTY_ATTRIBUTE)) {
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
        else if (qName.equalsIgnoreCase(LIST)) {
            listDefinition = new ListDefinitionImpl();
            bListDefinition = true;
        }

        else if (qName.equalsIgnoreCase(MAP)) {
            mapDefinition = new MapDefinitionImpl();
            bMapDefinition = true;
        }

        else if (qName.equalsIgnoreCase(ENTRY)) {
            mapEntryDefinition = new MapDefinitionImpl.MapEntryDefinitionImpl();
            bMapEntryDefinition = true;
        }

        else if (qName.equalsIgnoreCase(KEY)) {
            bKey = true;
        }

        else if (qName.equalsIgnoreCase(REF)) {
            bRef = true;
        }

        else if (qName.equalsIgnoreCase(COLLECTION_VALUE)) {
            if (bListDefinition) {
                listItemDefinition = new ListDefinitionImpl.ListItemDefinitionImpl();
                bCollectionValue = true;
            } else if (bMapDefinition) {
//                mapEntryDefinition = new MapDefinitionImpl.MapEntryDefinitionImpl();
                bCollectionValue = true;
            }
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(BEAN_ELEMENT)) {
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
        } else if (qName.equalsIgnoreCase(PROPERTY_ATTRIBUTE)) {
            propertyDefinition = new BeanPropertyDefinitionImpl();
            if (!propertyName.isEmpty()) {
                propertyDefinition.setName(propertyName);
            }
            if (!propertyRef.isEmpty()) {
                propertyDefinition.setRef(propertyRef);
            }
            if (!propertyValue.isEmpty()) {
                propertyDefinition.setValue(propertyValue);
            }
            if (listDefinition.getItems() != null) {
                propertyDefinition.setData(listDefinition);
            }
            propertyDefinitions.add(propertyDefinition);
            propertyName = "";
            propertyRef = "";
            propertyValue = "";
        }

        else if (bCollectionValue) {
            if (bListDefinition) {
                listItemDefinition.setValue(data.toString());
                listItemDefinitions.add(listItemDefinition);
                bCollectionValue = false;
            }

        }

        else if (bListDefinition) {
            listDefinition.setItems(listItemDefinitions);
            bListDefinition = false;
        }

        else if (bKey) {

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public Collection<BeanDefinition> getBeanDefinitions() {
        return this.beanDefinitions;
    }
}
