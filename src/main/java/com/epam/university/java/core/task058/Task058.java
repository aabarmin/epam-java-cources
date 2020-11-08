package com.epam.university.java.core.task058;

/**
 * Read html file.
 * It's task from real life. You work in one little company.
 * Your accountant want to count distance by car
 * that was moved by Employee for Month.
 * Site has table, table has grey line, and green line.
 * If engineer make some commentary for change first distance value,
 * value of distance will become unconfirmed (grey line).
 * After that, accountant will start count manually from the beginning.
 * Accountant spend a lot of time every month for this.
 * Your task is: Parsing HTML file and create Table of Ways,
 * that count all comments. Make method that count distance in one day.
 * If line has comment, you need to count only distance from comment.
 */
public interface Task058 {
    WayTable getWayTable(String filepath);
}
