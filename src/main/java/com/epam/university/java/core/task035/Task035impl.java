package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

/**
 * Created by Александр on 09.10.2017.
 * Read the JSON.
 */
public class Task035impl implements Task035 {
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
        return null;
    }
}
