package com.epam.university.java.core.task062;

import java.util.Collection;
import java.util.Objects;

public class PersonSerializableImpl implements PersonSerializable {

    private String fullName;
    private int age;
    private boolean male;
    private PersonSerializable spouse;
    private Collection<PersonSerializable> children;

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setMale(boolean male) {
        this.male = male;
    }

    @Override
    public void setSpouse(PersonSerializable spouse) {
        this.spouse = spouse;
    }

    @Override
    public void setChildren(Collection<PersonSerializable> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonSerializableImpl that = (PersonSerializableImpl) o;
        return age == that.age
                && male == that.male
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(spouse, that.spouse)
                && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, male, spouse, children);
    }
}
