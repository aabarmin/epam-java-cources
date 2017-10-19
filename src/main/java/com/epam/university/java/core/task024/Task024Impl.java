package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Вера on 01.10.2017.
 */
public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source.length() == 0) {
            Collection<String> result = new ArrayList<>();
            return result;
        } else {

            String sourceLowerCase = source.toLowerCase();

            char[] sourceChar = source.toCharArray();
            char[] sourceCharLowerCase = sourceLowerCase.toCharArray();

            Collection<String> result = new ArrayList<>();
            String s = "" + sourceCharLowerCase[0];

            for (int i = 1; i < sourceChar.length; i++) {
                if (sourceChar[i] == sourceCharLowerCase[i]) {
                    s += sourceChar[i];
                }
                if (sourceChar[i] != sourceCharLowerCase[i]) {
                    result.add(s);
                    s = "";
                    s += sourceCharLowerCase[i];
                }
            }
            result.add(s);

            //System.out.println(result);

            return result;
        }
    }
}
