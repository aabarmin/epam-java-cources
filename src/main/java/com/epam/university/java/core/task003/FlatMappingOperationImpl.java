package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mirabilis on 03.09.2017.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String[] result = source.replace(" ", "").split(",");
        return result;
    }
}
