package com.epam.university.java.core.task011;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithNullArray() throws Exception {
        final String[] collection = null;
        instance.getLastName(collection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithEmptyArray() throws Exception {
        final String[] collection = {};
        instance.getLastName(collection);
    }

    @Test
    public void getLastNameWithSingleElementArray() throws Exception {
        final String[] collection = {
                "Homer"
        };
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with items",
                "Homer",
                lastName
        );
    }

    @Test
    public void getLastNameWithArrayFirst() throws Exception {
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
    public void getLastNameWithArraySecond() throws Exception {
        final String[] collection = {
                "Homer",
                "Bart",
                "Maggie",
                "Lisa"
        };
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with items",
                "Lisa",
                lastName
        );
    }

    @Test
    public void getLastNameWithArrayThird() throws Exception {
        final String[] collection = {
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge",
                "Nelson"
        };
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with items",
                "Lisa",
                lastName
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithNullArrayList() throws Exception {
        final ArrayList<String> collection = null;
        instance.getLastName(collection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithEmptyArrayList() throws Exception {
        final ArrayList<String> collection = new ArrayList<>();
        instance.getLastName(collection);
    }

    @Test
    public void getLastNameWithSingleElementArrayList() throws Exception {
        final ArrayList<String> collection = new ArrayList<>(Collections.singletonList(
                "Homer"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with ArrayList",
                "Homer",
                lastName
        );
    }

    @Test
    public void getLastNameWithArrayListFirst() throws Exception {
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
    public void getLastNameWithArrayListSecond() throws Exception {
        final ArrayList<String> collection = new ArrayList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with ArrayList",
                "Lisa",
                lastName
        );
    }

    @Test
    public void getLastNameWithArrayListThird() throws Exception {
        final ArrayList<String> collection = new ArrayList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge",
                "Nelson"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with ArrayList",
                "Lisa",
                lastName
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithNullLinkedList() throws Exception {
        final LinkedList<String> collection = null;
        instance.getLastName(collection);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLastNameWithEmptyLinkedList() throws Exception {
        final LinkedList<String> collection = new LinkedList<>();
        instance.getLastName(collection);
    }

    @Test
    public void getLastNameWithSingleElementLinkedListFirst() throws Exception {
        final LinkedList<String> collection = new LinkedList<>(Collections.singletonList(
                "Homer"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with LinkedList",
                "Homer",
                lastName
        );
    }

    @Test
    public void getLastNameWithLinkedListFirst() throws Exception {
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

    @Test
    public void getLastNameWithLinkedListSecond() throws Exception {
        final LinkedList<String> collection = new LinkedList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with LinkedList",
                "Lisa",
                lastName
        );
    }

    @Test
    public void getLastNameWithLinkedListThird() throws Exception {
        final LinkedList<String> collection = new LinkedList<>(Arrays.asList(
                "Homer",
                "Bart",
                "Maggie",
                "Lisa",
                "Marge",
                "Nelson"
        ));
        final String lastName = instance.getLastName(collection);
        assertEquals("Error in test with LinkedList",
                "Lisa",
                lastName
        );
    }

}
