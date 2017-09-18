package com.epam.university.java.project.core.cdi.bean;

/**
 * Create bean instances by definitions.
 */
public interface BeanFactory {
    /**
     * Get bean instances by class.
     * @param beanClass bean class to get
     * @param <T> bean type
     * @return bean instance
     */
    <T> T getBean(Class<T> beanClass);

    /**
     * Get bean instance by  definition name.
     * @param beanName bean definition name
     * @return bean instance
     */
    Object getBean(String beanName);

    /**
     * Get bean instance by definition name and target class.
     * @param beanName bean definition name
     * @param beanClass target bean class
     * @param <T> bean type
     * @return bean instance
     */
    <T> T getBean(String beanName, Class<T> beanClass);
}
