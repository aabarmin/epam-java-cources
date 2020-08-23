package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString.length() == 0) {
            return true;
        }

        if (!testPosition(sourceString)) {
            return false;
        }

        if (testAfterCut(sourceString, "{", "}")) {
            return false;
        }

        if (testAfterCut(sourceString, "(", ")")) {
            return false;
        }

        if (testAfterCut(sourceString, "[", "]")) {
            return false;
        }

        return true;
    }

    private boolean testAfterCut(String string, String firstBkt, String secondBkt) {
        if (string.contains(firstBkt) || string.contains(secondBkt)) {
            int indexFirst = string.indexOf(firstBkt);
            int indexSecond = string.indexOf(secondBkt);
            String subString = string.substring(indexFirst, indexSecond);
            return testPosition(subString);
        }
        return true;
    }

    private boolean testPosition(String string) {
        boolean test1 = testForOneType(string, "{", "}");
        boolean test2 = testForOneType(string, "(", ")");
        boolean test3 = testForOneType(string, "[", "]");
        return test1 && test2 && test3;
    }

    private boolean testForOneType(String string, String firstBkt, String secondBkt) {
        if (string.contains(firstBkt) || string.contains(secondBkt)) {
            int first = string.indexOf(firstBkt);
            int second = string.indexOf(secondBkt);
            if (first == -1 || second == -1) {
                return false;
            }
            return first < second;
        }
        return true;
    }
}
