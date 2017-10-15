package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    private boolean isAccessible(Resource resource) {
        return resource instanceof XmlResource;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!isAccessible(resource)) {
            return 0;
        }
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                    BeanDefinitions.class,
                    BeanDefinitionImpl.class,
                    BeanPropertyDefinitionImpl.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final BeanDefinitions beanDefinitionJaxb = (BeanDefinitions) unmarshaller
                    .unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beanDefinitionJaxb.getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beanDefinitionJaxb.getDefinitions().size();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int beansLoaded = 0;
        for (Resource resource : resources) {
            beansLoaded += loadBeanDefinitions(resource);
        }
        return beansLoaded;
    }

}
