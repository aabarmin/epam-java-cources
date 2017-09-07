package com.epam.university.java.core.task003;

import java.util.Arrays;

public class FlatMappingOperationImpl implements  FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] result = source.split("[,]");
        for (int i = 0; i < result.length; i++) {
            result[i]=result[i].trim();
        }
        sortDesc(result);
        result= deleteDuplicates(result);
        return result;
    }
    private String[] deleteDuplicates (String[] source) {
        int duplicatesCount = 0;
        for (int i = 1; i < source.length; i++) {
            if (source[i-1].equals(source[i])){
                duplicatesCount++;
            }
        }
        String[] destination = new String[source.length-duplicatesCount];
        int destIndex=0;
        for (int i = 0; i <source.length; i++) {
            if(i == 0) {
                destination[destIndex++]=source[i];
            }
            else if (source[i-1].equals(source[i])){
                continue;
            }
            else {
                destination[destIndex++]=source[i];
            }
        }
        return destination;

    }
     private void sortDesc(String[] source){
        String temp;
        for(int i=0; i < source.length; i++){
            for(int j=1; j < (source.length-i); j++){
                if(!isGreater(source[j-1],source[j])){
                    temp = source[j-1];
                    source[j-1] = source[j];
                    source[j] = temp;
                }

            }
        }
    }

    /**
     * Compares two strings and return greater one. OrderBy(length,alphabet)
     * @param s1  first string
     * @param s2 second string
     * @return is s1 greater than s2 or not
     */
    private boolean isGreater(String s1, String s2){
         if (s1.length() > s2.length()){
             return true;
         }
         if (s2.length()>s1.length()) {
             return false;
         }
        return s1.compareTo(s2) > 0;

    }

}
