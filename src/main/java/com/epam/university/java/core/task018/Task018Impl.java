package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;

public class Task018Impl implements Task018 {
    /**
     * Check is annotation present in the following object.
     *
     * @param toCheck          object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        Annotation[] annotations = toCheck.getClass().getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotationToFind.equals(annotation)) {
                return true;
            }
        }
        return false;
    }
}
