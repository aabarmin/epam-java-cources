package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Task035Impl implements Task035 {

    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        Person person = new PersonImpl();

        try {
            JsonNode personNode = mapper.readTree(jsonString);
            person.setId(personNode.path("id").asInt());
            person.setFirstName(personNode.path("firstName").asText());
            person.setLastName(personNode.path("lastName").asText());
            JsonNode array = personNode.path("phones");
            List<PhoneNumber> phoneNumbers = new ArrayList<>();
            Iterator<JsonNode> iterator = array.elements();
            while (iterator.hasNext()) {
                PhoneNumber number = new PhoneNumberImpl();
                number.setPhoneNumber(iterator.next().asText());
                phoneNumbers.add(number);
            }

            person.setPhoneNumbers(phoneNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        Person target = builder
            .registerTypeAdapter(PhoneNumber.class,
                (JsonDeserializer<PhoneNumber>) (json, typeOfT, context) -> {
                    PhoneNumber number = new PhoneNumberImpl();
                    number.setPhoneNumber(json.getAsString());
                    return number;
                })
            .registerTypeAdapter(Person.class,
                (JsonDeserializer<Person>) (json, typeOfT, context) -> {
                    JsonObject object = json.getAsJsonObject();

                    Person person = new PersonImpl();
                    person.setId(object.getAsJsonPrimitive("id").getAsInt());
                    person.setFirstName(object.getAsJsonPrimitive("firstName").getAsString());
                    person.setLastName(object.getAsJsonPrimitive("lastName").getAsString());

                    Collection<PhoneNumber> phoneNumbers = new ArrayList<>();

                    object.getAsJsonArray("phones")
                        .forEach(o -> phoneNumbers
                            .add((PhoneNumber) context.deserialize(o, PhoneNumber.class)));

                    person.setPhoneNumbers(phoneNumbers);

                    return person;
                })
            .create()
            .fromJson(jsonString, Person.class);

        return target;
    }
}
