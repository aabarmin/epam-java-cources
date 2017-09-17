package com.epam.university.java.project.core.cdi.io;

import java.io.File;

/**
 * Common interface for accessing any type of resources.
 */
public interface Resource {
    /**
     * Get resource file.
     * @return file instance
     */
    File getFile();
}
