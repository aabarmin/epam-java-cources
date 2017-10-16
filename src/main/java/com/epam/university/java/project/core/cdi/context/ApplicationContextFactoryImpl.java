package com.epam.university.java.project.core.cdi.context;

public class ApplicationContextFactoryImpl implements ApplicationContextFactory {
    /**
     * Get new application context instance.
     *
     * @return instance
     */
    @Override
    public ApplicationContext newInstance() {
        return new ApplicationContextImpl();
    }
}
