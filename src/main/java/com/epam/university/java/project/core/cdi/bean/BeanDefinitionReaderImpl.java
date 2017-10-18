package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    BeanDefinitionDoc.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final BeanDefinitionDoc beansDefinitionDoc =
                    (BeanDefinitionDoc) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beansDefinitionDoc.getDefinitions()) {
                beanDefinitionRegistry.addBeanDefinition(beanDefinition);
            }
            return beansDefinitionDoc.getDefinitions().size();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return resources.stream().mapToInt(this::loadBeanDefinitions).sum();
    }
}