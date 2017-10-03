package com.epam.university.java.core.task018;

import com.epam.university.java.core.utils.common.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Admin on 27.09.2017.
 */
public class Task018Impl implements Task018 {
    @Override
    @SuppressWarnings("unchecked")
    public boolean isAnnotationPresent(Object toCheck, Class<?>
            annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<Annotation> annotations = new ArrayList<>();
        Class<? extends Annotation> toFind = (Class<? extends Annotation>)
                annotationToFind;
        annotations.addAll(getPackageAnnotations(toCheck, toFind));
        annotations.addAll(getTypeAnnotations(toCheck, toFind));
        annotations.addAll(getFieldsAnnotations(toCheck, toFind));
        annotations.addAll(getConstructorsAnnotations(toCheck, toFind));
        annotations.addAll(getMethodsAnnotations(toCheck, toFind));
        annotations.addAll(getMethodsParametersAnnotations(toCheck, toFind));
        System.out.println(annotations);
        return !annotations.isEmpty();
    }

    /**
     * Get package's annotations.
     *
     * @param toCheck          class that belongs to package
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getPackageAnnotations(Object toCheck, Class<? extends
            Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        Annotation[] annotationsArray = toCheck.getClass().getPackage()
                .getDeclaredAnnotations();
        Stream.of(annotationsArray).parallel().forEach(annotation -> {
            if (annotation.annotationType().equals(annotationToFind)) {
                annotations.add(annotationToFind);
            }
        });
        return annotations;
    }

    /**
     * Get type's annotations.
     *
     * @param toCheck          class to check
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getTypeAnnotations(Object toCheck, Class<? extends
            Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        if (toCheck.getClass().isAnnotationPresent(annotationToFind)) {
            annotations.add(annotationToFind);
        }
        return annotations;
    }

    /**
     * Get annotations of fields.
     *
     * @param toCheck          class with fields to check
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getFieldsAnnotations(Object toCheck, Class<? extends
            Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        Field[] fields = toCheck.getClass().getDeclaredFields();
        Stream.of(fields).parallel().forEach(field -> {
            if (field.isAnnotationPresent(annotationToFind)) {
                annotations.add(annotationToFind);
            }
        });

        return annotations;
    }

    /**
     * Get annotations of constructors.
     *
     * @param toCheck          class with constructors to check
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getConstructorsAnnotations(Object toCheck, Class<? extends
            Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        Constructor[] constructors = toCheck.getClass().getConstructors();
        Stream.of(constructors).parallel().forEach(constructor -> {
            if (constructor.isAnnotationPresent(annotationToFind)) {
                annotations.add(annotationToFind);
            }
        });
        return annotations;
    }

    /**
     * Get annotations of methods.
     *
     * @param toCheck          class with methods to check
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getMethodsAnnotations(Object toCheck, Class<? extends
            Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        Method[] methods = toCheck.getClass().getMethods();
        Stream.of(methods).parallel().forEach(method -> {
            if (method.isAnnotationPresent(annotationToFind)) {
                annotations.add(annotationToFind);
            }
        });
        return annotations;
    }

    /**
     * Get annotations of methods parameters.
     *
     * @param toCheck          class with methods parameters to check
     * @param annotationToFind annotation to find
     * @return <code>List</code> collection with existing annotations
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public List getMethodsParametersAnnotations(Object toCheck, Class<?
            extends Annotation> annotationToFind) {
        Validator.validateNotNull(toCheck, annotationToFind,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List annotations = new ArrayList();
        Method[] methods = toCheck.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            for (int j = 0; j < methods[i].getParameterAnnotations().length;
                 j++) {
                for (Annotation annotation : methods[i]
                        .getParameterAnnotations()[j]) {
                    if (annotation.annotationType().equals(annotationToFind)) {
                        annotations.add(annotationToFind);
                    }
                }
            }
        }
        return annotations;
    }
}