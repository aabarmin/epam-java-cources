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

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {

        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                    BeansWrapper.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            final BeansWrapper beansWrapper = (BeansWrapper) unmarshaller
                    .unmarshal(resource.getFile());
            for (BeanDefinition beanDefinition : beansWrapper.getBeanDefinitions()) {
                beanDefinitionRegistry.addBeanDefinition(beanDefinition);
            }
            return beansWrapper.getBeansQuantity();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {

        int amount = 0;
        for (Resource resource : resources) {
            amount += loadBeanDefinitions(resource);
        }
        return amount;

    }
}
