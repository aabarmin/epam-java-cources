package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersonDeserializer implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement json, Type typeOfT,
                              JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        Person person = new PersonImpl();
        person.setId(jsonObject.get("id").getAsInt());
        person.setFirstName(jsonObject.get("firstName").getAsString());
        person.setLastName(jsonObject.get("lastName").getAsString());

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        JsonArray phones = jsonObject.get("phones").getAsJsonArray();
        for (JsonElement phone : phones) {
            phoneNumbers.add(context.deserialize(phone, PhoneNumber.class));
        }
        person.setPhoneNumbers(phoneNumbers);
        return person;
    }
}