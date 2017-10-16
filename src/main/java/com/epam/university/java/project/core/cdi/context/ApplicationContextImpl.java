package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.*;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Constructor;
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
    private Map<String, BeanDefinition> beanInstanceRegistry = new HashMap<>();

    // map of {Bean ID -> Bean class name} container
    private BeanDefinitionRegistryImpl beanDefinitionRegistry;

/*    private BeanDefinitionReader beanDefinitionReader = new BeanDefinitionReaderImpl(beanRegistry);
    private BeanFactory beanFactory = new BeanFactoryImpl(beanRegistry);
*/
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
    public <T> T getBean(Class<T> beanClass) {

    //    String className = ;

        try {
            Class<?> clazz = Class.forName(beanClass.getName() + "Impl");
            T obj = (T)clazz.newInstance();

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean(String beanName) {

        if (!beanInstanceRegistry.containsKey(beanName)) {

            BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanName);
            String clasName = beanDefinition.getClassName();

            beanInstanceRegistry.put(beanName, null);
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
