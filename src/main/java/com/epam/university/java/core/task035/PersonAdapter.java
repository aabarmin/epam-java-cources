package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Author Dmitry Novikov 16-Sep-20.
 */
public class PersonAdapter extends TypeAdapter<Person> {

    @Override
    public void write(JsonWriter out, Person value) throws IOException {

    }

    @Override
    public Person read(JsonReader in) throws IOException {
        Person person = new PersonImpl();
        Collection<PhoneNumber> phones = new ArrayList<>();
        in.beginObject();
        String fieldname = null;

        while (in.hasNext()) {
            JsonToken token = in.peek();
            if (token.equals(JsonToken.NAME)) {
                fieldname = in.nextName();
            }
            if ("id".equals(fieldname)) {
                token = in.peek();
                person.setId(in.nextInt());
            }
            if ("firstName".equals(fieldname)) {
                token = in.peek();
                person.setFirstName(in.nextString());
            }
            if ("lastName".equals(fieldname)) {
                token = in.peek();
                person.setLastName(in.nextString());
            }
            if ("phones".equals(fieldname)) {
                in.beginArray();
                while (in.hasNext()) {
                    phones.add(new PhoneNumberImpl(in.nextString()));
                }
                in.endArray();
                person.setPhoneNumbers(phones);
            }
        }
        in.endObject();
        return person;
    }
}