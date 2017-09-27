package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.impl.bean.DefaultBeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.impl.bean.DefaultBeanFactory;
import com.epam.university.java.project.core.cdi.impl.bean.XmlBeanDefinitionReader;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

/**
 * Default XML application context implementation.
 */
public class ApplicationContextImpl implements ApplicationContext {

    private final BeanDefinitionReader reader;
    private final BeanDefinitionRegistry registry;
    private final BeanFactory factory;

    /**
     * Constructs default xml application context.
     */
    public ApplicationContextImpl() {
        registry = new DefaultBeanDefinitionRegistry();
        reader = new XmlBeanDefinitionReader(registry);
        factory = new DefaultBeanFactory(registry);
    }

    /**
     * Load bean definitions from designated resource.
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        return reader.loadBeanDefinitions(resource);
    }

    /**
     * Load bean definitions from collection of resources.
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return reader.loadBeanDefinitions(resources);
    }

    /**
     * Get bean instances by class.
     * @param beanClass bean class to get
     * @param <T> bean type
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return factory.getBean(beanClass);
    }

    /**
     * Get bean instance by  definition name.
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        return factory.getBean(beanName);
    }

    /**
     * Get bean instance by definition name and target class.
     * @param beanName bean definition name
     * @param beanClass target bean class
     * @param <T> bean type
     * @return bean instance
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return factory.getBean(beanName, beanClass);
    }

}
