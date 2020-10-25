package com.epam.university.java.project.core.cdi.bean;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Collection;

public class BeanDefinitionHandler extends DefaultHandler {
    public static final String BEAN_ELEMENT = "bean";
    public static final String NESTED_BEANS_ELEMENT = "beans";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String PROPERTY_ATTRIBUTE = "property";
    public static final String REFERENCE_ATTRIBUTE = "ref";
    public static final String RESOURCE_ATTRIBUTE = "resource";
    public static final String PROFILE_ATTRIBUTE = "profile";

    BeanDefinition beanDefinition;
    String id = "";
    String beanClass = "";
    BeanPropertyDefinition beanPropertyDefinition;
    String propertyName = "";
    String propertyRef = "";
    Collection<BeanPropertyDefinition> propertyDefinitions;
    Collection<BeanDefinition> beanDefinitions;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase(BEAN_ELEMENT)) {
            id = attributes.getValue(ID_ATTRIBUTE);
            beanClass = attributes.getValue("class");
        }
        else if (qName.equalsIgnoreCase(PROPERTY_ATTRIBUTE)){
            propertyName = attributes.getValue(NAME_ATTRIBUTE);
            propertyRef = attributes.getValue(REFERENCE_ATTRIBUTE);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase(BEAN_ELEMENT)) {
            beanDefinition = new BeanDefinitionImpl();
            beanPropertyDefinition = new BeanPropertyDefinitionImpl();
            if (!id.isEmpty()) {
                beanDefinition.setId(id);
            }
            if (!beanClass.isEmpty()) {
                beanDefinition.setClassName(beanClass);
            }
            if (!propertyName.isEmpty()) {
                beanPropertyDefinition.setName(propertyName);
            }
            if (!propertyRef.isEmpty()) {
                beanPropertyDefinition.setRef(propertyRef);
            }
            beanDefinitions.add(beanDefinition);
            propertyDefinitions.add(beanPropertyDefinition);

            id = "";
            beanClass = "";
            propertyName = "";
            propertyRef = "";
        }
    }
}
