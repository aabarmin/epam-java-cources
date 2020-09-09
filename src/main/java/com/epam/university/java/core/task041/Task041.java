package com.epam.university.java.core.task041;

import java.util.Collection;

/**
 * CRUD Operations.
 * Tip: Entities are equal if their values are equal.
 */
public interface Task041 {

    /**
     * Perform <p>Create</p> operation with <code>collection</code> of entities.
     * Tip: Pay attention that id of entity is unique.
     * @param collection in which should create new entity.
     * @param value for creation new entity.
     * @return created entity.
     */
    Entity create(Collection<Entity> collection, String value);

    /**
     * Perform <p>Read</p> operation with <code>collection</code> of entities.
     * @param collection from which should read entity.
     * @param entity to be read.
     * @return read entity.
     */
    Entity read(Collection<Entity> collection, Entity entity);

    /**
     * Perform <p>Update</p> operation with <code>collection</code> of entities.
     * @param collection in which have to update entity object.
     * @param entity to be updated.
     * @param value that have to be changed in entity object.
     */
    void update(Collection<Entity> collection, Entity entity, String value);

    /**
     * Perform <p>Delete</p> operation with <code>collection</code> of entities.
     * @param collection from which have to delete object.
     * @param entity to be deleted.
     */
    void delete(Collection<Entity> collection, Entity entity);
}