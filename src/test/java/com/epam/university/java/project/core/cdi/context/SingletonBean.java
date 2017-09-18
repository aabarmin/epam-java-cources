package com.epam.university.java.project.core.cdi.context;

/**
 * Demo bean. This bean assumed as singleton - only single
 * instance in context.
 */
public class SingletonBean {
    private StatelessBean childBean;

    public StatelessBean getChildBean() {
        return childBean;
    }

    public void setChildBean(StatelessBean childBean) {
        this.childBean = childBean;
    }
}
