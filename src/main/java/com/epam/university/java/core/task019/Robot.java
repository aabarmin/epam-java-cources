package com.epam.university.java.core.task019;

/**
 * Robot instance.
 */
public interface Robot {
    /**
     * Get current robot position.
     * @return position
     */
    RobotPosition getPosition();

    /**
     * Set robot position.
     * @param position position
     */
    void setPosition(RobotPosition position);
}
