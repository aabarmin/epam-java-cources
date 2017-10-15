package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * {@inheritDoc}
 */
public class Task035Impl implements Task035 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        try {
            PersonImpl person = mapper.readValue(new StringReader(jsonString), PersonImpl.class);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        JsonDeserializer<Person> deserializer = new JsonDeserializer<Person>() {
            @Override
            public Person deserialize(JsonElement json,
                                      Type typeOfT,
                                      JsonDeserializationContext context)
                    throws JsonParseException {

                Person person = new PersonImpl();
                JsonObject asJsonObject = json.getAsJsonObject();
                int id = asJsonObject.get("id").getAsInt();
                person.setId(id);
                String firstName = asJsonObject.get("firstName").getAsString();
                person.setFirstName(firstName);
                String lastName = asJsonObject.get("lastName").getAsString();
                person.setLastName(lastName);
                person.setPhoneNumbers(new ArrayList<>());
                for (JsonElement phone : asJsonObject.get("phones").getAsJsonArray()) {
                    PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                    phoneNumber.setPhoneNumber(phone.getAsString());
                    person.getPhoneNumbers().add(phoneNumber);
                }
                return person;
            }
        };
        builder.registerTypeAdapter(PersonImpl.class, deserializer);
        Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, PersonImpl.class);
        return person;
    }
}
