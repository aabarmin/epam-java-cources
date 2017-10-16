package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static com.epam.university.java.core.Callback.runObject;

public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        return runObject(() -> {
            final JsonNode rootNode = mapper.readTree(jsonString);
            final Person person = new PersonImpl();
            final JsonNode idNode = rootNode.path("id");
            person.setId(idNode.asInt());
            final JsonNode firstNameNode = rootNode.path("firstName");
            person.setFirstName(firstNameNode.asText());
            final JsonNode lastNameNode = rootNode.path("lastName");
            person.setLastName(lastNameNode.asText());
            final JsonNode phonesNode = rootNode.path("phones");
            final Collection<PhoneNumber> phoneNumbers = new ArrayList<>();
            final Iterator<JsonNode> phone = phonesNode.elements();
            while (phone.hasNext()) {
                final PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(phone.next().asText());
                phoneNumbers.add(phoneNumber);
            }
            person.setPhoneNumbers(phoneNumbers);
            return person;
        });
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        builder.registerTypeAdapter(PhoneNumber.class,
                (JsonDeserializer<PhoneNumber>) (json, typeOfT, context) -> {
                final PhoneNumber phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(json.getAsString());
                return phoneNumber;
            });
        builder.registerTypeAdapter(Person.class,
                (JsonDeserializer<Person>) (json, typeOfT, context) -> {
                final JsonObject asJsonObject = json.getAsJsonObject();
                final PersonImpl person = new PersonImpl();
                person.setId(asJsonObject.get("id").getAsInt());
                person.setFirstName(asJsonObject.get("firstName").getAsString());
                person.setLastName(asJsonObject.get("lastName").getAsString());
                Collection<PhoneNumber> collectionNumbers = new ArrayList<>();
                final JsonArray phones = asJsonObject.get("phones").getAsJsonArray();
                for (JsonElement phone : phones) {
                    final PhoneNumber phoneNumber = context.deserialize(phone, PhoneNumber.class);
                    collectionNumbers.add(phoneNumber);
                }
                person.setPhoneNumbers(collectionNumbers);
                return person;
            });

        final Gson gson = builder.create();
        return gson.fromJson(jsonString, Person.class);
    }
}
