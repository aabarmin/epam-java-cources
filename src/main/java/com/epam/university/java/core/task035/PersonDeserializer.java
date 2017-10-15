package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.core.task034.PhoneNumber;
import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;


/**
 * Class for person de-serializing from JSON by Jackson mapper
 *
 * @author Sergei Titov
 */
public class PersonDeserializer extends JsonDeserializer<Person> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Person deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);

        final int id = node.get("id").asInt();
        final String firstName = node.get("firstName").asText();
        final String lastName = node.get("lastName").asText();

        // id, names
        Person person = new PersonImpl();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        // phones
        Collection<PhoneNumber> phones = person.getPhoneNumbers();
        Iterator<JsonNode> phoneItr = node.get("phones").elements();
        while(phoneItr.hasNext()) {
            JsonNode element = phoneItr.next();
            phones.add(
                    new PhoneNumberImpl(element.asText())
            );
        }

        return person;
    }
}