package com.epam.university.java.core.task005;

public class Paralelit extends Thread {
    private final int firstNumber;
    private final int secondNumber;
    private double resFN;
    private double resSN;
    private double near;


    public Paralelit(int FN,int SN) {
        firstNumber = FN;
        secondNumber = SN;
    }

    @Override
    public void run() {
        super.run();
        resFN = 0;
        resSN = 0;


        double min = Double.MAX_VALUE;

        //TODO Созать нити на разделение с разбегом + 1 на каждую нить, подумать как сравнить и не на#бнулось что либо
        for (double i = firstNumber;i<=secondNumber;i++){
            for (double j = firstNumber;j<i;j++){
                near = Math.abs((i/j)-Math.PI);
                if (near<min){
                    min = near;
                    resFN = i;
                    resSN = j;
                }
            }
        }

    }

    public double getResFN() {
        return resFN;
    }

    public double getResSN() {
        return resSN;
    }

    public double getNear() {
        return near;
    }
}
