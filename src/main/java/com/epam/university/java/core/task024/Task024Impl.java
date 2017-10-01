package com.epam.university.java.core.task024;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by Александр on 28.09.2017.
 */
public class Task024Impl implements Task024 {
    /**
     * Given a string with camel case word, you should separate this string
     * into collection of words.
     *
     * <p>
     *     Example: source string is saveChangesInTheEditor, result is
     *     [save, changes, in, the, editor]
     * </p>
     *
     * @param source source string
     * @return collection of words
     */
    @Override
    public Collection<String> getWordsCount(String source) {
        //String encodedSource = encode(source, "cp1251");

        String regex = "(?=\\p{Lu})";
        if (source.isEmpty()) {
            return Collections.emptyList();
        } else {
            return Arrays.asList(source.split(regex)).stream()
                    .map(s -> s.toLowerCase())
                    .collect(Collectors.toList());
        }

    }

    /**
     * Encode source string tocharset.
     * @param source to encode
     * @param charset of result string.
     * @return new string
     */
    String encode(String source, String charset) {
        Charset cset = Charset.forName(charset);
        ByteBuffer buf = cset.encode(source);
        byte[] b = buf.array();
        return new String(b);
    }

}
