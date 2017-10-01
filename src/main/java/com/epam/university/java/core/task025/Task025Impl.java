package com.epam.university.java.core.task025;

/**
 * Created by Daniil Smirnov on 28.09.2017.
 * All copy registered MF.
 */
public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {

        int count = 0;
        for (String s : sourceMessage.split("")) {
            if (!(s.equals("S") || s.equals("O"))) {
                count++;
            }
        }
        return count;

        // Way two
        /*HashSet<String> errors = Stream.of(sourceMessage.split(""))
                .collect(Collectors.toCollection(HashSet::new));
        errors.remove("S");
        errors.remove("O");
        return errors.size();*/
    }
}
