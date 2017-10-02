package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {

    @Override
    public String map(String source) {
        if (source==null){
            throw new IllegalArgumentException();
        }
        String res = "";
        char[] c = source.toCharArray();
        for (int i = 0; i < c.length; i++) {
            res += c[c.length-1-i];
        }
        return res;
    }
}

