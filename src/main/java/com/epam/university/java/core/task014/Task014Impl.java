package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * author Dmitry Novikov 05-Sep-20.
 */
public class Task014Impl implements Task014 {

    static final int START = 10;
    static final int END = 99;

    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<VampireNumber> myList = new ArrayList<>();

        for (int fangA = START; fangA < END; fangA++) {

            String sFangA = String.valueOf(fangA);
            boolean trailingZeros = sFangA.endsWith("0");
            int max = (int) Math.min(END, Math.pow(10, sFangA.length()));

            for (long fangB = fangA; fangB < max; fangB++) {

                long candidate = fangA * fangB;
                if (candidate % 9 == (fangA + fangB) % 9) {

                    String sCandidate = String.valueOf(candidate);
                    String sFangB = String.valueOf(fangB);

                    if ((trailingZeros && sFangB.endsWith("0")) == false) {

                        char[] cVampire = sCandidate.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (sFangA + sFangB).toCharArray();
                        Arrays.sort(cFangs);

                        if (Arrays.equals(cVampire, cFangs)) {
                            myList.add(new VampireNumberImpl(Integer.valueOf(sCandidate),
                                    Integer.valueOf(sFangA), Integer.valueOf(sFangB)));
                        }
                    }
                }
            }
        }
        return myList;
    }
}
