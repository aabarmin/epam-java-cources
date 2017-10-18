package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import jdk.internal.dynalink.linker.LinkerServices;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 09.10.2017.
 * Read the JSON.
 */
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

        //add abstract resolver to PhoneNumber
        SimpleModule module = new SimpleModule("model", Version.unknownVersion());
        SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
        resolver.addMapping(PhoneNumber.class, PhoneNumberPojo.class);
        module.setAbstractTypes(resolver);
        mapper.registerModule(module);

        try {
            return mapper.readValue(
                    jsonString,
                    PersonJacksonPojo.class);
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

        List<PhoneNumber> phoneNumberCollection = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            phoneNumberCollection.add(new PhoneNumberImpl(jsonElement.getAsString()));
        }

        person.setPhoneNumbers(phoneNumberCollection);

        return person;
    }
}
