package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        Annotation[] annotations = toCheck.getClass().getAnnotations();
        Annotation[] annotations2 = annotationToFind.getAnnotations();
        if (annotationToFind.isInstance(BasicAnnotation.class)) {

        } else {
            // for package
        }
        return false;
    }
}
