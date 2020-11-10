package com.epam.university.java.core.task060;
/*
 * Created by Laptev Egor 10.11.2020
 * */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Task060Impl implements Task060 {
    @Override
    public OutputStream objectSerialization(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        return byteArrayOutputStream;
    }

    @Override
    public Object objectDeserialization(OutputStream outStream) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(((ByteArrayOutputStream) outStream).toByteArray());
        ObjectInputStream objectOutputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectOutputStream.readObject();
        return o;
    }


}
