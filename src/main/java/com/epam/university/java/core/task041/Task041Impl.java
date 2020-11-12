package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {

    private int id = 0;

    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        EntityImpl entity = new EntityImpl(id, value);
        id++;
        collection.add(entity);
        return entity;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }

        return entity;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        if (collection == null || value == null || entity == null) {
            throw new IllegalArgumentException();
        }
        Entity newEntity = new EntityImpl(entity.getId(), value);
        boolean found = false;
        for (Entity entity1 : collection) {
            if (entity1.getId() == newEntity.getId()) {
                found = true;
                collection.remove(entity1);
                collection.add(newEntity);
            }
        }

        if (!found) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }

        collection.removeIf(entity1 -> entity1.getId() == entity.getId());

    }
}
