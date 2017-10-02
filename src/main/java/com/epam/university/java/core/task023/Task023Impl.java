package com.epam.university.java.core.task023;

import com.epam.university.java.core.utils.common.FileChooser;
import com.epam.university.java.core.utils.common.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class implements Task023.
 */
public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        Logger logger = new Logger();
        logger.startStopwatch("extracting starred", false);
        String regex = "^(8|\\+7) ?\\(?(\\d{3})\\)? ?(\\d{3}-? ?\\d{2}-?"
                + " ?\\d{2})$";
        Matcher matcher = Pattern.compile(regex).matcher(phoneString);
        if (matcher.find()) {
            logger.stopStopwatch("extracting finished",false);
            return matcher.group(2);
        }
        throw new IllegalArgumentException(
                "Incorrect cell phone number format");
    }
}