package com.epam.university.java.core.task003;

/**
 * Created by A.Sluzhbin on 23.08.2020
 */

public class MappingOperationImpl implements MappingOperation {

    @Override
    public String map(String source) {
        StringBuilder mapBuilder = new StringBuilder(source);
        return mapBuilder.reverse().toString();
    }

}
