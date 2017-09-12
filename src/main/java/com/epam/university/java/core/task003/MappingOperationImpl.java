package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if (source == null) {
            throw new IllegalArgumentException("String not provided!");
        }

        char[] ch = source.toCharArray();
        Character[] characters = new Character[ch.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = ch[i];
        }

        characters = Task003Impl.reverseArr(characters);

        for (int i = 0; i < ch.length; i++) {
            ch[i] = characters[i];
        }

        return new String(ch);
    }
}
