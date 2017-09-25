package com.epam.university.java.core.task018;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Task018Impl implements Task018 {

    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {

        List<AnnotatedElement> pullOfElements = new ArrayList<>();

        Class checkClass = toCheck.getClass();

        pullOfElements.add(checkClass);
        pullOfElements.add(checkClass.getPackage());

        List<Method> methodList = new ArrayList<>();

        methodList.addAll(Arrays.asList(checkClass.getMethods()));

        pullOfElements.addAll(methodList);
        pullOfElements.addAll(Arrays.asList(checkClass.getDeclaredConstructors()));
        pullOfElements.addAll(Arrays.asList(checkClass.getDeclaredFields()));

        boolean result = pullOfElements.stream()
                .flatMap(n -> Stream.of(n.getDeclaredAnnotations()))
                .map(n -> n.annotationType())
                .anyMatch(annotationToFind::equals)
                || methodList.stream()
                        .flatMap(n -> Stream.of(n.getParameters()))
                        .flatMap(n -> Stream.of(n.getDeclaredAnnotations()))
                        .map(n -> n.annotationType())
                        .anyMatch(annotationToFind::equals);
        return result;
    }
}