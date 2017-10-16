package com.epam.university.java.project.core.cdi.bean;

public class BeanMapper<T> {

    T bean;

    public T getBean(BeanDefinition definition){
        definition.getProperties();

        try {
            bean = (T)Class.forName(definition.getClassName()).newInstance();














        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return bean;
    }
}
