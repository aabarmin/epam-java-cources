package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanRegistry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry beanRegistry) {
        this.beanRegistry = beanRegistry;
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
            JAXBContext jaxbContext = JAXBContext.newInstance(BeansWrapper.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            BeansWrapper beans = (BeansWrapper) jaxbUnmarshaller.unmarshal(resource.getFile());

            for (BeanDefinition beanDefinition : beans.getBeans()) {
                beanRegistry.addBeanDefinition(beanDefinition);
            }

            return beans.getBeans().size();
        } catch (Exception e) {
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
        return 0;
    }
}
