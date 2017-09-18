package com.epam.university.java.core.task005;

/**
 * Computations.
 * Task005 implementation.
 */
public final class Task005Impl implements Task005 {

    /**
     * * Message for negative or 0 input.
     */
    private static final String MSG_ILLEGAL_ARG = "illegal digits number";

    /**
     * int 10 - used to compute min and max
     * numbers in further evaluations.
     */
    private static final int TEN = 10;

    @Override
    public PiHolder findPi(final int digits) {
        if ((digits <= 0) || (digits > TEN)) {
            throw new IllegalArgumentException(MSG_ILLEGAL_ARG);
        }

        int minSecond = (int) Math.round(Math.pow(TEN, (double) digits - 1));
        int maxSecond = (int) Math.floor(Math.pow(TEN, digits) / Math.PI);

        //current Second
        int curSecond = minSecond;
        //current First Floored
        int curFstFloored = (int) Math.floor(curSecond * Math.PI);
        //current First Ceiled
        int curFstCeiled = (int) Math.ceil(curSecond * Math.PI);
        PiHolderImpl piHolder = new PiHolderImpl(curFstFloored, curSecond);

        double bestApproxPi = (double) curFstFloored / curSecond;
        double curDelta = Math.abs(bestApproxPi - Math.PI);
        double bestDelta = curDelta;

        curDelta = Math.abs(((double) curFstCeiled / curSecond) - Math.PI);
        if (curDelta < bestDelta) {
            bestApproxPi = (double) curFstCeiled / curSecond;
            bestDelta = Math.abs(bestApproxPi - Math.PI);
            piHolder.setFirst(curFstCeiled);
        }

        for (curSecond = minSecond + 1; curSecond <= maxSecond; curSecond++) {
            curFstFloored = (int) Math.floor(curSecond * Math.PI);
            curFstCeiled = (int) Math.ceil(curSecond * Math.PI);
            curDelta = Math.abs(((double) curFstFloored / curSecond) - Math.PI);
            if (curDelta < bestDelta) {
                bestDelta = curDelta;
                piHolder.setFirst(curFstFloored);
                piHolder.setSecond(curSecond);
            }

            curDelta = Math.abs(((double) curFstCeiled / curSecond) - Math.PI);
            if ((curDelta < bestDelta) && (curSecond != maxSecond)) {
                bestDelta = curDelta;
                piHolder.setFirst(curFstCeiled);
                piHolder.setSecond(curSecond);
            }
        }
        return piHolder;
    }
}
