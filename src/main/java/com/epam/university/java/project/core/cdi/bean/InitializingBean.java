package com.epam.university.java.project.core.cdi.bean;

/**
 * Interface with callback which invoked after properties set.
 */
public interface InitializingBean {
    /**
     * After properties set callback.
     */
    void afterPropertiesSet();
}
