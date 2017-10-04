package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Check default XML application context.
 */
public class ApplicationContextTest {
    private ApplicationContextFactory contextFactory;
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        contextFactory = TestHelper.getInstance(ApplicationContextFactory.class);
        applicationContext = contextFactory.newInstance();
    }

    @Test
    public void loadCorrectDefinitionsFromXml() throws Exception {
        final String testFilePath = getClass().getResource("/project/project001.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        // try to get beans from context
        final ParentBean parentBean = (ParentBean) applicationContext.getBean("parentBean");
        assertNotNull("Can't get bean definition from context", parentBean);
        assertNotNull("Can't get loaded bean property", parentBean.getProperty1());
        assertEquals("Can't get loaded bean property", 10, parentBean.getProperty2());
        assertNotNull("Can't get injected bean property", parentBean.getChildBean());
        assertNotNull("Can't get child bean property", parentBean.getChildBean().getProperty1());
        assertEquals("Can't get child bean property", 20, parentBean.getChildBean().getProperty2());
    }

    @Test
    public void loadCorrectDefinitionsFromXmlDifferentWays() throws Exception {
        final String testFilePath = getClass().getResource("/project/project001.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        // try to get beans different ways
        // by name
        final Object byName = applicationContext.getBean("parentBean");
        assertNotNull("Can't get bean by name", byName);
        // by class
        final ParentBean byClass = applicationContext.getBean(ParentBean.class);
        assertNotNull("Can't get bean by class", byClass);
        // by name and class
        final ParentBean byClassAndName =
                applicationContext.getBean("parentBean", ParentBean.class);
        assertNotNull("Can't get bean by name and class", byClassAndName);
        // by interface
        final ParentBeanInterface byInterface =
                applicationContext.getBean(ParentBeanInterface.class);
        assertNotNull("Can't get beans by interface", byInterface);
    }

    @Test
    public void loadSingletonBeans() throws Exception {
        final String testFilePath = getClass().getResource("/project/project001.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        // load beans several times
        final ParentBean instance1 = applicationContext.getBean(ParentBean.class);
        final ParentBean instance2 = applicationContext.getBean(ParentBean.class);
        assertTrue("Singletons are not equal", instance1 == instance2);
    }

    @Test
    public void loadStatelessBeans() throws Exception {
        final String testFilePath = getClass().getResource("/project/project001.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        // load beans several times
        final Object instance1 = applicationContext.getBean("statelessBean");
        final Object instance2 = applicationContext.getBean("statelessBean");
        assertFalse("Stateless beans are the same", instance1 == instance2);
    }

    @Test
    public void loadStatelessBeanWithSingletonProperties() throws Exception {
        final String testFilePath = getClass().getResource("/project/project001.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        //
        final StatelessBeanWithDependency instance1 =
                applicationContext.getBean(
                        "statelessBeanWithDependencies",
                        StatelessBeanWithDependency.class);
        final StatelessBeanWithDependency instance2 =
                applicationContext.getBean(
                        "statelessBeanWithDependencies",
                        StatelessBeanWithDependency.class);
        //
        assertFalse("Stateless beans are equal", instance1 == instance2);
        assertTrue("Inner beans are not equal",
                instance1.getSingletonBean() == instance2.getSingletonBean());
    }

    @Test(expected = RuntimeException.class)
    public void loadIncorrectDefinitionsFromXml() throws Exception {
        final String testFilePath = getClass().getResource("/project/project002.xml").getFile();
        // try to load beans from xml
        final XmlResource xmlResource = new XmlResource(testFilePath);
        applicationContext.loadBeanDefinitions(xmlResource);
        applicationContext.getBean("parentBean");
    }
}