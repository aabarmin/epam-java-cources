package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation class for ApplicationContext.
 *
 * @author Sergei Titov
 */
public class ApplicationContextImpl implements ApplicationContext {

    // map of {Bean ID -> Bean instance}
    private Map<String, Object> beanInstanceRegistry = new HashMap<>();

    // map of {Bean ID -> Bean class name} container
    private BeanDefinitionRegistryImpl beanDefinitionRegistry;


    /**
     * {@inheritDoc}
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext jc = JAXBContext.newInstance(
                    BeanDefinitionRegistryImpl.class);

            Unmarshaller u = jc.createUnmarshaller();

            beanDefinitionRegistry = (BeanDefinitionRegistryImpl)u.unmarshal(resource.getFile());

            return beanDefinitionRegistry.getSize();

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

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {

        // full path to bean interface class
        String fullInterfaceName = beanClass.getName();

        // short bean name
        String beanName = fullInterfaceName.substring(fullInterfaceName.lastIndexOf('.'));

        if (!beanInstanceRegistry.containsKey(beanName)) {
            try {
                Class<?> clazz = Class.forName(fullInterfaceName + "Impl");
                T obj = (T) clazz.newInstance();
                beanInstanceRegistry.put(beanName, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return (T) beanInstanceRegistry.get(beanName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean(String beanName) {

        if (!beanInstanceRegistry.containsKey(beanName)) {

            // load from context
            BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanName);
            String clasName = beanDefinition.getClassName();
            // ...
        }

        return beanInstanceRegistry.get(beanName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {

        return null;
    }
}
