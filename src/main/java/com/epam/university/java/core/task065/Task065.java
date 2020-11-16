package com.epam.university.java.core.task065;

/**
 * Read html file.
 * You work for a small company.
 * Your accountant wants to calculate the distance by car
 * which was moved by an employee in one month.
 * There is a table on the site, gray lines and green lines in the table.
 * If the engineer comments on the change in the first distance value,
 * distance value will be unconfirmed (gray line).
 * After that the accountant will start counting manually from the very beginning.
 * The accountant spends a lot of time on this every month.
 * Your task: to parse the HTML file and create a Table of ways,
 * taking into account all comments. Make a method that counts the distance in one day.
 * If a line contains a comment,
 * only the distance from the comment needs to be considered.
 * <p>
 * tip: use JSoup for parsing HTML File.
 * </p>
 */
public interface Task065 {
    WayTable getWayTable(String filepath);
}
