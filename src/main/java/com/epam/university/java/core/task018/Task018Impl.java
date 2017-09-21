package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 21.09.17.
 */
public class Task018Impl implements Task018 {

    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        List<AnnotatedElement> elements = new ArrayList<>();

        Class objectClass = toCheck.getClass();
        elements.add(objectClass);

        Package objectPackage = objectClass.getPackage();
        elements.add(objectPackage);

        Method[] methods = objectClass.getDeclaredMethods();
        Collections.addAll(elements, methods);

        Constructor[] constructors = objectClass.getConstructors();
        Collections.addAll(elements, constructors);

        Field[] fields = objectClass.getDeclaredFields();
        Collections.addAll(elements, fields);

        List<Annotation> annotations = elements.stream()
            .flatMap(a -> Stream.of(a.getDeclaredAnnotations()))
            .filter(a -> a.annotationType().equals(annotationToFind))
            .collect(Collectors.toList());

        List<Annotation> parameterAnnotations = Stream.of(methods)
            .flatMap(m -> Stream.of(m.getParameters()))
            .flatMap(p -> Stream.of(p.getDeclaredAnnotations()))
            .filter(a -> a.annotationType().equals(annotationToFind))
            .collect(Collectors.toList());
        annotations.addAll(parameterAnnotations);

        if (annotations.size() != 0) {
            return true;
        }

        return false;
    }


}
