package com.epam.university.java.core.task011;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksandr_Barmin on 9/11/2017.
 */
public class Task011Test {
    private Task011 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test
    public void getLastNameWithArray() throws Exception {
        final String[] collection = {
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge"
        };
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with array",
                "Bart",
                lastName
        );
    }


    @Test
    public void getLastNameWithArrayList() throws Exception {
        final ArrayList<String> collection = new ArrayList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with ArrayList",
                "Bart",
                lastName
        );
    }

    @Test
    public void getLastNameWithLinkedList() throws Exception {
        final LinkedList<String> collection = new LinkedList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with LinkedList",
                "Bart",
                lastName
        );
    }

}