package com.epam.university.java.core.task026;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implementation class for Task026.
 *
 * @author Sergei Titov
 */
public class Task026Impl implements Task026 {

    /**
     * {@inheritDoc}
     */
    @Override
    public String encrypt(String sourceString, int shift) {

        final String ret = sourceString.chars()
                .map(l -> ((l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z')) ? (l + shift) : l)
                .mapToObj(l -> {
                    if (l > 'z') {
                        return String.valueOf((char)('a' + l - 'z' - 1));
                    } else if (l > 'Z' && l < 'a')  {
                        return String.valueOf((char)('A' + l - 'Z' - 1));
                    }
                    return String.valueOf((char)l);
                })
                .reduce("", (a, b) -> a + b);

        return ret;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String decrypt(String encryptedString, int shift) {
        return null;
    }
}
