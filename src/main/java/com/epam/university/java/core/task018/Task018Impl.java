package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task018Impl implements Task018 {


    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {

        List<AnnotatedElement> annotatedElements = new ArrayList<AnnotatedElement>();

        annotatedElements.add(toCheck.getClass());

        annotatedElements.add(toCheck.getClass().getPackage());


        Collections.addAll(annotatedElements, toCheck.getClass().getDeclaredFields());
        Collections.addAll(annotatedElements, toCheck.getClass().getDeclaredConstructors());

        Method[] methods = toCheck.getClass().getDeclaredMethods();
        Collections.addAll(annotatedElements, methods);

        for (Method method : methods) {
            Collections.addAll(annotatedElements, method.getParameters());
        }
        for (AnnotatedElement annotatedElement : annotatedElements) {
            for (Annotation annotation : annotatedElement.getDeclaredAnnotations()) {
                if (annotationToFind.isInstance(annotation)) {
                    return true;
                }
            }
        }
        return false;

    }

}
