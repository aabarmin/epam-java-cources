package com.epam.university.java.project.core.cdi.context;

/**
 * Created by ilya on 24.09.17.
 */
public class ApplicationContextFactoryImpl implements ApplicationContextFactory {

    @Override
    public ApplicationContext newInstance() {
        return new ApplicationContextXmlImpl();
    }
}
