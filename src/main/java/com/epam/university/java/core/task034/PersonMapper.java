package com.epam.university.java.core.task034;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PersonMapper implements Mapper<Person> {

    private Person person = new PersonImpl();
    private BuilderMapper<Person> personBuilderMapper = new BuilderPersonMapper();

    @Override
    public BuilderMapper<Person> newInstance() {
        person = new PersonImpl();
        person.setPhoneNumbers(new ArrayList<>());
        return personBuilderMapper;
    }

    public class BuilderPersonMapper implements BuilderMapper<Person> {

        private Map<String, BiConsumer<Person, String>> mapper = new HashMap<>();
        private Mapper<PhoneNumber> numberMapper = new PhoneMapper();

        /**
         * Constructor.
         */
        public BuilderPersonMapper() {

            mapper.put("person", (p, s) -> {
            });
            mapper.put("id", (p, s) -> p.setId(Integer.parseInt(s)));
            mapper.put("first-name", Person::setFirstName);
            mapper.put("last-name", Person::setLastName);
            mapper.put("person-phones", (p, s) -> {
            });
            mapper.put("person-phone", (p, s) -> p.getPhoneNumbers()
                .add(
                    numberMapper.newInstance()
                        .set("person-phone", s)
                        .get()
                ));

        }

        @Override
        public Person get() {
            return person;
        }

        @Override
        public BuilderMapper<Person> set(String tag, String value) {
            mapper.get(tag).accept(person, value);
            return this;
        }
    }
}
