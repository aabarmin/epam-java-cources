package com.epam.university.java.core.task057;

/**
 * Window has 3 params. Level count from 1 level(floor).
 * Start count number of windows from left to right (from 1).
 * House has entrances to the house, this is FRONT_Side, other Side is BACK_SIDE.
 * (All houses have entrance only from FRONT_SIDE)
 * method {@link #getSide()} to return correct side when there is this window.
 */
public interface Window {
    int getLevelNumber();

    int getNumberOfWindow();

    SideType getSide();
}
