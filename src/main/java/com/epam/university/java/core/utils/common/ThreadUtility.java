package com.epam.university.java.core.utils.common;

/**
 * Class that implements additional functionality.
 */
public class ThreadUtility {

    /**
     * Put to sleep the current thread.
     *
     * @param timeToSleep time to sleep in millis
     * @throws IllegalArgumentException if time is negative or Interrupted
     *                                  exception if the thread is
     *                                  interrupted, either before or during
     *                                  the activity
     */
    public static void sleep(int timeToSleep) {
        Validator.validateNotNegative(timeToSleep,
                Validator.MESSAGE_IF_NEGATIVE);
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
