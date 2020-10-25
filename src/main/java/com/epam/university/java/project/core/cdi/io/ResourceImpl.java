package com.epam.university.java.project.core.cdi.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceImpl implements Resource {
    private String path;

    public ResourceImpl (String path) {
        this.path = path;
    }

    @Override
    public File getFile() {
        try {
            URL u = getClass().getResource(path);
            if (u != null) {
                URI fileUri = u.toURI();
                File file = new File(fileUri);
                return file;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
