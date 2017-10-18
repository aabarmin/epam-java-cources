package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinition.ListItemDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition.MapEntryDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory {
    private BeanDefinitionRegistry registry;
    private Map<String, Object> singletons = new HashMap<>();

    /**
     * Constructor for BeanFactoryImpl.
     * @param registry registry
     */
    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public Object getBean(String beanName) {
        String beanId = beanName.substring(beanName.lastIndexOf(".") + 1)
                .replace("Interface", "");
        beanId = beanId.substring(0, 1).toLowerCase() + beanId.substring(1);

        BeanDefinition definition = registry.getBeanDefinition(beanId);
        if (definition == null) {
            return null;
        }
        if ("singleton".equals(definition.getScope())
                && singletons.containsKey(beanId)) {
            return singletons.get(beanId);
        }

        Object bean;

        try {
            bean = Class.forName(definition.getClassName()).newInstance();
            for (BeanPropertyDefinition property : definition.getProperties()) {

                Field field = bean.getClass().getDeclaredField(property.getName());
                field.setAccessible(true);

                if (property.getValue() != null) {
                    if (field.getType() == int.class) {
                        field.set(bean, Integer.parseInt(property.getValue()));
                    } else {
                        field.set(bean, property.getValue());
                    }

                } else if (property.getRef() != null) {
                    field.set(bean, getBean(property.getRef()));

                } else if (property.getData() != null) {
                    StructureDefinition data = property.getData();

                    if (data instanceof ListDefinition) {
                        List<String> items = new ArrayList<>();
                        for (ListItemDefinition dataItem : ((ListDefinition) data).getItems()) {
                            items.add(dataItem.getValue());
                        }
                        field.set(bean, items);

                    } else if (data instanceof MapDefinition) {
                        Map<Object, Object> values = new HashMap<>();
                        Collection<MapEntryDefinition> values1 = ((MapDefinition) data).getValues();
                        for (MapEntryDefinition entry : values1) {
                            if (entry.getValue() != null) {
                                values.put(entry.getKey(), entry.getValue());
                            } else if (entry.getRef() != null) {
                                values.put(entry.getKey(), getBean(entry.getRef()));
                            }
                        }
                        field.set(bean, values);
                    }
                } else {
                    throw new RuntimeException();
                }
            }

            if (definition.getPostConstruct() != null) {
                bean.getClass().getDeclaredMethod(definition.getPostConstruct()).invoke(bean);
            }

            if ("singleton".equals(definition.getScope())) {
                singletons.put(definition.getId(), bean);
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
