package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.IOException;

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

            person = mapper
                    .registerModule(module)
                    .readValue(jsonString, PersonImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person);
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        builder.registerTypeAdapter(PhoneNumber.class,
                (JsonDeserializer<PhoneNumber>) (json, typeOfT, context) ->
                        new PhoneNumberImpl(json.getAsString()));
        final Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, PersonImpl.class);
        System.out.println(person);
        return person;
    }
}
