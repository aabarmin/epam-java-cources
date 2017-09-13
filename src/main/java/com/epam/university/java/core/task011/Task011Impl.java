package com.epam.university.java.core.task011;

import com.epam.university.java.core.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task011Impl implements Task011 {
    private Validator validator = Validator.getInstance();

    @Override
    public String getLastName(String[] collection) {
        validator.vaildate((Object) collection);
        return getLastNameImpl(Arrays.asList(collection));
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        validator.vaildate(collection);
        return getLastNameImpl(collection);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        validator.vaildate(collection);
        return getLastNameImpl(collection);
    }

    private String getLastNameImpl(List<String> list) {

        List<String> listForChages = new LinkedList<>(list);
        int i = 0;
        while (listForChages.size() != 1) {
            if (i < listForChages.size()) {
                listForChages.remove(i++);
            } else {
                i %= listForChages.size();
            }
        }

        return listForChages.get(0);
    }
}
