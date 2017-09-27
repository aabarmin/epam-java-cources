package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implementation class for Task011.
 *
 * @author Sergei Titov
 */
public class Task018Impl implements Task018 {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {

        List<Annotation> list = new ArrayList<>();

        // package
        Collections.addAll(list, toCheck.getClass().getPackage().getDeclaredAnnotations());

        // type
        Collections.addAll(list, toCheck.getClass().getDeclaredAnnotations());

        // field
        Field[] fields = toCheck.getClass().getDeclaredFields();
        for (Field field: fields) {
            Collections.addAll(list, field.getDeclaredAnnotations());
        }

        // method
        Method[] methods = toCheck.getClass().getMethods();
        for (Method method: methods) {
            Collections.addAll(list, method.getDeclaredAnnotations());

            // parameters
            Arrays.stream(method.getParameterAnnotations())
            .flatMap( l -> Arrays.stream(l))
            .forEach( l -> list.add(l) );
        }

        // constructor
        Constructor[] constructors = toCheck.getClass().getConstructors();
        for (Constructor constructor: constructors) {
            Collections.addAll(list, constructor.getDeclaredAnnotations());
        }


        // find among collected annotations
        for (Annotation annotation: list) {
            if (annotation.annotationType().equals(annotationToFind)) {
                return true;
            }
        }
        return false;
    }
}
