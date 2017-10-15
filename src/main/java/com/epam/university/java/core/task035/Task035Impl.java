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
import java.util.ArrayList;
import java.util.Collection;

public class Task035Impl implements Task035 {

    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person result;
        try {
            result = mapper
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .readValue(jsonString, PersonImpl.class);
            JsonNode phones = mapper.readTree(jsonString).get("phones");
            Collection<PhoneNumber> phoneNumbers = new ArrayList<>(phones.size());
            for (JsonNode current : phones) {
                phoneNumbers.add(new PhoneNumberImpl(current.textValue()));
            }
            result.setPhoneNumbers(phoneNumbers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Gson gson = builder.create();
        Person result = gson.fromJson(jsonString, PersonImpl.class);
        JsonArray jsonArray = new Gson().fromJson(jsonString, JsonObject.class)
                .getAsJsonArray("phones");
        Collection<PhoneNumber> phoneNumbers = new ArrayList<>(jsonArray.size());
        for (JsonElement element : jsonArray) {
            phoneNumbers.add(new PhoneNumberImpl(element.getAsString()));
        }
        result.setPhoneNumbers(phoneNumbers);
        return result;
    }
}
