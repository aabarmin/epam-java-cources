package com.epam.university.java.project.core.cdi.bean;

/**
 * Created by Александр on 30.09.2017.
 */
public class BeanFactoryImpl implements BeanFactory {
    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        return null;
    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
