package com.epam.university.java.core.task004;

import com.epam.university.java.core.validations.CheckArgument;

import java.util.*;

/**
 * Created by Dremina on 10.09.2017.
 */
public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        CheckArgument.validateNullValue(first);
        CheckArgument.validateNullValue(second);
        ArrayList<String> result = new ArrayList<String>();
//        intersection operation
        for (int i = 0; i < first.length; i ++){
            for(int j = 0; j < second.length;j++){
                if (first[i].equals(second[j])){
                    result.add(first[i]);
                }
            }
        }
        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        CheckArgument.validateNullValue(first);
        CheckArgument.validateNullValue(second);

        ArrayList<String> result = new ArrayList<String>();


        for (int i = 0; i < first.length; i ++) {
            result.add(first[i]);
        }
//
        for(int j = 0; j < second.length; j++){
            if(result.indexOf(second[j]) == -1){
                result.add(second[j]);
            }
        }
        String[] finalRes = result.toArray(new String[result.size()]);
        return finalRes;
    }
}
