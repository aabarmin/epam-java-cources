package com.epam.university.java.core;

public class Validator {
    public void vaildate(Object... objects) {
        if (objects == null) {
            throw new IllegalArgumentException();
        }
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
    }

//    public void vaildate(Object[]... objects) {
//        if (objects == null) {
//            throw new IllegalArgumentException();
//        }
//        for (Object obj : objects) {
//            if (obj == null) {
//                throw new IllegalArgumentException();
//            }
//        }
//    }

}
