package com.epam.university.java.core.helper;

/**
 * Created by Aleksandr_Barmin on 8/31/2017.
 */
public class TestHelper {
    public static <T> T getInstance(Class<?> testClass) throws Exception {
        final Class<?> testableClass;
        final String testClassName = testClass.getName();
        if (testClassName.contains("Test")) {
            testableClass = Class.forName(testClassName.replace("Test", "Impl"));
        } else {
            testableClass = Class.forName(testClassName + "Impl");
        }
        return (T) testableClass.newInstance();
    }
}
