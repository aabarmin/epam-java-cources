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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = new PersonImpl();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PhoneNumber.class,
                new StdDeserializer<PhoneNumber>(PhoneNumber.class) {
                    @Override
                    public PhoneNumber deserialize(
                            JsonParser p, DeserializationContext ctxt)
                            throws IOException {
                        return new PhoneNumberImpl(p.getValueAsString());
                    }
                });
        try {
            person = mapper
                    .registerModule(module)
                    .readerFor(PersonImpl.class)
                    .readValue(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Person person = new PersonImpl();
        Gson gson = builder.create();

        person = gson.fromJson(jsonString, PersonImpl.class);

        JsonArray jsonArray = new Gson().fromJson(jsonString, JsonObject.class)
                .getAsJsonArray("phones");

        Collection<PhoneNumber> phoneNumbers = new ArrayList<>(jsonArray.size());

        for (JsonElement each : jsonArray) {
            phoneNumbers.add(new PhoneNumberImpl(each.getAsString()));
        }
        person.setPhoneNumbers(phoneNumbers);
        return person;
    }
}
