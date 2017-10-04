package com.epam.university.java.core.task026;


import java.util.stream.Collectors;

/**
 * Implementation class for Task026.
 *
 * @author Sergei Titov
 */
public class Task026Impl implements Task026 {

    private static final int diapason = ('Z' - 'A') + 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public String encrypt(String sourceString, int shift) {

        return sourceString.chars()
                .mapToObj(old -> {

                    int now = old + shift;
                    if( old < 'A' || old > 'z' || (old > 'Z' && old < 'a')) {
                        now = old;
                    } else if (now > 'z' || (now > 'Z' && old <= 'Z')) {
                        now -= diapason;
                    } else if (now < 'A' || (now < 'a' && old >= 'a')) {
                        now += diapason;
                    }
                    return String.valueOf((char)now);
                })
                .collect(Collectors.joining());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String decrypt(String encryptedString, int shift) {

        return encrypt(encryptedString, -shift);
    }
}
