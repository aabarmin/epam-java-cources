package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Task035Impl implements Task035 {
    private Person person;
    private Collection<PhoneNumber> phoneNumbers;

    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        person = new PersonImpl();
        phoneNumbers = new ArrayList<>();
        try {
            JsonNode rootNode = mapper.readTree(jsonString);
            person.setId(rootNode.path("id").asInt());
            person.setFirstName(rootNode.path("firstName").asText());
            person.setLastName(rootNode.path("lastName").asText());
            JsonNode phoneNosNode = rootNode.path("phones");
            Iterator<JsonNode> elements = phoneNosNode.elements();
            while (elements.hasNext()) {
                phoneNumbers.add(new PhoneNumberImpl(elements.next().asText()));
            }
            person.setPhoneNumbers(phoneNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        final Gson gson = builder.create();
        builder.registerTypeAdapter(Person.class, new JsonDeserializer<Person>() {
            @Override
            public Person deserialize(JsonElement json,
                                      Type typeOfT,
                                      JsonDeserializationContext context)
                    throws JsonParseException {
                person = new PersonImpl();
                phoneNumbers = new ArrayList<>();
                JsonObject jo = json.getAsJsonObject();
                person.setId(jo.get("id").getAsInt());
                person.setFirstName(jo.get("firstName").getAsString());
                person.setLastName(jo.get("lastName").getAsString());
                JsonArray ja = jo.get("phones").getAsJsonArray();
                for (JsonElement je: ja) {
                    phoneNumbers.add(new PhoneNumberImpl(je.getAsString()));
                }
                person.setPhoneNumbers(phoneNumbers);
                return person;
            }
        }).create().fromJson(jsonString, Person.class);
        return person;
    }
}
