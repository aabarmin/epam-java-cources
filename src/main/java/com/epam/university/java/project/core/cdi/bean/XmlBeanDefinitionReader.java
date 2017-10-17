package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionsContainer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BeanDefinitionsContainer container =
                    (BeanDefinitionsContainer) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : container.getBeans()) {
                registry.addBeanDefinition((beanDefinition));
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
        return 1;
    }
}
