package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Вера on 16.10.2017.
 */
public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = new PersonImpl();
        // так не работает
        //try {
        //    person = mapper.readValue(jsonString,PersonImpl.class);
        //    //PhoneNumber childNode =  mapper.readValues(jsonString, PhoneNumberImpl.class);

        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        try {
            final JsonNode rootNode = mapper.readTree(jsonString);
            final JsonNode idNode = rootNode.path("id");
            person.setId(idNode.asInt());
            final JsonNode firstNameNode = rootNode.path("firstName");
            person.setFirstName(firstNameNode.asText());
            final JsonNode lastNameNode = rootNode.path("lastName");
            person.setLastName(lastNameNode.asText());
            final JsonNode phonesNode = rootNode.path("phones");
            final Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
            final Iterator<JsonNode> phone = phonesNode.elements();
            while (phone.hasNext()) {
                final PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phone.next().asText());
                phoneNumbers.add(phoneNumber);
            }
            person.setPhoneNumbers(phoneNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {

        Gson gson = builder.create();
        Person person = new PersonImpl();
        person = gson.fromJson(jsonString, PersonImpl.class);

        JsonParser parser = new JsonParser();

        Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("phones");

        for (JsonElement jsonElement : jsonArray) {
            PhoneNumber phoneNumber = new PhoneNumberImpl();
            phoneNumber.setPhoneNumber(jsonElement.getAsString());
            phoneNumbers.add(phoneNumber);
        }
        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
