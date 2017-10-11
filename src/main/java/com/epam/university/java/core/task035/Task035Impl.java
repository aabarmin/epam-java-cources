package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
        try {
            Person person = mapper
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(jsonString, PersonImpl.class);

            // creating collection of phone numbers
            List<PhoneNumber> phoneNumberCollection = new LinkedList<>();
            JsonNode phones = mapper.readTree(jsonString).get("phones");
            for (JsonNode phone : phones) {
                PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phone.textValue());
                phoneNumberCollection.add(phoneNumber);
            }

            // putting phone numbers into person
            person.setPhoneNumbers(phoneNumberCollection);

            return person;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, PersonImpl.class);

        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("phones");


        List<PhoneNumber> phoneNumberCollection = new LinkedList<>();
        for (JsonElement jsonElement : jsonArray) {
            PhoneNumber phone = new PhoneNumberImpl();
            phone.setPhoneNumber(jsonElement.getAsString());
            phoneNumberCollection.add(phone);
        }

        person.setPhoneNumbers(phoneNumberCollection);

        return person;
    }
}
