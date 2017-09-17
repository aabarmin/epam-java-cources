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

        int currentSecond = minSecond;
        int currentFirstFloored = (int) Math.floor(currentSecond * Math.PI);
        int currentFirstCeiled = (int) Math.ceil(currentSecond * Math.PI);
        PiHolderImpl piHolder = new PiHolderImpl(currentFirstFloored, currentSecond);

        double bestApproximatePi = (double) currentFirstFloored / currentSecond;
        double currentDelta = Math.abs(bestApproximatePi - Math.PI);
        double bestDelta = currentDelta;

        currentDelta = Math.abs(((double) currentFirstCeiled / currentSecond) - Math.PI);
        if (currentDelta < bestDelta) {
            bestApproximatePi = (double) currentFirstCeiled / currentSecond;
            bestDelta = Math.abs(bestApproximatePi - Math.PI);
            piHolder.setFirst(currentFirstCeiled);
        }

        for (currentSecond = minSecond + 1; currentSecond <= maxSecond; currentSecond++) {
            currentFirstFloored = (int) Math.floor(currentSecond * Math.PI);
            currentFirstCeiled = (int) Math.ceil(currentSecond * Math.PI);
            currentDelta = Math.abs(((double) currentFirstFloored / currentSecond) - Math.PI);
            if (currentDelta < bestDelta) {
                bestDelta = currentDelta;
                piHolder.setFirst(currentFirstFloored);
                piHolder.setSecond(currentSecond);
            }

            currentDelta = Math.abs(((double) currentFirstCeiled / currentSecond) - Math.PI);
            if ((currentDelta < bestDelta) && (currentSecond != maxSecond)) {
                bestDelta = currentDelta;
                piHolder.setFirst(currentFirstCeiled);
                piHolder.setSecond(currentSecond);
            }
        }
        return piHolder;
    }
}
