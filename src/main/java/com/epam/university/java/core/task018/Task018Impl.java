package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        List<Annotation> annotations = new ArrayList<>();

        Class objectClass = toCheck.getClass();
        annotations.addAll(Arrays.asList(objectClass.getDeclaredAnnotations()));

        Package objectPackage = objectClass.getPackage();
        annotations.addAll(Arrays.asList(objectPackage.getDeclaredAnnotations()));

        Constructor[] constructors = objectClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            annotations.addAll(Arrays.asList(constructor.getDeclaredAnnotations()));
            for (Annotation[] constrParamAnn : constructor.getParameterAnnotations()) {
                annotations.addAll(Arrays.asList(constrParamAnn));
            }
        }

        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            annotations.addAll(Arrays.asList(method.getDeclaredAnnotations()));
            for (Annotation[] methodParamAnn : method.getParameterAnnotations()) {
                annotations.addAll(Arrays.asList(methodParamAnn));
            }
        }

        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            annotations.addAll(Arrays.asList(field.getDeclaredAnnotations()));
        }

        for (Annotation annElement : annotations) {
            if (annElement.annotationType().equals(annotationToFind)) {
                return true;
            }
        }

        return false;
    }
}