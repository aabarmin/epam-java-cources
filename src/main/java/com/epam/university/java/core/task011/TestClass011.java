package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestClass011 {

    public static boolean isLast(String[] input){
        int count = 0;
        for (String element: input) {
            if (element != null){
                count++;
            }
        }
        return count != 0;
    }
    public static String getLastName(String[] collection) {
        int index = 0;
        int length = collection.length;
        String name = collection[index];
        while(!isLast(collection)){
            if (index == length - 1){
                index = 1;
            }
            index = index + 2;
            if (collection[index] != null){
                name = collection[index];
                collection[index] = null;
            }

        }

        for (String element: collection) {
            if (element != null){
                name = element;
            }
        }
        return name;
    }


    public String getLastName(ArrayList<String> collection) {
        return null;
    }


    public String getLastName(LinkedList<String> collection) {
        return null;
    }
    public static void main(String[] args) {

        final String[] collection = {
            "Homer",
            "Bart",
            "Maggie",
            "Lisa",
            "Marge"
        };
        System.out.println(getLastName(collection));
    }
}
