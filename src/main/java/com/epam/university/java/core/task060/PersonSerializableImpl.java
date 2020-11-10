package com.epam.university.java.core.task060;
/*
 * Created by Laptev Egor 10.11.2020
 * */

import java.util.Collection;
import java.util.Objects;

public class PersonSerializableImpl implements PersonSerializable {
    private String fullName;
    private int age;
    private boolean isMale;
    private PersonSerializable spouse;
    private Collection<PersonSerializable> children;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public PersonSerializable getSpouse() {
        return spouse;
    }

    public void setSpouse(PersonSerializable spouse) {
        this.spouse = spouse;
    }

    public Collection<PersonSerializable> getChildren() {
        return children;
    }

    public void setChildren(Collection<PersonSerializable> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result + Objects.hashCode(fullName);
        result = result + age;
        result = result + Objects.hashCode(isMale);
        result = result + Objects.hashCode(spouse);
        result = result + Objects.hashCode(children);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        PersonSerializableImpl person = (PersonSerializableImpl) obj;
        if (person.fullName != null ? !person.fullName.equals(this.fullName) : this.fullName != null) {
            return false;
        }
        if (person.age != this.age) {
            return false;
        }
        if (person.isMale != this.isMale) {
            return false;
        }
        if (person.spouse != null ? !person.spouse.equals(this.spouse) : this.spouse != null) {
            return false;
        }
        if (person.children != null ? !person.children.containsAll(this.children) : this.children != null) {
            return false;
        }
        return true;
    }
}
