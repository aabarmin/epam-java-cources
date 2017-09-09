package com.epam.university.java.project.core.cdi.impl;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

/**
 * @author ABarmin
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    private boolean isAccessible(final Resource resource) {
        return resource instanceof XmlResource;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (!isAccessible(resource)) {
            return 0;
        }
        /**
         * Here we parse our xml and load definitions from it, in the following way
         */
        try {
            final JAXBContext context = JAXBContext.newInstance("");
            final Unmarshaller unmarshaller = context.createUnmarshaller();
            final BeanDefinitionDocument beanDefinitionDocument = (BeanDefinitionDocument) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beanDefinitionDocument.getDefinitions()) {
                registry.addBeanDefinition(beanDefinition);
            }
            return beanDefinitionDocument.getDefinitions().size();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int count = 0;
        for (Resource resource : resources) {
            count += loadBeanDefinitions(resource);
        }
        return count;
    }
}
