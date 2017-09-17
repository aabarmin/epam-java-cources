package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {

        String[] preOutput = source.split("[ ]*,[ ]*");

        return DeletionOfDuplicates.deleteDuplicates(preOutput);
    }
}
