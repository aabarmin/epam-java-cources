package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        return null;

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

        Person person = null;
        Gson gson = builder
                .registerTypeAdapter(Person.class, new PersonTypeAdapter())
                .create();

        person = gson.fromJson(jsonString, Person.class);
        return person;

    }
}
