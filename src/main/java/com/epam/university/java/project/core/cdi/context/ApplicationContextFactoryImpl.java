package com.epam.university.java.project.core.cdi.context;

/**
 * Class implements <code>ApplicationContextFactory</code> interface.
 */
public class ApplicationContextFactoryImpl implements
        ApplicationContextFactory {

    @Override
    public ApplicationContext newInstance() {
        return new ApplicationContextImpl();
    }
}
