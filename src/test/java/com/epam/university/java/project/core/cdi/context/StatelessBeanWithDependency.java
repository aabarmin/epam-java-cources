package com.epam.university.java.project.core.cdi.context;

/**
 * Demo stateless bean with dependencies.
 */
public class StatelessBeanWithDependency {
    private SingletonBean singletonBean;

    public SingletonBean getSingletonBean() {
        return singletonBean;
    }

    public void setSingletonBean(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }
}
