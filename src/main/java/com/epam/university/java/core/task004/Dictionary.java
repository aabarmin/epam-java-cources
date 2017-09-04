package com.epam.university.java.core.task004;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 04.09.17.
 */
public class Dictionary {
    private final static Map<String,Integer> DICTIONARY= new HashMap<>();
    static {
        DICTIONARY.put("", 0);
        DICTIONARY.put("One", 1);
        DICTIONARY.put("Two", 2);
        DICTIONARY.put("Three", 3);
        DICTIONARY.put("Four", 4);
    }

    public static Integer getInt(String string){
        return DICTIONARY.get(string);
    }

    public static String getString(Integer integer){
        String result = "";

        for (Map.Entry<String, Integer> entry :
                DICTIONARY.entrySet()) {
            if(entry.getValue().equals(integer)){
                result = entry.getKey();
            }
        }

        return result;
    }

}
