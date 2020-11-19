package com.epam.university.java.core.task071;

import java.time.LocalDate;
import java.util.List;

public interface Task071 {

    /**
     * <p>
     * Nice to meet you at Task071.
     * In this task you play a role of a very nice person.
     * Whose friend is extremely tired of routine job.
     * You are a very nice programmer and a really helpful friend.
     * That's why you decided to make a small present for your friend.
     * So now your problem to solve is how to implement a program
     * that will find periods between two dates in time units a user needs.
     *
     * Format of date is: YYYY-mm-dd
     * Tip: bank system is not the easiest thing to understand
     * so your friend gave some templates of dates and queries.
     * (Look right in the test examples)
     * 
     * </p>
     *
     * @param typeOfPeriod a string that says which
     *                     period of time a user needs
     *                     (e.g. "WEEK", "MONTH")
     * @param dates        two dates between which
     *                     you need to find period
     * @return a list of date introducing period type
     *          INCLUDING both dates of query
     */
    List<String> datesBetween(String typeOfPeriod, String dates);


    /**
     * Method that finds dates between in quarters
     * @param from starting date
     * @param to the last date of a period
     * @return a list of periods in quarters
     */
    List<String> periodBetweenQuarters(LocalDate from, LocalDate to);

    /**
     * Method that finds dates between in months
     * @param from starting date
     * @param to the last date of a period
     * @return a list of periods in months
     */
    List<String> periodBetweenMonths(LocalDate from, LocalDate to);

    /**
     * Method that finds dates between in years
     * @param from starting date
     * @param to the last date of a period
     * @return a list of periods in years
     */
    List<String> periodBetweenYears(LocalDate from, LocalDate to);

    /**
     * Method that finds dates between in weeks
     * @param from starting date
     * @param to the last date of a period
     * @return a list of periods in weeks
     */
    List<String> periodBetweenWeeks(LocalDate from, LocalDate to);
}
