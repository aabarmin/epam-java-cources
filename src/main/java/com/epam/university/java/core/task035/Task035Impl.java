package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Implementation class for Task035.
 *
 * @author Sergei Titov
 */
public class Task035Impl implements Task035 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Person.class, new PersonDeserializer());
        mapper.registerModule(module);

        final Person person;
        try {
            person = mapper.readValue(jsonString, Person.class);
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

        builder.registerTypeAdapter(PhoneNumber.class, new JsonDeserializer<PhoneNumber>() {
            @Override
            public PhoneNumber deserialize(JsonElement jsonElement,
                                             Type type,
                                             JsonDeserializationContext jsonDeserializationContext)
                    throws JsonParseException {

                return new PhoneNumberImpl(jsonElement.getAsString());
            }
        });

        final Gson gson = builder.create();

        return gson.fromJson(jsonString, PersonImpl.class);
    }
}
