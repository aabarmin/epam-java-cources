package com.epam.university.java.core.task005;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dremina on 10.09.2017.
 */
public class PiHolderImpl implements PiHolder {
    private int firstValue;
    private int secondValue;
    public static final double PI = 3.14;

    public PiHolderImpl(int digits){
        findNumbers(digits);
    }

    Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>() {{
        put(1, new Integer[]{1,9});
        put(2, new Integer[]{10,99});
        put(3, new Integer[]{100,999});
        put(4, new Integer[]{1000,9999});
        put(5, new Integer[]{10000,99999});
        put(6, new Integer[]{100000,999999});
        put(7, new Integer[]{1000000,9999999});
        put(8, new Integer[]{10000000,99999999});
        put(9, new Integer[]{100000000,999999999});
        put(10,new Integer[]{1000000000,2147483647});
    }};

    @Override
    public int getFirst() {
        return this.firstValue;
    }

    @Override
    public int getSecond() {
        return this.secondValue;
    }

    public void findNumbers(int value){
        Integer[] range = map.get(value);
        double min = 1;
        double diff = 0;
        int bufFirstValue = 1;
        int bufSecondValue = 1;
        int border = range[1];

        /*double lDif, iDbl;
        for(int i = range[0]; i < border; i++) {
            iDbl = (double) i;
            for( int j = range[0]; j < border; i++ ) {
                lDif = Math.abs((iDbl / j) - Math.PI);
                if (lDif < min) {
                    min = lDif;
                    bufFirstValue = i;
                    bufSecondValue = j;
                }
            }
        }*/
        for (int i = range[0]; i < border; i++){

            double firstNumber = i * Math.PI;
            double size = (double) (int) (firstNumber);
            if (size <= range[1]){
                diff = Math.abs((size / i) - Math.PI);
                if (min > diff){
                    min = diff;
                    bufSecondValue = i;
                    bufFirstValue = (int) size;
                }
            }
        }
        firstValue = bufFirstValue;
        secondValue = bufSecondValue;
    }
}
