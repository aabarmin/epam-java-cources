package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ApplicationContextImpl implements ApplicationContext {
    private BeanDefinitionRegistry beansRegistry;

    public ApplicationContextImpl() {
        beansRegistry = new BeanDefinitionRegistryImpl();
    }

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
                            if (propertiesNodes.item(j).getAttributes().getNamedItem("value") != null) {
                                beanPropertyDefinition.setValue(propertiesNodes.item(j).getAttributes().getNamedItem("value").getNodeValue());
                            }
                            if (propertiesNodes.item(j).getAttributes().getNamedItem("ref") != null) {
                                beanPropertyDefinition.setRef(propertiesNodes.item(j).getAttributes().getNamedItem("ref").getNodeValue());
                            }

                            properties.add(beanPropertyDefinition);
                        }
                    }
                }

                beanDefinition.setProperties(properties);
                beansRegistry.addBeanDefinition(beanDefinition);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return beanDefinitionsCount;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        Object object;

        try {
            BeanDefinition beanDefinition = beansRegistry.getBeanDefinition(beanName);
            object = Class.forName(beanDefinition.getClassName()).newInstance();
            Method[] declaredMethods = object.getClass().getDeclaredMethods();

            for (Method method : declaredMethods) {
                for (Parameter parameter : method.getParameters()) {
                    for (BeanPropertyDefinition property : beansRegistry.getBeanDefinition(beanName).getProperties()) {
                        if (property.getValue() != null) {
                            if (parameter.getType().equals(property.getValue().getClass())) {
                                method.invoke(object, property.getValue());
                            } else {
                                method.invoke(object, Integer.parseInt(property.getValue()));
                            }
                        }
                    }
                }
            }

//            for (BeanPropertyDefinition beanPropertyDefinition :beanDefinition.getProperties()) {
//                Method method = object.getClass().getDeclaredMethod("setProperty2", Integer.TYPE);
//                method.invoke(object, 65465416);
//            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return object;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
