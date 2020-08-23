package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits > 0 && digits < 11) {
            PiHolderImpl holder = new PiHolderImpl();
            double kStart;
            double kEnd;
            double iStart;
            double iEnd;
            switch (digits) {
                case 1:
                    kStart = 1;
                    iStart = 9;
                    kEnd = 10;
                    iEnd = 1;
                    holder = calc(kStart, iStart, kEnd, iEnd, holder);
                    break;
                case 2:
                    kStart = 10;
                    iStart = 99;
                    kEnd = 100;
                    iEnd = 10;
                    holder = calc(kStart, iStart, kEnd, iEnd, holder);
                    break;
                case 3:
                    kStart = 100;
                    iStart = 999;
                    kEnd = 1_000;
                    iEnd = 100;
                    holder = calc(kStart, iStart, kEnd, iEnd, holder);
                    break;
                case 4:
                    kStart = 1_000;
                    iStart = 9_999;
                    kEnd = 9_999;
                    iEnd = 1_000;
                    holder = calc(kStart, iStart, kEnd, iEnd, holder);
                    break;
                case 5:
                    kStart = 10_000;
                    iStart = 99_999;
                    kEnd = 100_000;
                    iEnd = 10_000;
                    holder = calcBig(kStart, iStart, kEnd, iEnd, holder);
                    break;
                default:
                    break;
            }
            return holder;
        } else {
            throw new IllegalArgumentException();
        }

    }

    /**
     * Function for searching numbers.
     *
     * @param kS - start border to calc second num
     * @param iS - start border to calc first num
     * @param kEnd - end border to calc second num
     * @param iEnd - end border to calc first num
     * @param pi - instance of class PiHolderImpl
     * @return - instance of class PiHolderImpl
     */
    public PiHolderImpl calc(double kS, double iS, double kEnd, double iEnd, PiHolderImpl pi) {
        double min = Integer.MAX_VALUE;
        double minBuf;
        while (kS != kEnd) {
            for (double i = iS; i >= iEnd; i--) {
                minBuf = Math.abs((i / kS) - Math.PI);
                if (minBuf < min) {
                    pi.setFirstNum((int) i);
                    pi.setSecondNum((int) kS);
                    min = minBuf;
                }
            }
            kS++;
        }
        return pi;
    }


    /**
     * Function for searching numbers.
     *
     * @param kS - start border to calc second num
     * @param iS - start border to calc first num
     * @param kEnd - end border to calc second num
     * @param iEnd - end border to calc first num
     * @param pi - instance of class PiHolderImpl
     * @return - instance of class PiHolderImpl
     */
    public PiHolderImpl calcBig(double kS, double iS, double kEnd, double iEnd, PiHolderImpl pi) {
        double min = Integer.MAX_VALUE;
        double minBuf;
        while (kS != kEnd) {
            for (double i = iS; i >= iEnd; i--) {
                if (i / 3 > kS && i / 4 < kS) {
                    minBuf = Math.abs((i / kS) - Math.PI);
                    if (minBuf < min) {
                        pi.setFirstNum((int) i);
                        pi.setSecondNum((int) kS);
                        min = minBuf;
                    }
                } else {
                    break;
                }
            }
            kS++;
        }
        return pi;
    }
}
