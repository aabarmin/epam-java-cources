package com.epam.university.java.core.task062;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Objects;

public class PersonExternalizableImpl implements PersonExternalizable {

    private String fullName;
    private int age;
    private boolean male;
    private PersonExternalizable spouse;
    private Collection<PersonExternalizable> children;

    /**
     * Default person Externalizable constructor.
     */
    public PersonExternalizableImpl() {
    }

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
    public void setSpouse(PersonExternalizable spouse) {
        this.spouse = spouse;
    }

    @Override
    public void setChildren(Collection<PersonExternalizable> children) {
        this.children = children;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.fullName);
        out.writeObject(this.age);
        out.writeObject(this.male);
        out.writeObject(this.spouse);
        out.writeObject(this.children);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fullName = (String) in.readObject();
        age = (int) in.readObject();
        male = (boolean) in.readObject();
        spouse = (PersonExternalizable) in.readObject();
        children = (Collection<PersonExternalizable>) in.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonExternalizableImpl that = (PersonExternalizableImpl) o;
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
