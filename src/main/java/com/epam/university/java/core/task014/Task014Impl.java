package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Task014Impl implements Task014 {

    private boolean isVampire(int first, int second, int multiplication) {
        return first * second == multiplication;
    }


    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        int first = 0;
        int second = 0;
        int multiplication = 1000;

        VampireNumberFactory factory = new VampireNumberFactoryImpl();
        ArrayList<VampireNumber> result = new ArrayList<VampireNumber>();

        while (multiplication < 10_000) {
            multiplication++;
            String str = String.valueOf(multiplication);
            for (int i = 1; i < str.length(); i++) {
                StringBuilder firstStr = new StringBuilder();
                firstStr.append(str.charAt(0))
                        .append(str.charAt(i));
                first = Integer.parseInt(firstStr.toString());
                StringBuilder secondStr = new StringBuilder();
                for (int j = 1; j < str.length(); j++) {
                    if (i != j) {
                        secondStr.append(str.charAt(j));
                    }
                }
                second = Integer.parseInt(secondStr.toString());
                if (isVampire(first, second, multiplication)) {
                    VampireNumber v = factory.newInstance(multiplication, first, second);
                    if (!result.contains(v)) {
                        result.add(v);
                    }
                }
                first = Integer.parseInt(firstStr.reverse().toString());

                if (isVampire(first, second, multiplication)) {
                    VampireNumber v = factory.newInstance(multiplication, first, second);
                    if (!result.contains(v)) {
                        result.add(v);
                    }
                }

                second = Integer.parseInt(secondStr.reverse().toString());

                if (isVampire(first, second, multiplication)) {
                    VampireNumber v = factory.newInstance(multiplication, first, second);
                    if (!result.contains(v)) {
                        result.add(v);
                    }
                }

                first = Integer.parseInt(firstStr.reverse().toString());

                if (isVampire(first, second, multiplication)) {
                    VampireNumber v = factory.newInstance(multiplication, first, second);
                    if (!result.contains(v)) {
                        result.add(v);
                    }
                }
            }

        }


        return result;
    }
}
