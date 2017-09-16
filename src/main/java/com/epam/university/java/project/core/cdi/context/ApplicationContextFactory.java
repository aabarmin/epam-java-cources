package com.epam.university.java.project.core.cdi.context;

/**
 * Application contexts factory.
 */
public interface ApplicationContextFactory {
    /**
     * Get new application context instance.
     * @return instance
     */
    ApplicationContext newInstance();
}
