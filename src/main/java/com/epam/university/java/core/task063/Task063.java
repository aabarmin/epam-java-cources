package com.epam.university.java.core.task063;

import java.io.OutputStream;

/**
 * Serialization / deserialization.
 *
 * <p>
 *  Perform serialization/deserialization objects of classes PersonSerializable,
 *  PersonExternalizable and SingletonObject.
 *
 *  Initial object and object from method objectDeserialization() should be equal by fields (you
 *  need to override equals() and hashcode() methods).
 *
 *  Deserialization of SingletonObject instance should not break the Singleton pattern.
 * </p>
 */

public interface Task063 {

    /**
     * Object serialization.
     *
     * @param obj object to serialize
     * @return an output stream of serialized object
     * @throws IllegalArgumentException if obj is null
     */
    OutputStream objectSerialization(Object obj);

    /**
     * Object deserialization.
     *
     * @param outStream output stream of serialized object
     * @return a deserialized object
     * @throws IllegalArgumentException if outStream is null
     */
    Object objectDeserialization(OutputStream outStream);
}
