package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;

/**
 * Created by Romin Nuro on 24.09.2020 0:53.
 */
public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private final BeanDefinitionToClassRepository repository;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry,
                                    BeanDefinitionToClassRepository repository) {
        this.registry = registry;
        this.repository = repository;
    }

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        File file = resource.getFile();
        BeanDefinitionsList definitionsList = null;
        int numberOfDefinitions = 0;
        try {
            JAXBContext context = JAXBContext.newInstance(BeanDefinitionsList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            definitionsList = (BeanDefinitionsList) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        assert definitionsList != null;
        for (BeanDefinition definition : definitionsList.getList()) {
            registry.addBeanDefinition(definition);
            numberOfDefinitions++;
        }
        return numberOfDefinitions;
    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int numberOfDefinitions = 0;
        for (Resource resource : resources) {
            numberOfDefinitions += loadBeanDefinitions(resource);
        }
        return numberOfDefinitions;
    }
}
