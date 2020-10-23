package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = new PersonImpl();
        try {
            person = mapper.readValue(jsonString, PersonImpl.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        if (builder == null || jsonString == null) {
            throw new IllegalArgumentException();
        }
        Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, PersonImpl.class);
        JsonArray jsonArray = new Gson().fromJson(jsonString, JsonObject.class)
                .getAsJsonArray("phones");

        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            phoneNumbers.add(new PhoneNumberImpl(jsonElement.getAsString()));
        }

        person.setPhoneNumbers(phoneNumbers);
        return person;
    }
}
