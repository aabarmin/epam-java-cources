package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Romin Nuro on 28.08.2020 15:42.
 */
public class Task035Impl implements Task035 {
    /**
     * Read json string with Jackson object mapper.
     *
     * @param mapper     mapper instance
     * @param jsonString json string
     * @return parsed data
     */
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = new PersonImpl();
        try {
            SimpleModule module = new SimpleModule();
            module.addDeserializer(PhoneNumber.class,
                    new StdDeserializer<PhoneNumber>(PhoneNumber.class) {
                        @Override
                        public PhoneNumber deserialize(JsonParser p, DeserializationContext ctxt)
                                throws IOException {
                            return new PhoneNumberImpl(p.getValueAsString());
                        }
                    });
            person = mapper.registerModule(module).readValue(jsonString, PersonImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return person;
    }

    /**
     * Read json string with Gson mapper.
     *
     * @param builder    gson builder
     * @param jsonString json string
     * @return parsed data
     */
    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Person person = builder.registerTypeAdapter(PersonImpl.class, new PersonAdapter())
                .create().fromJson(jsonString, PersonImpl.class);
        return person;
    }

    class PersonAdapter extends TypeAdapter<Person> {

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
}
