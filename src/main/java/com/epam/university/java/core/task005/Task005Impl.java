package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {



    @Override
    public PiHolder findPi(int digits) {
        if (digits<=0)
            throw new IllegalArgumentException();

        int first = (int)Math.pow(10,digits-1);
        int second = (int)(Math.pow(10,digits)-1);
        int half = (first+second)/2;

        Paralelit Thread1 = new Paralelit(first,half);
        Paralelit Thread2 = new Paralelit(half,second);

        Thread1.start();
        Thread2.start();

        try {
            Thread2.join();

                if (Thread1.getNear() < Thread2.getNear()) {
                    PiHolder PH = new PiHolderImpl((int) Thread1.getResFN(), (int) Thread1.getResSN());
                    return PH;
                } else {
                    PiHolder PH = new PiHolderImpl((int) Thread2.getResFN(), (int) Thread2.getResSN());
                    return PH;
                }

        } catch (InterruptedException e){
            System.out.println("BAD");
        }


        /*while (true){
            if (!(Thread1.isAlive()&&Thread2.isAlive())){
                if (Thread1.getNear()<Thread2.getNear()){
                    PiHolder PH = new PiHolderImpl((int)Thread1.getResFN(),(int)Thread1.getResSN());
                    return PH;
                }else {
                    PiHolder PH = new PiHolderImpl((int)Thread2.getResFN(),(int)Thread2.getResSN());
                    return PH;
                }
            }
        }*/


        //PiHolder PH = new PiHolderImpl((int)resFN,(int)resSN);

       // return PH;
        return null;

    }
}
