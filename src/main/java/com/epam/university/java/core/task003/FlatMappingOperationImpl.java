package com.epam.university.java.core.task003;

/**
 * Created by Doomsday Device on 17.09.2017.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            return new String[0];
        }

        return source.replace(" ", "").split(",");
    }
}
