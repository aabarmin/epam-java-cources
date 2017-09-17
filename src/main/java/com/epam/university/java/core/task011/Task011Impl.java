package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Dremina on 17.09.2017.
 */
public class Task011Impl implements Task011{
    @Override
    public String getLastName(String[] collection) {

        String lastName;
        ArrayList<String> result = new ArrayList<String>();
        int k = 0;

        for (int i = 0; i < collection.length; i++){
            result.add(collection[i]);
        }
        returnLastValue(result);
        lastName = result.get(0);

        return lastName;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        String lastName;
        ArrayList<String> result = new ArrayList<String>();
        int k = 0;

        for (int i = 0; i < collection.size(); i++){
            result.add(collection.get(i));
        }
        returnLastValue(result);
        lastName = result.get(0);

        return lastName;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        String lastName;
        ArrayList<String> result = new ArrayList<String>();
        int k = 0;

        for (int i = 0; i < collection.size(); i++){
            result.add(collection.get(i));
        }
        returnLastValue(result);

        lastName = result.get(0);

        return lastName;
    }

    public static ArrayList<String> returnLastValue(ArrayList<String> source){
        int k = 0;
        while (source.size() != 1){
            if (k >= source.size()){
                k = k - source.size();
            }
            source.remove(k);
            k ++;
        }
        return source;
    }
}