package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {

    @Override
    public String[] flatMap(String source) {

        if( null == source )
            return null;

        return source.split(",");
    }
}
