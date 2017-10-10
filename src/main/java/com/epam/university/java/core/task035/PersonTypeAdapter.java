package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonTypeAdapter extends TypeAdapter {

    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for {@code value}.
     *
     * @param out
     * @param value the Java object to write. May be null.
     */
    @Override
    public void write(JsonWriter out, Object value) throws IOException {

    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it to a Java object. Returns the converted object.
     *
     * @param in
     * @return the converted Java object. May be null.
     */
    @Override
    public Object read(JsonReader in) throws IOException {

        final Person person = new PersonImpl();

        in.beginObject();
        while (in.hasNext()) {

            switch (in.nextName()) {
                case "id":
                    person.setId(in.nextInt());
                    break;
                case "firstName":
                    person.setFirstName(in.nextString());
                    break;
                case "lastName":
                    person.setLastName(in.nextString());
                    break;
                case "phones":
                    Set<PhoneNumber> phoneNumbers = new HashSet<>();
                    in.beginArray();
                    while (in.hasNext()) {
                        phoneNumbers.add(new PhoneNumberImpl(in.nextString()));
                    }
                    in.endArray();
                    person.setPhoneNumbers(phoneNumbers);
                    break;
            }

        }
        in.endObject();

        return person;
    }
}
