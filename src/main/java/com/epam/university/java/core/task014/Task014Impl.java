package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Task014Impl implements Task014 {
    /**
     * A vampire number has an even number of digits and is formed by
     * multiplying a pair of numbers containing half the number of digits
     * of the result. The digits are taken from the original number
     * in any order. Pairs of trailing zeroes are not allowed.
     *
     * <p>
     * Example: 1260 = 21 * 60
     * </p>
     * <p>
     * {@see https://en.wikipedia.org/wiki/Vampire_number}
     * </p>
     *
     * @return collection of vampire numbers
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        HashSet<VampireNumber> vampireNumbers = new HashSet<>();
        int a1000 = 0;
        int a100 = 0;
        int a10 = 0;
        int a1 = 0;
        int zeros = 0;
        for (int i = 1000; i < 10000; i++) {
            zeros = 0;
            a1000 = i / 1000;
            a100 = (i / 100) % 10;
            a10 = (i % 100) / 10;
            a1 = i % 10;
            if (a100 == 0) {
                zeros++;
            }
            if (a10 == 0) {
                zeros++;
            }
            if (a1 == 0) {
                zeros++;
            }
            if (zeros > 1) {
                continue;
            }
            if (isVampire(i, a1000, a100, a10, a1)) {
                vampireNumbers.add(findVampire(i, a1000, a100, a10, a1));
            }
        }
        return vampireNumbers;
    }

    /**
     * Checks if number i is vampire.
     * @param i is number
     * @param a1000 thousands
     * @param a100 hundreds
     * @param a10 tens
     * @param a1 units
     * @return true if is vampire
     */
    public boolean isVampire(int i, int a1000, int a100, int a10, int a1) {
        boolean[] vars = new boolean[12];
        vars[0] = (a1000 * 10 + a100) * (a10 * 10 + a1) == i;
        vars[1] = (a1000 * 10 + a100) * (a10 + a1 * 10) == i;
        vars[2] = (a1000 + a100 * 10) * (a10 * 10 + a1) == i;
        vars[3] = (a1000 + a100 * 10) * (a10 + a1 * 10) == i;
        vars[4] = (a1000 * 10 + a10) * (a100 * 10 + a1) == i;
        vars[5] = (a1000 * 10 + a10) * (a100 + a1 * 10) == i;
        vars[6] = (a1000 + a10 * 10) * (a100 * 10 + a1) == i;
        vars[7] = (a1000 + a10 * 10) * (a100 + a1 * 10) == i;
        vars[8] = (a1000 * 10 + a1) * (a100 * 10 + a10) == i;
        vars[9] = (a1000 + a1 * 10) * (a100 * 10 + a10) == i;
        vars[10] = (a1000 * 10 + a1) * (a100 + a10 * 10) == i;
        vars[11] = (a1000 + a1 * 10) * (a100 + a10 * 10) == i;
        for (int j = 0; j < vars.length; j++) {
            if (vars[j] == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a combination of two-digit nums which mult gives source number.
     * @param i number
     * @param a1000 1000
     * @param a100 100
     * @param a10 10
     * @param a1 1
     * @return VampireNumber
     */
    public VampireNumberImpl findVampire(int i, int a1000, int a100, int a10, int a1) {
        boolean[] vars = new boolean[12];
        int[] firsts = new int[12];
        int[] seconds = new int[12];

        firsts[0] = (a1000 * 10 + a100);
        seconds[0] = (a10 * 10 + a1);
        vars[0] = firsts[0] * seconds[0] == i;

        firsts[1] = (a1000 * 10 + a100);
        seconds[1] = (a10 + a1 * 10);
        vars[1] = firsts[1] * seconds[1] == i;

        firsts[2] = (a1000 + a100 * 10);
        seconds[2] = (a10 * 10 + a1);
        vars[2] = (a1000 + a100 * 10) * (a10 * 10 + a1) == i;

        firsts[3] = (a1000 + a100 * 10);
        seconds[3] = (a10 + a1 * 10);
        vars[3] = (a1000 + a100 * 10) * (a10 + a1 * 10) == i;

        firsts[4] = (a1000 * 10 + a10);
        seconds[4] = (a100 * 10 + a1);
        vars[4] = (a1000 * 10 + a10) * (a100 * 10 + a1) == i;

        firsts[5] = (a1000 * 10 + a10);
        seconds[5] = (a100 + a1 * 10);
        vars[5] = (a1000 * 10 + a10) * (a100 + a1 * 10) == i;

        firsts[6] = (a1000 + a10 * 10);
        seconds[6] = (a100 * 10 + a1);
        vars[6] = (a1000 + a10 * 10) * (a100 * 10 + a1) == i;

        firsts[7] = (a1000 + a10 * 10);
        seconds[7] = (a100 + a1 * 10);
        vars[7] = (a1000 + a10 * 10) * (a100 + a1 * 10) == i;

        firsts[8] = (a1000 * 10 + a1);
        seconds[8] = (a100 * 10 + a10);
        vars[8] = (a1000 * 10 + a1) * (a100 * 10 + a10) == i;

        firsts[9] = (a1000 + a1 * 10);
        seconds[9] = (a100 * 10 + a10);
        vars[9] = (a1000 + a1 * 10) * (a100 * 10 + a10) == i;

        firsts[10] = (a1000 * 10 + a1);
        seconds[10] = (a100 + a10 * 10);
        vars[10] = (a1000 * 10 + a1) * (a100 + a10 * 10) == i;

        firsts[11] = (a1000 + a1 * 10);
        seconds[11] = (a100 + a10 * 10);
        vars[11] = (a1000 + a1 * 10) * (a100 + a10 * 10) == i;

        int j = 0;
        for (j = 0; j < vars.length; j++) {
            if (vars[j]) {
                break;
            }
        }
        return new VampireNumberImpl(firsts[j] * seconds[j], firsts[j], seconds[j]);
    }

}
