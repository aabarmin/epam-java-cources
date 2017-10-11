package com.epam.university.java.core.task034;

public class PersonSingletonWrapper {
    private static PersonSingletonWrapper ourInstance = new PersonSingletonWrapper();
    private Person person;

    public static PersonSingletonWrapper getInstance() {
        return ourInstance;
    }

    private PersonSingletonWrapper() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
