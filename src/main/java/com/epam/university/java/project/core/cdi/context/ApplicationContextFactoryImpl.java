package com.epam.university.java.project.core.cdi.context;

/**
 * Implementation class for ApplicationContextFactory.
 *
 * @author Sergei Titov
 */
public class ApplicationContextFactoryImpl implements ApplicationContextFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public ApplicationContext newInstance() {

        return new ApplicationContextImpl();
    }
}
