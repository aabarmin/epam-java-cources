package com.epam.university.java.project.core.cdi.context;

/**
 * Created by Александр on 29.09.2017.
 */
public class ApplicationContextFactoryImpl implements ApplicationContextFactory {
    /**
     * Get new application context instance.
     *
     * @return instance
     */
    @Override
    public ApplicationContext newInstance() {
        return new BasicApplicationContext();
    }
}
