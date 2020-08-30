package com.epam.university.java.core.task003;


import java.util.*;

/**
 * Some docs.
 */
public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> temp = Arrays.asList(source);
            Collections.reverse(temp);
            return temp.toArray(source);
        }
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        } else {
            List<String> temp = new ArrayList<>(Arrays.asList(first));
            temp.addAll(Arrays.asList(second));
            String[] result = new String[temp.size()];
            return temp.toArray(result);
        }
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(source).max().getAsInt();
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        List<String> temp = new ArrayList<>();
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        } else {
            for (String s : source
            ) {
                if (condition.isValid(s)) {
                    temp.add(s);
                }
            }
        }

        return temp.toArray(new String[temp.size()]);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        String[] result;
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        } else {
            result = Arrays.stream(source).filter(s -> !checkIfContains(s, toRemote))
                    .toArray(String[]::new);
        }

        return result;
    }

    private boolean checkIfContains(String s, String[] toRemote) {
        return Arrays.asList(toRemote).contains(s);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        String[] result;
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        } else {
            result = Arrays.stream(source).map(operation::map)
                    .toArray(String[]::new);
        }
        return result;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        String[] result;
        List<String> temp;
        String[] res;
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        } else {
            List<String[]> list = new ArrayList<>();

            for (String s : source
            ) {
                list.add(operation.flatMap(s));
            }

            Set<Integer> list1 = new HashSet<>();

            for (String[] s : list
            ) {
                for (String j : s
                ) {
                    list1.add(Integer.parseInt(j));
                }
            }

            result = list1.stream()
                    .sorted()
                    .map(i -> String.valueOf(i))
                    .toArray(String[]::new);

            temp = Arrays.asList(result);
            Collections.reverse(temp);
            res = new String[temp.size()];
            temp.toArray(res);

        }
        return res;
    }
}
