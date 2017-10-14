package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactoryImpl implements BeanFactory {

    private final BeanDefinitionRegistry beanDefinitionRegistry;
    private final Map<String, Object> singletoneBeans = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {

        final BeanDefinition beanDefinition = beanDefinitionRegistry
                .getBeanDefinition(beanClass.getName());

        if (beanDefinition == null) {
            throw new RuntimeException("Can't find bean definition by class: " + beanClass);
        }

        try {
            return getBean(beanDefinition);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {

        final BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanName);

        if (beanDefinition == null) {
            throw new RuntimeException("Can't find bean definition by name: " + beanName);
        }

        try {
            Object bean = getBean(beanDefinition);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }

    @SuppressWarnings("unchecked")
    private <T> T getBean(BeanDefinition beanDefinition) throws Exception {

        final String beanId = beanDefinition.getId();
        final String beanClassName = beanDefinition.getClassName();
        final String postConstruct = (beanDefinition.getPostConstruct() == null
                ? "" : beanDefinition.getPostConstruct());

        final Class<T> beanClass = (Class<T>) Class.forName(beanClassName);
        final T bean = beanClass.newInstance();

        if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
            if (singletoneBeans.containsKey(beanId)) {
                return (T) singletoneBeans.get(beanId);
            } else {
                singletoneBeans.put(beanId, bean);
            }
        }

        for (BeanPropertyDefinition beanPropertyDefinition : beanDefinition.getProperties()) {

            final Field beanField
                    = beanClass.getDeclaredField(beanPropertyDefinition.getName());
            beanField.setAccessible(true);

            final String value = (beanPropertyDefinition.getValue() == null
                    ? "" : beanPropertyDefinition.getValue());
            final String ref = (beanPropertyDefinition.getRef() == null
                    ? "" : beanPropertyDefinition.getRef());

            final StructureDefinition data = beanPropertyDefinition.getData();

            if (!value.trim().isEmpty()) {

                if (beanField.getType().isAssignableFrom(Integer.TYPE)) {
                    beanField.set(bean, Integer.parseInt(value));
                } else if (beanField.getType().isAssignableFrom(Long.TYPE)) {
                    beanField.set(bean, Long.parseLong(value));
                } else if (beanField.getType().isAssignableFrom(Float.TYPE)) {
                    beanField.set(bean, Float.parseFloat(value));
                } else if (beanField.getType().isAssignableFrom(Double.TYPE)) {
                    beanField.set(bean, Double.parseDouble(value));
                } else {
                    beanField.set(bean, value);
                }

            } else if (!ref.trim().isEmpty()) {

                beanField.set(bean, getBean(ref));

            } else if (data != null) {

                if (data instanceof ListDefinition) {

                    ListDefinition listDefinition = (ListDefinition) data;

                    List<Object> list = new ArrayList<>();
                    for (ListDefinition.ListItemDefinition itemDefinition
                            : listDefinition.getItems()) {
                        list.add(itemDefinition.getValue());
                    }

                    beanField.set(bean, list);

                } else if (data instanceof MapDefinition) {

                    MapDefinition mapDefinition = (MapDefinition) data;
                    Map<Object, Object> map = new HashMap<>();

                    for (MapDefinition.MapEntryDefinition entryDefinition
                            : mapDefinition.getValues()) {

                        final String entryKey = entryDefinition.getKey();
                        final String entryValue = (entryDefinition.getValue() == null
                                ? "" : entryDefinition.getValue());
                        final String entryref = (entryDefinition.getRef() == null
                                ? "" : entryDefinition.getRef());

                        if (!entryValue.trim().isEmpty()) {
                            map.put(entryKey, entryValue);
                        } else if (!entryref.trim().isEmpty()) {
                            map.put(entryKey, getBean(entryref));
                        } else {
                            throw new RuntimeException("There is no value for property "
                                    + beanPropertyDefinition.getName() + " in bean "
                                    + beanDefinition.getClassName()
                            );
                        }

                    }

                    beanField.set(bean, map);

                } else {
                    throw new RuntimeException("Unsupported instance of StructureDefinition");
                }

            } else {

                throw new RuntimeException("There is no value for property "
                        + beanPropertyDefinition.getName() + " in bean "
                        + beanDefinition.getClassName()
                );

            }

        }

        if (!postConstruct.trim().isEmpty()) {
            beanClass.getDeclaredMethod(postConstruct).invoke(bean);
        }

        if (InitializingBean.class.isAssignableFrom(beanClass)) {
            ((InitializingBean) bean).afterPropertiesSet();
        }

        return bean;

    }

}
