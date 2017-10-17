package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation class for BeanDefinitionRegistry.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.NONE)
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    // map of {Bean ID -> Bean class name}
    private Map<String, BeanDefinition> beanNameRegistry = new HashMap<>();

    @XmlElement(name = "bean")
    BeanDefinitionImpl[] getBeanNameRegistry() {
        List<BeanDefinition> list = new ArrayList<>();
        list.addAll(beanNameRegistry.values());
        return list.toArray(new BeanDefinitionImpl[list.size()]);
    }

    public void setBeanNameRegistry(BeanDefinitionImpl[] arr) {
        Arrays.stream(arr).forEach(this::addBeanDefinition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {

        if (!beanNameRegistry.containsKey(definition.getId())) {
            beanNameRegistry.put(definition.getId(), definition);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {

        return beanNameRegistry.get(beanId);
    }


    /**
     * Get size of the registry.
     *
     * @return a number of bean definitions
     */
    public int getSize() {
        return beanNameRegistry.size();
    }

    /**
     * Get collection of BeanDefinitions.
     *
     * @return collection of bean definitions
     */
    public Collection<BeanDefinition> values () {
        return beanNameRegistry.values();
    }
}