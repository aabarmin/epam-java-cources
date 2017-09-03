package com.epam.university.java.core.task003;

import com.epam.university.java.core.validations.CheckArgument;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dremina on 03.09.2017.
 */
public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        CheckArgument.validateNullValue(source);
        List<String> list = Arrays.asList(source);
        Collections.reverse(list);

        return (String[]) list.toArray();
    }

    @Override
    public String[] join(String[] first, String[] second) {
        CheckArgument.validateNullValue(first);
        CheckArgument.validateNullValue(second);

        // Apache Commons Lang library
        return (String [])ArrayUtils.addAll(first,second);
    }

    @Override
    public int findMax(int[] source) {
        CheckArgument.validateNullValue(source);

        int max = source[0];

        for (int i = 0; i < source.length; i ++){
            if( source[i] > max){
                max = source[i];
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        CheckArgument.validateNullValue(source);
        CheckArgument.validateNullValue(condition);

        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < source.length; i ++){
           if (condition.isValid(source[i])){
               result.add(source[i]);
           }
        }
        String[] res = new String[result.size()];
        result.toArray(res);
        return res;
    }



    @Override
    public String[] map(String[] source, MappingOperation operation) {
        CheckArgument.validateNullValue(source);
        CheckArgument.validateNullValue(operation);
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < source.length; i++){
            result.add(operation.map(source[i]));
        }
        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        CheckArgument.validateNullValue(source);
        CheckArgument.validateNullValue(operation);
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] valueList;
        Integer number;

        for (int i = 0; i < source.length; i++){
            valueList = operation.flatMap(source[i]);

            for (int j = 0; j < valueList.length; j++){
                number = Integer.parseInt(valueList[j]);
                if(result.indexOf(number) == -1){
                    result.add(number);
                }
            }
        }
        Collections.sort(result, Collections.reverseOrder());

        valueList = new String[result.size()];
        for(int k = 0; k < result.size(); k++){
            valueList[k] = Integer.toString(result.get(k));
        }

        return valueList;
    }

    @Override
    public String[] removeElements(String[] initial,String[] toRemove ){
        CheckArgument.validateNullValue(initial);
        CheckArgument.validateNullValue(toRemove);
        List removeAsList = Arrays.asList(toRemove);
        ArrayList<String> result = new ArrayList<String >();

        for( int i = 0; i < initial.length; i++){
            if (removeAsList.indexOf(initial[i]) == -1) {
                result.add(initial[i]);
            }
        }
        String[] res = new String[result.size()];
        result.toArray(res);

        return res;
    }
}
