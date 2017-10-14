package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinitionImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Александр on 02.10.2017.
 */
public class DefaultBeanDefinitionReader implements BeanDefinitionReader {
    BeanDefinitionRegistry registry;

    public DefaultBeanDefinitionReader(BeanDefinitionRegistry registry) {
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
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!isAccessible(resource)) {
            return 0;
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    BeanDefinitionDocument.class,
                    BeanPropertyDefinitionImpl.class,
                    StructureDefinitionImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BeanDefinitionDocument document = (BeanDefinitionDocument) jaxbUnmarshaller
                    .unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : document.getBeanDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return document.getBeanDefinitions().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return 1;
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
