package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    private double result = Math.PI;

    @Override
    public PiHolder findPi(int digits) {
        PiHolder piHolder = null;
        if (digits == 0 || digits > 5) {
            throw new IllegalArgumentException();
        } else {
            switch (digits) {
                case 1:
                    piHolder = findPiLoop((byte) 1, 0.15);
                    break;
                case 2:
                    piHolder = findPiLoop((byte) 2, 0.01);
                    break;
                case 3:
                    piHolder = findPiLoop((byte) 3, 0.001);
                    break;
                case 4:
                    piHolder = findPiLoop((byte) 4, 0.0001);
                    break;
                case 5:
                    piHolder = findPiLoop((byte) 5, 0.00013);
                    break;
            }
            return piHolder;
        }
    }

    private PiHolder findPiLoop(byte coefficient, double delta_max) {
        PiHolder piholder = null;
        for (double first = (Math.pow(10, coefficient - 1)); first < Math.pow(10, coefficient); first++) {
            double second = first/result;
            if (Math.round(second) >= (Math.pow(10, coefficient - 1))) {
                if (Math.abs(second - Math.round(second)) <= delta_max) {
                    piholder = new PiHolderImpl((int) first, (int) Math.round(second));
                    break;
                }
            }
        }
        return piholder;
    }
}
