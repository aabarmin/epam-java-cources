package com.epam.university.java.project.core.cdi.structure;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.context.ApplicationContextFactory;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test for structures injection.
 */
public class StructuresTest {
    private ApplicationContext applicationContext;
    private ApplicationContextFactory contextFactory;

    @Before
    public void setUp() throws Exception {
        contextFactory = TestHelper.getInstance(ApplicationContextFactory.class);
        applicationContext = contextFactory.newInstance();
    }

    @Test
    public void testStructures() throws Exception {
        final String contextConfigPath =
                getClass().getResource("/project/project003.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextConfigPath));
        // load and check
        final ComplexObject complexObject =
                applicationContext.getBean("complexObject", ComplexObject.class);
        // check collection
        assertNotNull("Can't load object from context", complexObject);
        assertNotNull("Can't load list collection from context",
                complexObject.getStringCollection());
        assertFalse("Can't load items from collection",
                complexObject.getStringCollection().isEmpty());
        // check map of strings
        assertNotNull("Can't load map from object", complexObject.getStringMap());
        assertNotNull("Can't get object from map", complexObject.getStringMap().get("firstKey"));
        assertEquals("Incorrect value in map",
                "secondValue",
                complexObject.getStringMap().get("secondKey"));
        // check map of objects
        assertNotNull("Can't load map of objects", complexObject.getObjectMap());
        assertNotNull("Can't get map object", complexObject.getObjectMap().get("firstKey"));
        assertTrue("Incorrect value in object map",
                complexObject.getObjectMap().get("secondKey") instanceof ComplexObject);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectStructures() throws Exception {
        final String contextConfigPath =
                getClass().getResource("/project/project004.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextConfigPath));
        // load and check
        applicationContext.getBean("complexObject", ComplexObject.class);
    }
}
