package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinitionImpl;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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
    @SuppressWarnings("unchecked")
    public Object getBean(String beanName) {

        BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(beanName);
        Object obj;

        // check if we have it already created
        if (!beanInstanceRegistry.containsKey(beanName)
                || !"singleton".equals(beanDefinition.getScope())) {

            // load from context
            obj = loadBeanByName(beanDefinition.getClassName());
            beanInstanceRegistry.put(beanName, obj);
        }
        obj = beanInstanceRegistry.get(beanName);
        if (null == beanDefinition.getProperties()) {
            return obj;
        }

        // init bean with properties from it's BeanDefinition
        final Object bean = obj;
        beanDefinition.getProperties()
                .forEach(l -> {
                    try {
                        Field field = bean.getClass().getDeclaredField(l.getName());
                        field.setAccessible(true);

                        if (null != l.getValue()) {
                            field.set(bean, castingFor(field).apply(l.getValue()));

                        } else if (l instanceof BeanPropertyDefinitionImpl) {
                            BeanPropertyDefinitionImpl property = (BeanPropertyDefinitionImpl)l;

                            Collection<String> collectionOfStrings = property.getPropCollection();
                            Map<String, String> mapOfStrings = property.getPropMap();

                            if (null != collectionOfStrings && collectionOfStrings.size() > 0) {

                                // collection
                                field.set(bean, collectionOfStrings);

                            } else if (null != mapOfStrings && mapOfStrings.size() > 0) {

                                // map
                            } else if (l.getName().contains("property")) {

                                // property without value is incorrect
                                throw new RuntimeException("Bad property from XML");
                            }
                        }

                        if (null != l.getRef()) {
                            field.set(bean, getBean(l.getRef()));
                        }

                        field.setAccessible(false);

                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        obj = bean;

        return obj;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {

        return (T) getBean(beanName);
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
        String beanName = beanPath.substring(beanPath.lastIndexOf('.') + 1);

        if (!beanInstanceRegistry.containsKey(beanName)) {

            Object obj = null;

            String classPath = beanPath;
            String postfix = "Interface";
            // is it obviously if it's an interface?
            if (beanPath.substring(beanPath.length() - postfix.length()).equals(postfix)) {
                classPath = classPath.substring(0, beanPath.length() - postfix.length());
                try {
                    Class<?> clazz = Class.forName(classPath);
                    obj = clazz.newInstance();
                    beanInstanceRegistry.put(beanName, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (null != obj) {
                    return obj;
                }
            }

            // try "as is"
            try {
                Class<?> clazz = Class.forName(beanPath);
                obj = clazz.newInstance();
                beanInstanceRegistry.put(beanName, obj);
            } catch (Exception e) {
                System.out.println("interface instantiation occurs");
            }
            if (null != obj) {
                return obj;
            }

            // try with Impl
            postfix = "Impl";
            classPath = beanPath;
            if (!beanPath.substring(beanPath.length() - postfix.length()).equals(postfix)) {
                classPath += postfix;
            }
            try {
                Class<?> clazz = Class.forName(classPath);
                obj = clazz.newInstance();
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
            @SuppressWarnings("unchecked")
            final Class<T> beanClass = (Class<T>) Class.forName(beanName);
            obj = beanClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * Supplies with a caster to type, suitable for 'field'.
     *
     * @param field - reflexion's Field
     *
     * @return casting function
     */
    private Function castingFor(Field field) {

        Class<?> type = field.getType();

        // int
        if (type.equals(int.class)) {
            return (Function<String, Integer>)(l -> Integer.valueOf(l));
        }

        return (l -> l);
    }
}
