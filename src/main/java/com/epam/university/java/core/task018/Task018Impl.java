package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Annotations.
 */
public class Task018Impl implements Task018 {

    /**
     * Check is annotation present in the following object.
     * @param toCheck object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck,
                                       Class<?> annotationToFind) {
        // package level
        Package objectPackage = toCheck
            .getClass()
            .getPackage();
        // class level
        Class<?> objectClass = toCheck
            .getClass();
        // constructor level
        Constructor<?>[] constructors = toCheck
            .getClass()
            .getDeclaredConstructors();
        // method level
        Method[] methods = toCheck
            .getClass()
            .getDeclaredMethods();
        // field level
        Field[] fields = toCheck
            .getClass()
            .getDeclaredFields();

        return isPresentInAnnotatedElements(annotationToFind, objectPackage)
            || isPresentInAnnotatedElements(annotationToFind, objectClass)
            || isPresentInExecutables(annotationToFind, constructors)
            || isPresentInExecutables(annotationToFind, methods)
            || isPresentInAnnotatedElements(annotationToFind, fields);
    }

    /**
     * Checks if any of the annotations is of given type.
     * @param annotationToFind type of  annotation to find
     * @param annotations annotations to check
     * @return <code>true</code> if found one, else <code>false</code>
     */
    private boolean isPresent(Class<?> annotationToFind,
                              Annotation... annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == annotationToFind) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if any of the executable (or it's parameter) has annotation
     * of the given type.
     * @param annotationToFind type of  annotation to find
     * @param execs executables to check
     * @return <code>true</code> if found one, else <code>false</code>
     */
    private boolean isPresentInExecutables(Class<?> annotationToFind,
                                           Executable... execs) {
        for (Executable exec : execs) {
            Annotation[] annotations = exec.getDeclaredAnnotations();
            if (isPresent(annotationToFind, annotations)) {
                return true;
            }
            // parameter level
            Parameter[] parameters = exec.getParameters();
            if (isPresentInAnnotatedElements(annotationToFind, parameters)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if any of the annotated elements has annotation of the given type.
     * @param annotationToFind type of  annotation to find
     * @param elems annotated elements to check
     * @return <code>true</code> if found one, else <code>false</code>
     */
    private boolean isPresentInAnnotatedElements(Class<?> annotationToFind,
                                                 AnnotatedElement... elems) {
        for (AnnotatedElement elem : elems) {
            Annotation[] annotations = elem.getDeclaredAnnotations();
            if (isPresent(annotationToFind, annotations)) {
                return true;
            }
        }
        return false;
    }

}
