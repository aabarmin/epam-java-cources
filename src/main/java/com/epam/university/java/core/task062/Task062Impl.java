package com.epam.university.java.core.task062;

import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Task062Impl implements Task062 {

    @Override
    public OutputStream objectSerialization(Object obj) {
        OutputStream stream = new ByteArrayOutputStream();

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {

            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    @Override
    public Object objectDeserialization(OutputStream outStream) {

        ByteArrayOutputStream stream = (ByteArrayOutputStream) outStream;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stream.toByteArray());
        Object deserializedObject = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            deserializedObject = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializedObject;
    }
}
