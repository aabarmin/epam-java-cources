package com.epam.university.java.core.task003;

/**
 * Created by ilya on 02.09.17.
 */
public class SimpleNullChecker implements NullChecker {
    @Override
    public void check(Object... objects) {
        if(objects==null){
            throw new IllegalArgumentException("objects doesn't have anything");
        }
        for (Object object :
                objects) {
            if (object == null) {
                throw new IllegalArgumentException("something is null");
            }
        }
    }
}
