package com.epam.university.java.core.task003;

/**
 * Created by Вера on 06.09.2017.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null)
            return new String[]{""};

        String[] strSpace = source.split(" ");
        int i = 0;
        String sourceWithoutSpace = "";
        while (i < strSpace.length) {
            if (strSpace[i] != " ")
                sourceWithoutSpace+=strSpace[i];
            i++;
        }

        String[] strComma = sourceWithoutSpace.split(",");

        return strComma;
    }
}
