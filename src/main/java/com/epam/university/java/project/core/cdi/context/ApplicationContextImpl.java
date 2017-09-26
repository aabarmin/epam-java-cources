package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {
    private BeanDefinitionRegistry registry = new BeanDefinitionRegistryImpl();

    ApplicationContextImpl() {
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionRegistryImpl.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            registry = (BeanDefinitionRegistry) jaxbUnmarshaller.unmarshal(resource.getFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
        return 0;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        try {
            return beanClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
