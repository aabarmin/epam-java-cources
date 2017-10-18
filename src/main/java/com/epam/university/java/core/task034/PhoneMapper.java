package com.epam.university.java.core.task034;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PhoneMapper implements Mapper<PhoneNumber> {

    private PhoneNumber number = new PhoneNumberImpl();
    private BuilderMapper<PhoneNumber> phoneNumberBuilderMapper = new BuilderPhoneMapper();

    @Override
    public BuilderMapper<PhoneNumber> newInstance() {
        number = new PhoneNumberImpl();

        return phoneNumberBuilderMapper;
    }

    public class BuilderPhoneMapper implements BuilderMapper<PhoneNumber> {

        private Map<String, BiConsumer<PhoneNumber,String>> mapper = new HashMap<>();

        public BuilderPhoneMapper() {
            mapper.put("person-phone", PhoneNumber::setPhoneNumber);
        }

        @Override
        public PhoneNumber get() {
            return number;
        }

        @Override
        public BuilderMapper<PhoneNumber> set(String tag, String value) {
            mapper.get(tag).accept(number, value);
            return this;
        }
    }
}
