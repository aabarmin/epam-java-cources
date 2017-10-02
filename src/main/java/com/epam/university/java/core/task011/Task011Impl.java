package com.epam.university.java.core.task011;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(ArrayList<String> collection) {
        Validator.validateNotNull(collection,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEmpty(collection,
                Validator.MESSAGE_IF_COLLECTION_EMPTY);
        int i = 0;
        while (collection.size() != 1) {
            if (collection.size() > i + 1) {
                collection.remove(i);
                i++;
            } else {
                if (collection.size() == i) {
                    i = 0;
                    collection.remove(i);
                    i++;
                } else {
                    i = 1;
                    collection.remove(i);
                }
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(String[] collection) {
        return getLastName(new ArrayList<>(new ArrayList<>(
                Arrays.asList(collection))));
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return getLastName(new ArrayList<>(collection));
    }
}