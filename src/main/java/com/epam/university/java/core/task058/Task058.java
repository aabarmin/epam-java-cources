package com.epam.university.java.core.task058;

/**
 * Read html file.
 * It's task from real life. You work in one little company.
 * Your accountant wants to count distance by car
 * that was moved by Employee for Month.
 * Site has table, table has grey line, and green line.
 * If engineer make some commentary for change first distance value,
 * value of distance will become unconfirmed (grey line).
 * After that, accountant will start count manually from the beginning.
 * Accountant spends a lot of time every month for this.
 * Your task is: Parsing HTML file and create Table of Ways,
 * that count all comments. Make method that count distance in one day.
 * If line has comment, you need to count only distance from comment.
 * <p>
 * advice:
 * 1. Open file resource/Task058/wayTable.html this exp. GoogleChrome.
 * 2. Find green lines - confirmed route.
 * 3. Find grey lines - unconfirmed route.
 * 4. Find information about JSoup for parsing HTML File.
 * 5. Parsing this site. Get correct distance value from every line.
 * 6. Count full distance of Month.
 * 7. Create method that count all value of distance in one day.
 * </p>
 */
public interface Task058 {
    WayTable getWayTable(String filepath);
}
