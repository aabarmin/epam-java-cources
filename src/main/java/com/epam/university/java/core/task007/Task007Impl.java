package com.epam.university.java.core.task007;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ilya on 06.09.17.
 */
public class Task007Impl implements Task007 {
    NullChecker checker = new SimpleNullChecker();

    int j;
    int index;

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        checker.check(first,second);

        Collection<HashMap<Integer,Integer>> result = first.stream()
                .map(n->   {   j++;
                                    index = j;
                                    return second.stream()
                                            .map(e -> e * n)
                                    .collect(HashMap<Integer,Integer>::new,(m,v)->m.put(getIndex(),v), HashMap::putAll);
                                }).collect(Collectors.toList());
        Map<Integer,Integer> resMap = new HashMap<>();

        for (Map<Integer, Integer> map :
                result) {
            for (Map.Entry<Integer, Integer> entry :
                    map.entrySet()) {
                resMap.merge(entry.getKey(),entry.getValue(),(v1, v2)-> v1 + v2);
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry :
                resMap.entrySet()) {
                resList.add(entry.getValue());
        }


        resList.add(0);

        System.out.println(resList);


        return resList;
    }

    private int getIndex(){
        return index++;
    }


}
