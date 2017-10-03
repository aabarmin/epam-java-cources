package com.epam.university.java.core.task027;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Task027Impl implements Task027 {

    @Override
    public Collection<Integer> extract(String sourceString) {
        Collection<Integer> result = new LinkedHashSet<>();
        for (int n = 1; n <= sourceString.length() / 2; n++) {
            String currentFragment = sourceString.substring(0, n);
            if (currentFragment.startsWith("0")) {
                continue;
            }
            int currentPosition = n;
            while (currentPosition < sourceString.length()) {
                final int next = Integer.parseInt(currentFragment) + 1;
                final String nextFragment =
                        sourceString.substring(currentPosition,
                                currentPosition + String.valueOf(next).length());
                if (Integer.parseInt(nextFragment) != next) {
                    break;
                }
                result.add(next - 1);
                result.add(next);
                currentFragment = nextFragment;
                currentPosition += nextFragment.length();
                if (currentPosition == sourceString.length()) {
                    return result;
                }
            }
        }
        result.clear();
        return result;
    }
}