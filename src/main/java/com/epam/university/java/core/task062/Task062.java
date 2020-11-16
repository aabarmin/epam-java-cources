package com.epam.university.java.core.task062;

import java.io.OutputStream;

/**
 * Serialization / deserialization.
 *
 * <p>
 *  Perform serialization/deserialization of objects PersonSerializable, PersonExternalizable
 *  and SingletonObject classes.
 *
 *  Initial object and object from method objectDeserialization() should be equal by fields (you
 *  need to override equals() and hashcode() methods).
 *
 *  Deserialization of SingletonObject instance should not break the Singleton pattern.
 *  You should create a field with name "instance" in SingletonObjectImpl class.
 * </p>
 */

public interface Task062 {

    /**
     * Object serialization.
     *
     * @param obj object to serialize
     * @return an output stream of serialized object
     */
    OutputStream objectSerialization(Object obj);

    /**
     * Object deserialization.
     *
     * @param outStream output stream of serialized object
     * @return a deserialized object
     */
    Object objectDeserialization(OutputStream outStream);
}
