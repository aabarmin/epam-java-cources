package com.epam.university.java.core.task062;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class Task062Test {
    private Task062 instance;
    private PersonSerializable personSer;
    private PersonExternalizable personExt;
    private SingletonObject singletonObject;

    /**
     * Set up an instances before testing.
     *
     * @throws Exception in case of exception from TestHelper class
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task062.class);

        personSer = TestHelper.getInstance(PersonSerializable.class);
        personSer.setFullName("Name");
        personSer.setAge(30);
        personSer.setMale(true);
        personSer.setChildren(List.of(
                TestHelper.getInstance(PersonSerializable.class),
                TestHelper.getInstance(PersonSerializable.class)
                )
        );
        personSer.setSpouse(TestHelper.getInstance(PersonSerializable.class));

        personExt = TestHelper.getInstance(PersonExternalizable.class);
        personExt.setFullName("Another Name");
        personExt.setAge(42);
        personExt.setMale(false);
        personExt.setChildren(
                List.of(TestHelper.getInstance(PersonExternalizable.class),
                        TestHelper.getInstance(PersonExternalizable.class)
                )
        );
        personExt.setSpouse(TestHelper.getInstance(PersonExternalizable.class));

        singletonObject = SingletonObject.getInstance();
    }

    @Test
    public void testStandardSerialization() {
        OutputStream outputStream = instance.objectSerialization(personSer);
        Object obj = instance.objectDeserialization(outputStream);

        assertNotNull("outputStream is null", outputStream);
        assertNotNull("Deserialized object is null", obj);

        assertEquals("Serialization error: objects are not equal", personSer, obj);
    }

    @Test
    public void testExternalSerialization() {
        OutputStream outputStream = instance.objectSerialization(personExt);
        Object obj = instance.objectDeserialization(outputStream);

        assertNotNull("outputStream is null", outputStream);
        assertNotNull("Deserialized object is null", obj);

        assertEquals(
                "Something went wrong with external serialization: objects are not equal",
                personExt,
                obj
        );
    }

    @Test
    public void testSingletonObject() {
        assertNotNull("Singleton object is not initialized", singletonObject);

        OutputStream outputStream = instance.objectSerialization(singletonObject);
        Object obj = instance.objectDeserialization(outputStream);

        assertNotNull("Deserialized object is null", obj);
        assertSame(
                "Singleton deserialize error: objects are different",
                singletonObject,
                obj
        );
    }
}
