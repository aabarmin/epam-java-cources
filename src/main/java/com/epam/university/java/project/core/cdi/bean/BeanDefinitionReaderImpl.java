package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        File file = resource.getFile();
        int counter = 0;

        XMLInputFactory factory = XMLInputFactory.newFactory();

        XMLStreamReader xmlStreamReader;
        try {
            //xml staff
            InputStream inputStream = new FileInputStream(file);
            xmlStreamReader = factory.createXMLStreamReader(inputStream);
            XMLEventReader xmlEventReader = factory.createXMLEventReader(xmlStreamReader);

            //bean objects
            BeanDefinition beanDefinition = new BeanDefinitionImpl();
            BeanPropertyDefinition beanPropertyDefinition = null;
            List<BeanPropertyDefinition> beanPropertyDefinitionList = new ArrayList<>();


            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if ("bean".equals(endElement.getName().getLocalPart())) {
                        beanDefinition.setProperties(beanPropertyDefinitionList);
                        beanDefinitionRegistry.addBeanDefinition(beanDefinition);
                        beanDefinition = new BeanDefinitionImpl();
                        beanPropertyDefinitionList = new ArrayList<>();
                    }
                }
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    String elementName = startElement.getName().getLocalPart();
                    if ("bean".equals(elementName)) {
                        counter++;
                        Iterator<Attribute> it = startElement.getAttributes();
                        while (it.hasNext()) {
                            Attribute attribute = it.next();
                            if (QName.valueOf("id").equals(attribute.getName())) {
                                beanDefinition.setId(attribute.getValue());
                            } else if (QName.valueOf("class").equals(attribute.getName())) {
                                beanDefinition.setClassName(attribute.getValue());
                            } else if (QName.valueOf("scope").equals(attribute.getName())) {
                                beanDefinition.setScope(attribute.getValue());
                            }
                        }
                    } else if ("property".equals(elementName)) {
                        beanPropertyDefinition = new BeanPropertyDefinitionImpl();
                        Iterator<Attribute> it = startElement.getAttributes();
                        while (it.hasNext()) {
                            Attribute attribute = it.next();
                            if (QName.valueOf("name").equals(attribute.getName())) {
                                beanPropertyDefinition.setName(attribute.getValue());
                            } else if (QName.valueOf("ref").equals(attribute.getName())) {
                                beanPropertyDefinition.setRef(attribute.getValue());
                            } else if (QName.valueOf("value").equals(attribute.getName())) {
                                beanPropertyDefinition.setValue(attribute.getValue());
                            } //else if (){
//                                beanPropertyDefinition.getData()
//                            }
                        }
                    }
                    if (beanPropertyDefinition != null) {
                        beanPropertyDefinitionList.add(beanPropertyDefinition);
                        beanPropertyDefinition = null;
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }


        return counter;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {

        int counter = 0;

        for (Resource resource : resources) {
            counter += loadBeanDefinitions(resource);
        }

        return counter;
    }
}
