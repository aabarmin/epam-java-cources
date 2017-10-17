package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinition.ListItemDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ilya on 24.09.17.
 */
public class BeanFactoryImpl implements BeanFactory {

    private final BeanDefinitionRegistry registry;
    private Map<Class, Function<String, Object>> parsers = new HashMap<>();
    private Map<String, Object> singletones = new HashMap<>();

    /**
     * Constructor of BeanFactoryImpl.
     *
     * @param registry input BeanDefinitionRegistry
     */
    public BeanFactoryImpl(
        BeanDefinitionRegistry registry) {
        this.registry = registry;

        parsers.put(int.class, Integer::parseInt);
        parsers.put(String.class, (s) -> s);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return (T) getBean(beanClass.getName());
    }

    @Override
    public Object getBean(String beanName) {
        return checkRegistry(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return checkRegistry(beanName);
    }

    @SuppressWarnings("unchecked")
    private <T> T checkRegistry(String beanName) {
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        if (beanDefinition != null) {
            if ("singleton".equals(beanDefinition.getScope())) {
                Object o = singletones.get(beanName);
                if (o != null) {
                    return (T) o;
                } else {
                    T bean = getBeanByDefinition(beanDefinition);
                    singletones.put(beanName, bean);
                    return bean;
                }
            } else {
                return getBeanByDefinition(beanDefinition);
            }
        } else {
            BeanDefinition child = ((BeanDefinitionRegistryImpl) registry)
                .getByInferitance(beanName);
            if (child != null) {
                return getBeanByDefinition(child);
            }
        }

        throw new IllegalArgumentException("bean not defined");
    }

    @SuppressWarnings("unchecked")
    private <T> T getBeanByDefinition(BeanDefinition definition) {
        T bean = null;

        try {
            Class<?> aClass = Class.forName(definition.getClassName());
            bean = (T) aClass.newInstance();

            Collection<BeanPropertyDefinition> properties = definition.getProperties();
            if (properties == null) {
                return bean;
            }

            boolean check = properties
                .stream()
                .map(this::checkProp)
                .reduce((b1, b2) -> b1 && b2)
                .get();

            if (check) {
                throw new IllegalArgumentException(definition.getId() + " property not defined");
            }

            T finalBean = bean;
            properties
                .forEach(p -> {
                    try {
                        Field field = aClass.getDeclaredField(p.getName());
                        field.setAccessible(true);
                        if (p.getValue() != null) {
                            field.set(finalBean, parsers.get(field.getType()).apply(p.getValue()));
                        }
                        if (p.getRef() != null) {
                            field.set(finalBean, this.getBean(p.getRef()));
                        }
                        if (p.getData() != null) {
                            putData(finalBean, p, field);
                        }
                        field.setAccessible(false);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

            bean = finalBean;


        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private <T> void putData(T finalBean, BeanPropertyDefinition p, Field field)
        throws IllegalAccessException {
        StructureDefinition struct = p.getData();
        if (struct instanceof ListDefinition) {
            putList(finalBean, field, (ListDefinition) struct);
        } else if (struct instanceof MapDefinition) {
            putMap(finalBean, field, (MapDefinition) struct);
        }
    }

    private <T> void putMap(T finalBean, Field field, MapDefinition struct)
        throws IllegalAccessException {
        MapDefinition mapDefinition = struct;
        List<Entry<String>> list = mapDefinition.getValues()
            .stream()
            .map(e -> {
                if (e.getValue() != null) {
                    return new Entry<String>(Fields.STRING, e.getKey(),
                        e.getValue());
                } else if (e.getRef() != null) {
                    return new Entry<String>(Fields.REFERENCE, e.getKey(),
                        e.getRef());
                } else {
                    throw new IllegalArgumentException("this is not a map");
                }
            })
            .collect(Collectors.toList());
        Fields type = list.stream().findFirst().get().getType();

        // yes, now I'm throw in the towel
        switch (type) {
            case STRING:
                putStringMap(finalBean, field, list);
                break;
            case REFERENCE:
                putObjectMap(finalBean, field, list);
                break;
            default:
                break;
        }
    }

    private <T> void putList(T finalBean, Field field, ListDefinition struct)
        throws IllegalAccessException {
        ListDefinition listDefinition = struct;
        List<String> list = listDefinition.getItems().stream()
            .map(ListItemDefinition::getValue)
            .collect(Collectors.toList());
        field.set(finalBean, list);
    }

    private <T> void putStringMap(T finalBean, Field field, List<Entry<String>> list)
        throws IllegalAccessException {
        HashMap<String, String> map = list.stream()
            .collect(HashMap::new,
                (m, e) -> m.put(e.getKey(), e.getValue()),
                HashMap::putAll);
        field.set(finalBean, map);
    }

    private <T> void putObjectMap(T finalBean, Field field, List<Entry<String>> list)
        throws IllegalAccessException {
        HashMap<String, Object> map = list.stream()
            .collect(HashMap::new,
                (m, e) -> m.put(e.getKey(), this.getBean(e.getValue())),
                HashMap::putAll);
        field.set(finalBean, map);
    }

    private boolean checkProp(BeanPropertyDefinition propertyDefinition) {
        return propertyDefinition.getValue() == null
            && propertyDefinition.getData() == null
            && propertyDefinition.getRef() == null;
    }

    private class Entry<T> {

        private final Fields type;
        private final String key;
        private final T value;

        public Entry(Fields type, String key, T value) {
            this.type = type;
            this.key = key;
            this.value = value;
        }

        public Fields getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }
}
