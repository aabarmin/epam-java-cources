package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Daniil Smirnov on 15.10.2017.
 * All copy registered MF.
 */
public class Task035Impl implements Task035 {

    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        try {
            JsonNode rootNode = mapper.readValue(jsonString, JsonNode.class);
            Person person = new PersonImpl();
            person.setId(rootNode.get("id").asInt());
            person.setFirstName(rootNode.get("firstName").asText());
            person.setLastName(rootNode.get("lastName").asText());
            Iterator<JsonNode> phones = rootNode.get("phones").iterator();
            List<PhoneNumber> phoneNumberList = new ArrayList<>();
            while (phones.hasNext()) {
                PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phones.next().asText());
                phoneNumberList.add(phoneNumber);
            }
            person.setPhoneNumbers(phoneNumberList);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Gson g = builder.registerTypeAdapter(Person.class, new JsonDeserializer<Person>() {
            @Override
            public Person deserialize(JsonElement json, Type typeOfT,
                                      JsonDeserializationContext context)
                    throws JsonParseException {
                JsonObject jsonObject = json.getAsJsonObject();
                Person p = new PersonImpl();
                p.setId(jsonObject.get("id").getAsInt());
                p.setFirstName(jsonObject.get("firstName").getAsString());
                p.setLastName(jsonObject.get("lastName").getAsString());
                List<PhoneNumber> phoneNumberList = new ArrayList<>();
                JsonArray jsonElements = jsonObject.getAsJsonArray("phones");
                for (JsonElement element : jsonElements) {
                    PhoneNumber phoneNumber = context.deserialize(element, PhoneNumber.class);
                    phoneNumberList.add(phoneNumber);
                }
                p.setPhoneNumbers(phoneNumberList);
                return p;
            }
        })
                .registerTypeAdapter(PhoneNumber.class, new JsonDeserializer<PhoneNumber>() {

                    @Override
                    public PhoneNumber deserialize(JsonElement json, Type typeOfT,
                                                   JsonDeserializationContext context)
                            throws JsonParseException {
                        PhoneNumber phoneNumber = new PhoneNumberImpl();
                        phoneNumber.setPhoneNumber(json.getAsString());
                        return phoneNumber;
                    }
                }).create();

        return g.fromJson(jsonString, Person.class);
    }
}
