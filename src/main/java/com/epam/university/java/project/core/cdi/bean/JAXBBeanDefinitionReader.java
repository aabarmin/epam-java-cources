package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

/**
 * Created by Александр on 02.10.2017.
 */
public class JAXBBeanDefinitionReader implements BeanDefinitionReader {
    BeanDefinitionRegistry registry;

    public JAXBBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
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

            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionRegistryImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            registry.addBeanDefinition((BeanDefinition) jaxbUnmarshaller.unmarshal(resource.getFile()));

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
