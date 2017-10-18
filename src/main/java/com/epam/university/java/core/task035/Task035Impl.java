package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        try {
            Person person = new PersonImpl();
            JsonNode root = mapper.readTree(jsonString);

            JsonNode id = root.path("id");
            person.setId(id.asInt());

            JsonNode firstName = root.path("firstName");
            person.setFirstName(firstName.asText());

            JsonNode lastName = root.path("lastName");
            person.setLastName(lastName.asText());

            JsonNode phones = root.path("phones");
            List<PhoneNumber> phoneNumbers = new ArrayList<>();
            Iterator<JsonNode> phone = phones.elements();
            while (phone.hasNext()) {
                PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phone.next().asText());
                phoneNumbers.add(phoneNumber);
            }
            person.setPhoneNumbers(phoneNumbers);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Gson gson = builder
                .registerTypeAdapter(Person.class, new PersonDeserializer())
                .registerTypeAdapter(PhoneNumber.class, new PhoneNumberDeserializer())
                .create();
        return gson.fromJson(jsonString, Person.class);
    }
}