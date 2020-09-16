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
 * Author Dmitry Novikov 16-Sep-20.
 */
public class Task035Impl implements Task035 {
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

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Person person = builder.registerTypeAdapter(PersonImpl.class, new PersonAdapter())
                .create().fromJson(jsonString, PersonImpl.class);
        return person;
    }
}