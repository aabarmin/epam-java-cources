package com.epam.university.java.core.task005;

public class ThreadTester {
    public static void main(String[] args) throws InterruptedException {
      //  Paralelit Thread1 = new Paralelit(10000, 50000);
        Paralelit Thread2 = new Paralelit(10000,99999);
        //Thread1.start();
        Thread2.start();

        Thread2.join();

//        if (Thread1.getNear() < Thread2.getNear()) {
          //  System.out.println("FIRST");
        //    System.out.println(Thread1.getResFN()+" "+Thread1.getResSN());
  //      } else {
            System.out.println("SECOND");
            System.out.println(Thread2.getResFN()+" "+Thread2.getResSN());
    //    }
    }
}
