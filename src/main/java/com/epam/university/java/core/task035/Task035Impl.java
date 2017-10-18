package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implements <code>Task035</code> interface.
 */
public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = null;
        try {
            person = mapper.readValue(jsonString, Person.class);
            JsonNode jsonNodePhones = mapper.readTree(jsonString).get("phones");
            List<PhoneNumber> phoneNumberList = new ArrayList<>();
            jsonNodePhones.forEach(jsonNodeElement -> {
                PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(jsonNodeElement.textValue());
                phoneNumberList.add(phoneNumber);
            });
            person.setPhoneNumbers(phoneNumberList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Gson gson = builder.create();
        /*object implementation's non-generic parameter's name have to be equal
         to gson field*/
        Person person = gson.fromJson(jsonString, PersonImpl.class);
        /*object implementation's generic parameter's name can't be equal to
         gson field*/
        JsonArray jsonArray = new Gson().fromJson(jsonString, JsonObject.class)
                .getAsJsonArray("phones");
        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        jsonArray.forEach(jsonArrayElement -> {
            PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
            phoneNumber.setPhoneNumber(jsonArrayElement.getAsString());
            phoneNumberList.add(phoneNumber);
        });
        person.setPhoneNumbers(phoneNumberList);
        return person;
    }
}