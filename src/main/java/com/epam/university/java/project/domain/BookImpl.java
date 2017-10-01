package com.epam.university.java.project.domain;

import java.util.Collection;

public class BookImpl implements Book {

    private int id;
    private String title;
    private Collection<String> authors;

    @Override
    public String toString() {
        return "BookImpl{" + "id="
                + id + ", title='" + title + '\''
                + ", authors=" + authors + '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Collection<String> getAuthors() {
        return authors;
    }

    @Override
    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }
}
