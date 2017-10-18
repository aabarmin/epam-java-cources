package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    /**
     * Constructor for BeanDefinitionReaderImpl.
     * @param registry registry
     */
    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeansCollection.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BeansCollection beans = (BeansCollection) unmarshaller.unmarshal(resource.getFile());
            for (BeanDefinition bean : beans.getBeans()) {
                registry.addBeanDefinition(bean);
                //System.out.println(bean);
            }
            return beans.getBeans().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int result = 0;
        for (Resource resource : resources) {
            result += loadBeanDefinitions(resource);
        }
        return result;
    }
}
