package com.epam.university.java.core.task004;
import java.util.*;
import java.util.stream.Collectors;
public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first==null||second==null) throw new IllegalArgumentException();
        List<String> pullOfElements = new ArrayList<>(Arrays.asList(first));
        Set<String> condition = new HashSet<>(Arrays.asList(second));
        List<String> outString = pullOfElements.stream().distinct().filter(condition::contains).
                collect(Collectors.toList());
        String[] result = new String[outString.size()];
        result = outString.toArray(result);
        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first==null||second==null) throw new IllegalArgumentException();
        List<String> buffer = new ArrayList<>();
        buffer.addAll(Arrays.asList(first));
        buffer.addAll(Arrays.asList(second));
        buffer = buffer.stream().distinct().collect(Collectors.toList());
        String[] result = new String[buffer.size()];
        result = buffer.toArray(result);
        return result;
    }
}
