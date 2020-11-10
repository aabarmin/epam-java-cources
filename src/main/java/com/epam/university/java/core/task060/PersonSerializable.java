package com.epam.university.java.core.task060;

import java.io.Serializable;
import java.util.Collection;

public interface PersonSerializable extends Serializable {

    String getFullName();

    void setFullName(String fullName);

    int getAge();

    void setAge(int age);

    boolean isMale();

    void setMale(boolean male);

    PersonSerializable getSpouse();

    void setSpouse(PersonSerializable spouse);

    Collection<PersonSerializable> getChildren();

    void setChildren(Collection<PersonSerializable> children);
}
