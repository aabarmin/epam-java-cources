package com.epam.university.java.core.task009;

import com.epam.university.java.core.validation.Validator;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Александр on 12.09.2017.
 */
public class Task009Impl implements Task009 {
    Validator VALIDATOR = Validator.newInstance(Task009Impl.class);
    /**
     * Source file contains words which separated with spaces.
     * <p>
     * You need to output all different words.
     * Same word in upper and lower case should be counted as equal.
     * </p>
     * <p>
     * Tip: you can use Set for it.
     * </p>
     *
     * @param sourceFile source file
     * @return collection of different words
     */
    @Override
    public Collection<String> countWords(File sourceFile) {
        VALIDATOR.assertNotNull(sourceFile);

        Arrays.stream(sourceFile.list()).forEach(System.out::println);

        //Files.lines(sourceFile.toPath()).flatMap
        return new ArrayList<String>();
    }
}
