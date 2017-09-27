package com.epam.university.java.core.task018;

/**
 * Annotations.
 */
public interface Task018 {
    /**
     * Check is annotation present in the following object.
     * @param toCheck object to check
     * @param annotationToFind annotation to look for
     * @return is annotation presents
     */
    boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind);
}
