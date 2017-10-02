package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanRegistry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry beanRegistry) {
        this.beanRegistry = beanRegistry;
    }

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        int beanDefinitionsCount = 0;
        try {
            //parse xml
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(resource.getFile());

            document.getDocumentElement().normalize();
            NodeList beans = document.getElementsByTagName("bean");

            //handling of each bean
            for (int i = 0; i < beans.getLength(); i++) {
                BeanDefinitionImpl beanDef = new BeanDefinitionImpl();
                NamedNodeMap attributes = beans.item(i).getAttributes();

                //set bean attributes
                beanDef.setId(attributes.getNamedItem("id").getNodeValue());
                beanDef.setClassName(attributes.getNamedItem("class").getNodeValue());

                if (attributes.getNamedItem("init") != null) {
                    beanDef.setPostConstruct(attributes
                            .getNamedItem("init")
                            .getNodeValue()
                    );
                }
                if (attributes.getNamedItem("scope") != null) {
                    beanDef.setScope(attributes
                            .getNamedItem("scope")
                            .getNodeValue()
                    );
                }

                //set bean properties
                Set<BeanPropertyDefinition> propertiesSet = new HashSet<>();
                if (beans.item(i).hasChildNodes()) {
                    NodeList props = beans.item(i).getChildNodes();

                    for (int j = 0; j < props.getLength(); j++) {

                        if (props.item(j).hasAttributes()) {
                            BeanPropertyDefinitionImpl propDef = new BeanPropertyDefinitionImpl();

                            //add property name
                            propDef.setName(props
                                    .item(j)
                                    .getAttributes()
                                    .getNamedItem("name")
                                    .getNodeValue()
                            );

                            //add property "value" or "ref"
                            if (props.item(j).getAttributes().getNamedItem("value") != null) {
                                propDef.setValue(props
                                        .item(j)
                                        .getAttributes()
                                        .getNamedItem("value")
                                        .getNodeValue()
                                );
                            } else if (props.item(j).getAttributes().getNamedItem("ref") != null) {
                                propDef.setRef(props
                                        .item(j)
                                        .getAttributes()
                                        .getNamedItem("ref")
                                        .getNodeValue()
                                );
                            } else {
                                throw new RuntimeException();
                            }

                            propertiesSet.add(propDef);
                        }
                    }
                }
                beanDef.setProperties(propertiesSet);
                beanRegistry.addBeanDefinition(beanDef);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return beanDefinitionsCount;
    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }
}
