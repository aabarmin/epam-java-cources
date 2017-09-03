package com.epam.university.java.core.task003;

/**
 * Created by Dremina on 03.09.2017.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String[] values = source.split(",");
        for(int i = 0; i < values.length; i++){
            values[i] = values[i].trim();
        }
        return values;
    }


}
