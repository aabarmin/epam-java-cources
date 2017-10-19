package com.epam.university.java.project.core.cdi.context;

/**
 * Created by Вера on 17.10.2017.
 */
public class ApplicationContextFactoryImpl implements ApplicationContextFactory {
    @Override
    public ApplicationContext newInstance() {
        return new ApplicationContextImpl();
    }
}
