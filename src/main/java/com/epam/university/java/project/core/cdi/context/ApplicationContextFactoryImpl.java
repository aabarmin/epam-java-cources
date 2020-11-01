package com.epam.university.java.project.core.cdi.context;

public class ApplicationContextFactoryImpl implements ApplicationContextFactory {
    @Override
    public ApplicationContext newInstance() {
        return new ApplicationContextImpl();
    }
}
