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

            //TODO: Do I really need normalize()? Some kind of optimisation
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("bean");

            for (int i = 0; i < nodeList.getLength(); i++) {
                BeanDefinitionImpl beanDefinition = new BeanDefinitionImpl();
                NamedNodeMap beanAttributes = nodeList.item(i).getAttributes();

                //TODO: Make an universal method to invoke methods (bean and BD)
                beanDefinition.setId(beanAttributes.getNamedItem("id").getNodeValue());
                beanDefinition.setClassName(beanAttributes.getNamedItem("class").getNodeValue());

                if (beanAttributes.getNamedItem("init") != null) {
                    beanDefinition.setPostConstruct(beanAttributes.getNamedItem("init").getNodeValue());
                }

                if (beanAttributes.getNamedItem("scope") != null) {
                    beanDefinition.setScope(beanAttributes.getNamedItem("scope").getNodeValue());
                }

                Set<BeanPropertyDefinition> properties = new HashSet<>();
                if (nodeList.item(i).hasChildNodes()) {
                    NodeList propertiesNodes = nodeList.item(i).getChildNodes();
                    
                    for (int j = 0; j < propertiesNodes.getLength(); j++) {

                        if (propertiesNodes.item(j).hasAttributes()) {
                            BeanPropertyDefinitionImpl beanPropertyDefinition = new BeanPropertyDefinitionImpl();
                            if (propertiesNodes.item(j).getAttributes().getNamedItem("name") != null) {
                                beanPropertyDefinition.setName(propertiesNodes.item(j).getAttributes().getNamedItem("name").getNodeValue());
                            }
                            
                            //TODO: Is it correct understanding of "incorrect definition"?
                            if (propertiesNodes.item(j).getAttributes().getNamedItem("value") != null) {
                                beanPropertyDefinition.setValue(propertiesNodes.item(j).getAttributes().getNamedItem("value").getNodeValue());
                            } else if (propertiesNodes.item(j).getAttributes().getNamedItem("ref") != null) {
                                beanPropertyDefinition.setRef(propertiesNodes.item(j).getAttributes().getNamedItem("ref").getNodeValue());
                            } else {
                                throw new RuntimeException();
                            }

                            properties.add(beanPropertyDefinition);
                        }
                    }
                }

                beanDefinition.setProperties(properties);
                beanRegistry.addBeanDefinition(beanDefinition);
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
