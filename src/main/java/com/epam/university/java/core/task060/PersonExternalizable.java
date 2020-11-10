package com.epam.university.java.core.task060;

import java.io.Externalizable;
import java.util.Collection;

public interface PersonExternalizable extends Externalizable {

    String getFullName();

    void setFullName(String fullName);

    int getAge();

    void setAge(int age);

    boolean isMale();

    void setMale(boolean male);

    PersonExternalizable getSpouse();

    void setSpouse(PersonExternalizable spouse);

    Collection<PersonExternalizable> getChildren();

    void setChildren(Collection<PersonExternalizable> children);
}
