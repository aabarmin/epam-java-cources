package com.epam.university.java.core.task003;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {

        String[] cut = source.split (",");

        List <String> result = Arrays
                .stream ( cut )
                .map ( String::trim )
                .map ( Integer::parseInt )
                .sorted ()
                .distinct ()
                .map (String::valueOf)
                .collect (Collectors.toList());

        return result.toArray ( new String [ result.size () ] );
    }
}
