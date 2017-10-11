package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

/**
 * Read the JSON.
 */
public interface Task035 {
    /**
     * Read json string with Jackson object mapper.
     * @param mapper mapper instance
     * @param jsonString json string
     * @return parsed data
     */
    Person readWithJackson(ObjectMapper mapper, String jsonString);

    /**
     * Read json string with Gson mapper.
     * @param builder gson builder
     * @param jsonString json string
     * @return parsed data
     */
    Person readWithGson(GsonBuilder builder, String jsonString);
}
