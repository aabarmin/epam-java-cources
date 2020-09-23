package com.epam.university.java.project.core.cdi.context;

/**
 * Created by Romin Nuro on 24.09.2020 0:31.
 */
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
