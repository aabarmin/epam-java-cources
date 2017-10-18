package com.epam.university.java.core.task024;

import static javafx.scene.input.KeyCode.Z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        Collection<String> result = new ArrayList<>();
        if (Character.UnicodeBlock.of(source.charAt(1)).equals(Character.UnicodeBlock.CYRILLIC)) {
            String[] words = source.split("(?<=[а-яё])(?=[А-ЯЁ])");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            result = Arrays.asList(words);
        }
        if (Character.UnicodeBlock.of(source.charAt(1)).
                equals(Character.UnicodeBlock.BASIC_LATIN)) {
            String[] words = source.split("(?<=[a-züäöß])(?=[A-ZÜÄÖ])");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            result = Arrays.asList(words);
        }
        return result;
    }
}
