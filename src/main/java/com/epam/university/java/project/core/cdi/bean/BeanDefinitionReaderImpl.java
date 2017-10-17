package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

/**
 * Created by Вера on 16.10.2017.
 */
public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private BeanDefinitionRegistry registry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {

        if (!(resource instanceof XmlResource)) {
            throw new IllegalArgumentException("This is not XML resource");
        }

        try {
            JAXBContext context = JAXBContext.newInstance(BeanDefinitionCountImpl.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            BeanDefinitionCountImpl count = (BeanDefinitionCountImpl)
                    unmarshaller.unmarshal(resource.getFile());

            for (BeanDefinition bean : count.getDefinitions()) {
                registry.addBeanDefinition(bean);
            }

            return count.getDefinitions().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int sum = 0;

        for (Resource r : resources) {
            sum += loadBeanDefinitions(r);
        }

        return sum;
    }
}
