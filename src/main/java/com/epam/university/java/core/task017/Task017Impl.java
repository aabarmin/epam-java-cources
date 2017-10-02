package com.epam.university.java.core.task017;

import com.epam.university.java.core.utils.common.Validator;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Class formats input args data.
 */
public class Task017Impl implements Task017 {
    @Override
    public String formatDates(Object... args) {
        Validator.validateNotNull(args, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        return new SimpleDateFormat("yyyy.dd.MM").format(args[0]);
    }

    @Override
    public String formatNumbers(Object... args) {
        Validator.validateNotNull(args, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        return String.format(Locale.US, "%.1f, %<.2f, %<+.2f, %<.1a",
                args[0]);
    }

    @Override
    public String formatString(Object... args) {
        Validator.validateNotNull(args, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        return String.format("You know %s, %s!", args[0], args[1]);
    }
}