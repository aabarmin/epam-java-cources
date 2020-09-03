package com.epam.university.java.core.task019;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.epam.university.java.core.task019.RobotCommand.MOVE_FORWARD;
import static com.epam.university.java.core.task019.RobotCommand.TURN_RIGHT;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task019Test {
    private Task019 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task019.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullRobot() throws Exception {
        instance.isOnStartPosition(null);
    }

    @Test
    public void robotOnTheSamePosition() throws Exception {
        final Robot robot = TestHelper.getInstance(Robot.class);
        assertTrue("Incorrect result", instance.isOnStartPosition(robot));
    }


    @Test
    public void robotMovesSquared() throws Exception {
        final Robot robot = TestHelper.getInstance(Robot.class);
        Stream.of(
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD
        )
                .forEach(a -> instance.invokeAction(robot, a));
        assertTrue("Incorrect result", instance.isOnStartPosition(robot));
    }

    @Test
    public void robotMoveIncorrect() throws Exception {
        final Robot robot = TestHelper.getInstance(Robot.class);
        Stream.of(
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD,
                TURN_RIGHT,
                MOVE_FORWARD,
                MOVE_FORWARD,
                MOVE_FORWARD
        )
                .forEach(a -> instance.invokeAction(robot, a));
        assertFalse("Incorrect result", instance.isOnStartPosition(robot));
    }

    @Test
    public void robotMovesOnAxis() throws Exception {
        final Robot robot = TestHelper.getInstance(Robot.class);
        Stream.of(
                MOVE_FORWARD,
                TURN_RIGHT,
                TURN_RIGHT,
                MOVE_FORWARD
        )
              .forEach(a -> instance.invokeAction(robot, a));
        assertTrue("Incorrect result", instance.isOnStartPosition(robot));
    }
}