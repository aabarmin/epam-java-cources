package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.*;

/**
 * Implementation class for BeanDefinitionReader.
 *
 * @author Sergei Titov
 */
public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    /**
     * {@inheritDoc}
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {

        try {
            JAXBContext jc = JAXBContext.newInstance(
                    BeanDefinitionRegistryImpl.class);

            Unmarshaller u = jc.createUnmarshaller();

            BeanDefinitionRegistryImpl registry =
                    (BeanDefinitionRegistryImpl)u.unmarshal(resource.getFile());

            return registry.getMap().length;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }
}