package com.epam.university.java.core.task059;

import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.List;

/**
 * Abstract class for Visitor realization.
 */
public abstract class DefaultFileVisitor extends SimpleFileVisitor<Path> {

    /**
     * Get Result of searching.
     * @return list of Strings.
     */
    public abstract List<String> getResult();
}
