package com.epam.university.java.core.task057;

public class WindowImpl implements Window {

    private int levelNumber;
    private int numberOfWindow;
    private SideType side;

    /**
     * Window constructor.
     * @param levelNumber window level number
     * @param numberOfWindow number of window
     * @param side side of the building
     */
    public WindowImpl(int levelNumber, int numberOfWindow, SideType side) {
        this.levelNumber = levelNumber;
        this.numberOfWindow = numberOfWindow;
        this.side = side;
    }

    @Override
    public int getLevelNumber() {
        return levelNumber;
    }

    @Override
    public int getNumberOfWindow() {
        return numberOfWindow;
    }

    @Override
    public SideType getSide() {
        return side;
    }
}
