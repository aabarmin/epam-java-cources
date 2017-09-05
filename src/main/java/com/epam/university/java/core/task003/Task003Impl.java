package com.epam.university.java.core.task003;

import com.epam.university.java.core.task001.Task001Impl;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if(source == null)
            throw new IllegalArgumentException();

        String [] result = new String[source.length];
        for (int i = source.length - 1, j = 0; i >= 0; i--,j++) {
            result[j] = source[i];
        }
        return result;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        Task001Impl.nullChecker(first,second);
        String [] result = new String[first.length + second.length];
        int count = 0;
        while(count < result.length){
            for (int i = 0; i < first.length; i++) {
                result[count] = first[i];
                count++;
            }
            for (int i = 0; i < second.length; i++) {
                result[count] = second[i];
                count++;
            }
        }
        return result;
    }

    @Override
    public int findMax(int[] source) {
        if(source == null)
            throw new IllegalArgumentException();
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            if(max < source[i])
                max = source[i];
        }

        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        Task001Impl.nullChecker(source, condition);

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            if(condition.isValid(source[i]))
                resultList.add(source[i]);
        }
        return resultList.toArray(new String[resultList.size()]);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        Task001Impl.nullChecker(source, toRemote);
        List<String> listResult = new ArrayList<>();
        boolean isDuplicate = false;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < toRemote.length; j++) {
                if(source[i].equals(toRemote[j]))
                    isDuplicate = true;
            }
            if(!isDuplicate){
                listResult.add(source[i]);
            }
            else
                isDuplicate = false;
        }
        return listResult.toArray(new String[listResult.size()]);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        Task001Impl.nullChecker(source, operation);
        String[] result = new String[source.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = operation.map(source[i]);
        }
        return result;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        Task001Impl.nullChecker(source, operation);
        Set<String> stringSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               int result = o1.length() - o2.length();
                return result == 0 ? o1.compareTo(o2) : result;
            }
        });
        for(String s : source){
            String[] temp = operation.flatMap(s);
            stringSet.addAll(Arrays.asList(temp));
        }
        String[] result = stringSet.toArray(new String[stringSet.size()]);

        return invert(result);
    }

}
