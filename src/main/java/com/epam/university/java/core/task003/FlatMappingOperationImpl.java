package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String[] resArr;
        resArr = source.split("\\s*[,]\\s+");
        ArrayList<Integer> listArr = new ArrayList<>();
        for (String str : resArr) {
            listArr.add(Integer.parseInt(str.trim()));
        }
        Collections.sort(listArr);
        List<Integer> newIntList = listArr.stream()
                .distinct()
                .collect(Collectors.toList());
        Collections.reverse(newIntList);
        String[] finalArr = new String[newIntList.size()];
        for (int i = 0; i < finalArr.length; i++) {
            finalArr[i] = String.valueOf(newIntList.get(i));
        }
        return finalArr;
    }

}
