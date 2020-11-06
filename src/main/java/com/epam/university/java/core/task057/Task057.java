package com.epam.university.java.core.task057;

/**
 * Deliveryman with QuadCopter.
 * Imagine, You are delivery man with QuaCopter.
 * You work in company and deliver little posts,
 * but, people don't say number of window and number of floor.
 * You don't want to count of window every time. You are future programmer.
 * You decided create program that find params of need window.
 * <p>
 * Every floor are identical. Every flat identical.
 * Plan of floor with numbers of flat (exp. from number 1):
 * 6 : 5 : 4 : 3
 * 7 : 8 | 1 : 2
 * </p>
 * <p>
 * "|" - is entrance in floor.
 * </p>
 * <p>
 * Every flat has 2 windows.
 * If you enter in flat, left room is living room, right room is kitchen.
 * You deliver post to living room every.
 * </p>
 */
public interface Task057 {

    /**
     * Every house has levels, and entrances.
     * This method returns correct window for delivery.
     *
     * @param level        - How many levels are there in the house?
     * @param entrances    - How many entrances are there in the house?
     * @param numberOfFlat - number of flat from task of delivery.
     */
    public Window getWindowForDelivery(int level, int entrances, int numberOfFlat);

}
