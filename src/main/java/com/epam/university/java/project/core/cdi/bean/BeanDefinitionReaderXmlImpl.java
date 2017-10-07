package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanDefinitionReaderXmlImpl implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    public BeanDefinitionReaderXmlImpl(
        BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if(!(resource instanceof XmlResource)){
            throw new IllegalArgumentException("This is not XML resource");
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionDocument.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final BeanDefinitionDocument beanDefinitionDocument = (BeanDefinitionDocument) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beanDefinitionDocument.getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beanDefinitionDocument.getDefinitions().size();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return resources.stream().mapToInt(r -> loadBeanDefinitions(r)).sum();
    }
}
