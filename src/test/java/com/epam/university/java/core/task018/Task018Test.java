package com.epam.university.java.core.task018;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task018Test {
    private Task018 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task018.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullClass() throws Exception {
        instance.isAnnotationPresent(null, BasicAnnotation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullAnnotation() throws Exception {
        instance.isAnnotationPresent(new ClassWithoutAnnotations(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullArgs() throws Exception {
        instance.isAnnotationPresent(null, null);
    }

    @Test
    public void noAnnotation() throws Exception {
        assertFalse("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithoutAnnotations(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnType() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnType(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnMethod() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnMethod(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnField() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnField(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnConstructor() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnConstructor(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnMethodArgument() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnMethodArgument(),
                        BasicAnnotation.class
                )
        );
    }

    @Test
    public void annotationOnPackage() throws Exception {
        assertTrue("Incorrect result",
                instance.isAnnotationPresent(
                        new ClassWithAnnotationOnMethodArgument(),
                        PackageAnnotation.class
                )
        );
    }
}