package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {

        String[] preOutput = source.split("[ ]*,[ ]*");

        return DeletionOfDuplicates.deleteDuplicates(preOutput);
    }
}

class DeletionOfDuplicates {
    static String[] deleteDuplicates (String[] source) {
        boolean[] isDuplicate = new boolean[source.length];
        int sizeOfOutput = source.length;
        for (int i = 0; i < source.length; i++) {
            isDuplicate[i] = false;
            for (int j = 0; j < i; j++) {
                if (source[j].equals(source[i])) {
                    isDuplicate[i] = true;
                    sizeOfOutput--;
                    break;
                }
            }
        }
        String[] dest = new String[sizeOfOutput];
        int i = 0;
        int j = 0;
        while (i < source.length && j < sizeOfOutput) {
            if (!isDuplicate[i]) {
                dest[j++] = source[i];
            }
            i++;
        }
        return dest;
    }
}