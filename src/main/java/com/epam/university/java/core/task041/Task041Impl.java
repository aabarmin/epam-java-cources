package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {
    private int id = 0;

    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        Entity entity = new EntityImpl(id++, value);
        collection.add(entity);
        return entity;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        if (collection.contains(entity)) {
            return entity;
        }
        return entity;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        if (collection == null || entity == null || value == null) {
            throw new IllegalArgumentException();
        }
        if (collection.contains(entity)) {
            collection.remove(entity);
            collection.add(new EntityImpl(entity.getId(), value));
        } else {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
        collection.remove(entity);
    }
}
