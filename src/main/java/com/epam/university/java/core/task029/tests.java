package com.epam.university.java.core.task029;

import java.util.Arrays;
import java.util.Collection;

public class tests {
    public static void main(String[] args) {
        final Collection<String> source = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-++++++++",
                "+-----++++",
                "+-+++-++++",
                "+-+++-++++",
                "+++++-++++",
                "++------++",
                "+++++-++++",
                "+++++-++++"
        );

        final Collection<String> words = Arrays.asList(
                "LONDON",
                "DELHI",
                "ICELAND",
                "ANKARA"
        );

        Task029 t = new Task029Impl();
        t.fillCrossword(source, words);
    }
}
