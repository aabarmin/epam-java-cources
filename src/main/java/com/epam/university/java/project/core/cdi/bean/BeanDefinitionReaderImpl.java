package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext context = JAXBContext.newInstance(BeanDefinitionImpl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            BeansWrapper wrapper = (BeansWrapper) unmarshaller.unmarshal(resource.getFile());

            for (BeanDefinition beanDefinition : wrapper.getBeans()) {
                beanDefinitionRegistry.addBeanDefinition(beanDefinition);
            }

            return wrapper.getBeans().size();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }
}
