package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        char[] instance = "SOS".toCharArray();
        int count = 0;
        while (sourceMessage.length() > 2) {
            String temp = sourceMessage.substring(0, 3);
            sourceMessage = sourceMessage.substring(3, sourceMessage.length());
            char[] comparing = temp.toCharArray();
            for (int i = 0; i < 3; i++){
                if(instance[i] != comparing[i]){
                    count++;
                }
            }
        }
        return count;
    }
}
