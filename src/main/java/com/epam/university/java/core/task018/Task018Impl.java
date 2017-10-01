package com.epam.university.java.core.task018;

/**
 * Created by Вера on 27.09.2017.
 */
public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (annotationToFind == null) {
            throw new NullPointerException();
        }
        if (toCheck == annotationToFind) {
            return true;
        }
        String s1 = annotationToFind.getSimpleName();
        String s2 = annotationToFind.getName();
        toCheck.getClass();

        return annotationToFind.getClass().equals(toCheck);
        //return toCheck.getClass() == annotationToFind.getClass();
        // return false;
    }
}
