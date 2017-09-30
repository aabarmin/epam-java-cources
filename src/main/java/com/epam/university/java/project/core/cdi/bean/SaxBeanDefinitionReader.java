package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Collection;

/**
 * Created by Александр on 29.09.2017.
 */
public class SaxBeanDefinitionReader implements BeanDefinitionReader {
    BeanDefinitionRegistry registry;

    public SaxBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                BeanDefinition current;
                @Override
                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("bean")) {
                        current = new BeanDefinitionImpl();
                        for (int i = 0; i < attributes.getLength(); i++) {
                            String value = attributes.getValue(i);
                            switch (attributes.getType(i)) {
                                case "name" : {
                                    current.setClassName(value);
                                    break;
                                }
                                case "id" : {
                                    current.setId(value);
                                    break;
                                }
                                case "scope" : {
                                    current.setScope(value);
                                    break;
                                }
                                case "init" : {
                                    current.setPostConstruct(value);
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                        }
                    }


                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int count = 0;
        for (Resource r : resources) {
            count += loadBeanDefinitions(r);
        }
        return count;
    }
}
