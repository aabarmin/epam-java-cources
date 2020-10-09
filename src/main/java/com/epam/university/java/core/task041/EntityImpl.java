package com.epam.university.java.core.task041;

import java.util.Objects;

/**
 * Created by Romin Nuro on 09.10.2020 16:28.
 */
public class EntityImpl implements Entity {
    private int id;
    private String value;

    public EntityImpl(int id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * getter for id.
     *
     * @return id of entity
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * getter of value.
     *
     * @return value of entity
     */
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityImpl)) {
            return false;
        }
        EntityImpl entity = (EntityImpl) o;
        return getId() == entity.getId()
                && Objects.equals(getValue(), entity.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }
}
