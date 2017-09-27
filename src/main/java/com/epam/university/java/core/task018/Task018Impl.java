package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Admin on 27.09.2017.
 */
public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        List annotations = new ArrayList();
        Class<? extends Annotation> toFind = (Class<? extends Annotation>) annotationToFind;

        annotations.addAll(getPackageAnnotations(toCheck, toFind));
        annotations.addAll(getTypeAnnotations(toCheck, toFind));
        annotations.addAll(getFieldsAnnotations(toCheck, toFind));
        annotations.addAll(getConstructorsAnnotations(toCheck, toFind));
        annotations.addAll(getMethodsAnnotations(toCheck, toFind));
        annotations.addAll(getMethodsParametersAnnotations(toCheck, toFind));

        System.out.println(annotations);
        return !annotations.isEmpty();
    }

    public List getPackageAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        Annotation[] annotationsArray = toCheck.getClass().getPackage().getDeclaredAnnotations();
        Stream.of(annotationsArray).parallel()
                .forEach(annotation -> {
                    System.out.println(annotation);
                    if (annotation.annotationType().equals(annotationToFind))
                        annotations.add(annotationToFind);
                });
        return annotations;
    }

    public List getTypeAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        if (toCheck.getClass().isAnnotationPresent(
                (Class<? extends Annotation>) annotationToFind)) {
            annotations.add(annotationToFind);
        }
        return annotations;
    }

    public List getFieldsAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        Field[] fields = toCheck.getClass().getDeclaredFields();
        Stream.of(fields).parallel()
                .forEach(field -> {
                    System.out.println(field.getAnnotations().length);
                    if (field.isAnnotationPresent((Class<? extends Annotation>) annotationToFind))
                        annotations.add(annotationToFind);
                });

        return annotations;
    }

    public List getConstructorsAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        Constructor[] constructors = toCheck.getClass().getConstructors();
        Stream.of(constructors).parallel()
                .forEach(constructor -> {
                    System.out.println(constructor.getAnnotations().length);
                    if (constructor.isAnnotationPresent((Class<? extends Annotation>) annotationToFind))
                        annotations.add(annotationToFind);
                });
        return annotations;
    }

    public List getMethodsAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        Method[] methods = toCheck.getClass().getMethods();
        Stream.of(methods).parallel()
                .forEach(method -> {
                    System.out.println(method.getAnnotations().length);
                    if (method.isAnnotationPresent((Class<? extends Annotation>) annotationToFind))
                        annotations.add(annotationToFind);
                });
        return annotations;
    }

    public List getMethodsParametersAnnotations(Object toCheck, Class<? extends Annotation> annotationToFind) {
        List annotations = new ArrayList();
        Method[] methods = toCheck.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            for (int j = 0; j < methods[i].getParameterAnnotations().length; j++) {
                for (Annotation annotation : methods[i].getParameterAnnotations()[j]) {
                    System.out.println(methods[i].getParameterAnnotations()[j].length);
                    if (annotation.annotationType().equals(annotationToFind)) {
                        annotations.add(annotationToFind);
                    }
                }
            }
        }
        return annotations;
    }
}