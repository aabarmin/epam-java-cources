package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReaderImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

/**
 * Created by Romin Nuro on 24.09.2020 0:31.
 */
public class ApplicationContextImpl implements ApplicationContext {
    BeanDefinitionRegistry registry = new BeanDefinitionRegistryImpl();
    BeanDefinitionReader reader = new BeanDefinitionReaderImpl(registry);

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        return reader.loadBeanDefinitions(resource);
    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return reader.loadBeanDefinitions(resources);
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
