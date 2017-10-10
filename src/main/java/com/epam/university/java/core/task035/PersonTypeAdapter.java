package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    Also could be done with deseralizer, but TypeAdapter must be faster
    https://stackoverflow.com/questions/30631004/gson-type-adapter-vs-custom-deseralizer
 */
public class PersonTypeAdapter extends TypeAdapter {

    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for {@code value}.
     */
    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        // not necessary for test cases
    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it to a Java object. Returns the converted object.
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
                    List<PhoneNumber> phoneNumbers = new ArrayList<>();
                    in.beginArray();
                    while (in.hasNext()) {
                        phoneNumbers.add(new PhoneNumberImpl(in.nextString()));
                    }
                    in.endArray();
                    person.setPhoneNumbers(phoneNumbers);
                    break;
                default:
                    break;
            }

        }
        in.endObject();

        return person;
    }
}
