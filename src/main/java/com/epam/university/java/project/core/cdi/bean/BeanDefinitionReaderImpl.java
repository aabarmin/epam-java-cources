package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

/**
 * Class implements <code>BeanDefinition</code> interface.
 */
public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!(resource instanceof XmlResource)) {
            throw new IllegalArgumentException("Resource should be instance " +
                    "of XmlResource");
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionRep
                    .class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BeanDefinitionRep beanDefinitionRep = (BeanDefinitionRep)
                    unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beanDefinitionRep
                    .getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beanDefinitionRep.getDefinitions().size();
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return resources.parallelStream().mapToInt(resource ->
                loadBeanDefinitions(resource)).sum();
    }
}
