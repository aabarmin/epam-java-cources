package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "beans")
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    @XmlElement(type = BeanDefinitionImpl.class)
    private List<BeanDefinition> list = new ArrayList<>();

    //    private Map<String, BeanDefinition> map = new HashMap<>();
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        list.add(definition);
//        map.put(definition.getId(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return list.stream().filter(s -> s.getId().equals(beanId)).findFirst().get();
//        return map.get(beanId);
    }
}
