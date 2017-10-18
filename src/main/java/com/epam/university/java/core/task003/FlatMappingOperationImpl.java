package com.epam.university.java.core.task003;


import java.util.Arrays;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {

        return source.split("\\s*,\\s*");
    }
    public static void main(String[] args) {
        FlatMappingOperationImpl flatMappingOperation = new FlatMappingOperationImpl();
        String[] strings = flatMappingOperation.flatMap("1,  2, ");
        System.out.println(Arrays.toString(strings));
        for (String s:strings) {
            System.out.println(s);
        }
    }
}
