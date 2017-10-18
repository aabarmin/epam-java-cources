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
import java.util.Collection;
import java.util.Iterator;



public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        try {
            final JsonNode root = mapper.readTree(jsonString);
            Person person = new PersonImpl();
            JsonNode idNode = root.path("id");
            person.setId(idNode.asInt());
            JsonNode firstName = root.findValue("firstName");
            person.setFirstName(firstName.asText());
            JsonNode lastName = root.findValue("lastName");
            person.setLastName(lastName.asText());
            Iterator<JsonNode> phones = root.findValue("phones").elements();
            Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
            while (phones.hasNext()) {
                PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phones.next().asText());
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
        builder.setPrettyPrinting();

        builder.registerTypeAdapter(PhoneNumber.class, new PhoneNumberDeserializer());
        builder.registerTypeAdapter(Person.class, new PersonDeserializer());
        final Gson gson = builder.create();
        final Person person = gson.fromJson(jsonString, Person.class);


        return person;
    }
}
