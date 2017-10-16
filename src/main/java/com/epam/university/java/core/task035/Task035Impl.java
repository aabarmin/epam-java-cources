package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;

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

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Person.class, new PersonDeserializer(Person.class));
        mapper.registerModule(module);

        try {
            Person person = mapper.readValue(jsonString, Person.class);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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

        Gson gson = builder
                .registerTypeAdapter(Person.class, new PersonTypeAdapter())
                .create();

        Person person = gson.fromJson(jsonString, Person.class);
        return person;

    }
}
