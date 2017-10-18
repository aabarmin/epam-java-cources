package com.epam.university.java.core.task035;


import com.epam.university.java.core.task034.PhoneNumber;

import com.epam.university.java.core.task034.PhoneNumberImpl;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


import java.lang.reflect.Type;

public class PhoneNumberDeserializer implements JsonDeserializer<PhoneNumber> {


    @Override
    public PhoneNumber deserialize(JsonElement json,
                                   Type typeOfT,
                                   JsonDeserializationContext context) throws JsonParseException {

        PhoneNumber phoneNumber = new PhoneNumberImpl();
        phoneNumber.setPhoneNumber(json.getAsString());
        return phoneNumber;
    }
}
