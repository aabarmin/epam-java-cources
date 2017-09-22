package com.epam.university.java.project.domain;

import java.util.Collection;

public class BookImpl implements Book {

    private int Id;
    private String title;
    private Collection<String> authors;

    public BookImpl(int id, String title, Collection<String> authors) {
        Id = id;
        this.title = title;
        this.authors = authors;
    }

    @Override
    public int getId() {
        return Id;
    }

    @Override
    public void setId(int id) {
        Id = id;
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
