package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonDeserializer extends StdDeserializer<Person> {

    public PersonDeserializer(Class<?> vc) {
        super(vc);
    }

    /**
     * Method that can be called to ask implementation to deserialize
     * JSON content into the value type this serializer handles.
     * Returned instance is to be constructed by method itself.
     */
    @Override
    public Person deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        final Person person = new PersonImpl();

        JsonNode rootNode = p.getCodec().readTree(p);
        person.setId(rootNode.path("id").asInt());
        person.setFirstName(rootNode.path("firstName").asText());
        person.setLastName(rootNode.path("lastName").asText());

        JsonNode phonesNode = rootNode.path("phones");
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        final Iterator<JsonNode> phonesNodeIterator = phonesNode.elements();

        while (phonesNodeIterator.hasNext()) {
            phoneNumbers.add(new PhoneNumberImpl(phonesNodeIterator.next().asText()));
        }

        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
