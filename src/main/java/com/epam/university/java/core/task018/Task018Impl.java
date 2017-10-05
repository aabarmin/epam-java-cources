package com.epam.university.java.core.task018;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Вера on 27.09.2017.
 */
public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class annotationToFind) {
        // проверка аннотации над классом
        Class classToCheck = toCheck.getClass();

        if (classToCheck.isAnnotationPresent(annotationToFind)) {
            return true;
        }

        //проверка аннотации над пакетом
        Package p = classToCheck.getPackage();
        if (p.isAnnotationPresent(annotationToFind)) {
            return true;
        }

        // наличие конструкоторов с аннотацией
        Constructor[] constructors = classToCheck.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.isAnnotationPresent(annotationToFind)) {
                return true;
            }
        }

        // наличие полей с аннотацией
        Field[] fields = classToCheck.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(annotationToFind)) {
                return true;
            }
        }


        // проверяем наличие аннотации в методах класса toCheck
        Method[] methods = classToCheck.getDeclaredMethods();
        for (Method md: methods) {
            if (md.isAnnotationPresent(annotationToFind)) {
                return true;
            }

            // наличие аннотации в переменных метода
            Parameter[] parameters = md.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(annotationToFind)) {
                    return true;
                }
            }

        }

        return false;
    }
}
