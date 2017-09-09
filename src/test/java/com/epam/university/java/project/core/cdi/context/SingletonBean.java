package com.epam.university.java.project.core.cdi.context;

/**
 * @author ABarmin
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
