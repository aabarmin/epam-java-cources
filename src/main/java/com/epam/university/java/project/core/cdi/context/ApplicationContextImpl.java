package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinitionImpl;
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
            // read bean definitions into beanDefinitionRegistry
            JAXBContext jc = JAXBContext.newInstance(
                    BeanDefinitionRegistryImpl.class,
                    BeanPropertyDefinitionImpl.class);
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

        return (T) loadBeanByPath(beanClass.getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getBean(String beanName) {

        if (!beanInstanceRegistry.containsKey(beanName)) {

            // load from context
            BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanName);

            return loadBeanByName(beanDefinition.getClassName());
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

    /**
     * Loads bean into context.
     *
     * @param beanPath - path like "com.epam.university.java.project.core.cdi.context.ChildBean"
     *
     * @return loaded class instance
     */
    private Object loadBeanByPath(String beanPath) {

        // short bean interface name
        String beanName = beanPath.substring(beanPath.lastIndexOf('.'));

        if (!beanInstanceRegistry.containsKey(beanName)) {

            String classPath = beanPath;
            String impl = "Impl";
            if (!classPath.substring(classPath.length() - impl.length()).equals(impl)) {
                classPath += impl;
            }
            try {
                Class<?> clazz = Class.forName(classPath);
                Object obj = clazz.newInstance();
                beanInstanceRegistry.put(beanName, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return beanInstanceRegistry.get(beanName);
    }

    /**
     * Loads bean into context.
     *
     * @param beanName - name like "ChildBean"
     *
     * @return loaded class instance
     */
    private <T> T loadBeanByName(String beanName) {

        T obj = null;
        try {
            final Class<T> beanClass = (Class<T>) Class.forName(beanName);
            obj = beanClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
