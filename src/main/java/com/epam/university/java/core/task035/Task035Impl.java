package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Read the JSON.
 */
public class Task035Impl implements Task035 {

    /**
     * Read json string with Jackson object mapper.
     * @param mapper mapper instance
     * @param jsonString json string
     * @return parsed data
     */
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read json string with Gson mapper.
     * @param builder gson builder
     * @param jsonString json string
     * @return parsed data
     */
    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        return builder
            .registerTypeAdapter(Person.class, new PersonDeserializer())
            .registerTypeAdapter(PhoneNumber.class, new PhoneNumberDeserializer())
            .create()
            .fromJson(jsonString, Person.class);
    }

}
