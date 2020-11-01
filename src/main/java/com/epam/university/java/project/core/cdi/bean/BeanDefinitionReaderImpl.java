package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class BeanDefinitionReaderImpl  {
//    BeanDefinitionHandler handler = new BeanDefinitionHandler();
//    Collection<BeanDefinition> beanDefinitions = new ArrayList<>();
//
//    @Override
//    public int loadBeanDefinitions(Resource resource) {
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        try {
//            SAXParser parser = factory.newSAXParser();
//            parser.parse(resource.getFile(), handler);
//        } catch (ParserConfigurationException | IOException | SAXException e) {
//            e.printStackTrace();
//        }
//        beanDefinitions.addAll(handler.getBeanDefinitions());
//        return handler.getBeanDefinitions().size();
//    }
//
//    @Override
//    public int loadBeanDefinitions(Collection<Resource> resources) {
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        for (Resource resource :
//                resources) {
//            try {
//                SAXParser parser = factory.newSAXParser();
//                parser.parse(resource.getFile(), handler);
//            } catch (ParserConfigurationException | IOException | SAXException e) {
//                e.printStackTrace();
//            }
//            Collection<BeanDefinition> tempDeanDefinitions = handler.getBeanDefinitions();
//            beanDefinitions.addAll(tempDeanDefinitions);
//        }
//        beanDefinitions.addAll(handler.getBeanDefinitions());
//        return beanDefinitions.size();
//    }
}
