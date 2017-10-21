package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import java.util.Collection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    public BeanDefinitionReaderImpl(
        BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!(resource instanceof XmlResource)) {
            throw new IllegalArgumentException("This is not XML resource");
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Beans.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final Beans beans =
                (Beans) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beans.getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beans.getDefinitions().size();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return resources.stream().mapToInt(i -> loadBeanDefinitions(i)).sum();
    }
}
