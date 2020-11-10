package com.epam.university.java.core.task063;

import java.io.Externalizable;
import java.util.Collection;

public interface PersonExternalizable extends Externalizable {

    void setFullName(String fullName);

    void setAge(int age);

    void setMale(boolean male);

    void setSpouse(PersonExternalizable spouse);

    void setChildren(Collection<PersonExternalizable> children);
}
