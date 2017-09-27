package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

/**
 * Reads bean definitions from XML-file.
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * Check if resource is an XML-file.
     * @param resource resource to check
     * @return <code>true</code> if accessible else <code>false</code>
     */
    private boolean isAccessible(Resource resource) {
        return resource instanceof XmlResource;
    }

    /**
     * Load bean definitions from designated resource.
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!isAccessible(resource)) {
            return 0;
        }
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                BeanDefinitionJaxb.class,
                DefaultBeanDefinition.class,
                DefaultBeanPropertyDefinition.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final BeanDefinitionJaxb beanDefinitionJaxb = (BeanDefinitionJaxb) unmarshaller
                .unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beanDefinitionJaxb.getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beanDefinitionJaxb.getDefinitions().size();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Load bean definitions from collection of resources.
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int beansLoaded = 0;
        for (Resource resource : resources) {
            beansLoaded += loadBeanDefinitions(resource);
        }
        return beansLoaded;
    }

}
