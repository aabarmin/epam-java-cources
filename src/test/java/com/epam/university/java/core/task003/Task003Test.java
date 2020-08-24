package com.epam.university.java.core.task003;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Task003Test {
    private Task003 instance;
    private FilteringCondition filteringCondition;
    private MappingOperation mappingOperation;
    private FlatMappingOperation flatMappingOperation;

    /**
     * Prepare environment.
     * @throws Exception if can't create testable classes
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task003.class);
        filteringCondition = TestHelper.getInstance(FilteringCondition.class);
        mappingOperation = TestHelper.getInstance(MappingOperation.class);
        flatMappingOperation = TestHelper.getInstance(FlatMappingOperation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvertValuesNotProvided() throws Exception {
        instance.invert(null);
    }

    @Test
    public void testInvert() throws Exception {
        final String[] source = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        final String[] target = {
                "Four",
                "Three",
                "Two",
                "One"
        };
        assertArrayEquals("Error in invert operation",
                target,
                instance.invert(source)
        );
    }

    @Test
    public void testInvertEmpty() throws Exception {
        final String[] source = {};
        final String[] target = {};
        assertArrayEquals("Error in invert operation",
                target,
                instance.invert(source)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinFirstArgumentsNotProvided() throws Exception {
        final String[] target = {};
        instance.join(null, target);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinSecondArgumentsNotProvided() throws Exception {
        final String[] source = {};
        instance.join(source, null);
    }

    @Test
    public void testJoin() throws Exception {
        final String[] first = {
                "One",
                "Two"
        };
        final String[] second = {
                "Three",
                "Four"
        };
        final String[] target = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        assertArrayEquals("Error in join operation",
                target,
                instance.join(first, second)
        );
    }

    @Test
    public void testJoinEmpty() throws Exception {
        final String[] first = {};
        final String[] second = {};
        final String[] target = {};
        assertArrayEquals("Error in join operation",
                target,
                instance.join(first, second)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithoutArguments() throws Exception {
        instance.findMax(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArguments() throws Exception {
        final int[] source = {};
        instance.findMax(source);
    }

    @Test
    public void testMaxAllDifferent() throws Exception {
        final int[] source = {
                -5,
                0,
                5
        };
        assertEquals("Error in find max operation",
                5,
                instance.findMax(source)
        );
    }

    @Test
    public void testMaxAllEquals() throws Exception {
        final int[] source = {
                -5,
                -5,
                -5
        };
        assertEquals("Error in find max operation",
                -5,
                instance.findMax(source)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFilterWithoutFirstArguments() throws Exception {
        instance.filter(null, filteringCondition);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFilterWithoutSecondArguments() throws Exception {
        final String[] source = {};
        instance.filter(source, null);
    }

    @Test
    public void testFilterWithEmptyArgument() throws Exception {
        final String[] source = {};
        final String[] target = {};
        assertArrayEquals("Error in filter operation",
                target,
                instance.filter(source, filteringCondition)
        );
    }

    @Test
    public void testFilter() throws Exception {
        final String[] source = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        final String[] target = {
                "Three",
                "Four"
        };
        assertArrayEquals("Error in filter operation",
                target,
                instance.filter(source, filteringCondition)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapWithoutFirstArguments() throws Exception {
        instance.map(null, mappingOperation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapWithoutSecondArguments() throws Exception {
        final String[] source = {};
        instance.map(source, null);
    }

    @Test
    public void testMapWithEmptyArgument() throws Exception {
        final String[] source = {};
        final String[] target = {};
        assertArrayEquals("Error in map operation",
                target,
                instance.map(source, mappingOperation)
        );
    }

    @Test
    public void testMap() throws Exception {
        final String[] source = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        final String[] target = {
                "enO",
                "owT",
                "eerhT",
                "ruoF"
        };
        assertArrayEquals("Error in map operation",
                target,
                instance.map(source, mappingOperation)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFlatMapWithoutFirstArguments() throws Exception {
        instance.flatMap(null, flatMappingOperation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFlatMapWithoutSecondArguments() throws Exception {
        final String[] source = {};
        instance.flatMap(source, null);
    }

    @Test
    public void testFlatMapWithEmptyArgument() throws Exception {
        final String[] source = {};
        final String[] target = {};
        assertArrayEquals("Error in flat map operation",
                target,
                instance.flatMap(source, flatMappingOperation)
        );
    }

    @Test
    public void testFlatMap() throws Exception {
        final String[] source = {
                "1, 2,     3, 4   , 5",
                "1, 2, 6,      7, 7, 7, 8",
                "10, 9"
        };
        final String[] target = {
                "10",
                "9",
                "8",
                "7",
                "6",
                "5",
                "4",
                "3",
                "2",
                "1"
        };
        assertArrayEquals("Error in flat map operation",
                target,
                instance.flatMap(source, flatMappingOperation)
        );
    }

    @Test
    public void testFlatMap2() throws Exception {
        final String[] source = {
                "   150   , 2,     3, 4   , 5",
                "1, 2, 6,      7, 7, 7, 8",
                "10, 9"
        };
        final String[] target = {
                "150",
                "10",
                "9",
                "8",
                "7",
                "6",
                "5",
                "4",
                "3",
                "2",
                "1"
        };
        assertArrayEquals("Error in flat map operation",
                target,
                instance.flatMap(source, flatMappingOperation)
        );
    }

    @Test
    public void testFlatMap3() throws Exception {
        final String[] source = {
                "   150   , 2,     3, 4   , 5",
                "1, 2, 6,      7, 7, 7, 8",
                "10, 9, 230    "
        };
        final String[] target = {
                "230",
                "150",
                "10",
                "9",
                "8",
                "7",
                "6",
                "5",
                "4",
                "3",
                "2",
                "1"
        };
        assertArrayEquals("Error in flat map operation",
                target,
                instance.flatMap(source, flatMappingOperation)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementsWithoutFirstArguments() throws Exception {
        final String[] toRemote = {};
        instance.removeElements(null, toRemote);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementsWithoutSecondArguments() throws Exception {
        final String[] source = {};
        instance.removeElements(source, null);
    }

    @Test
    public void testRemoveWithDifferentElements() throws Exception {
        final String[] source = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        final String[] toRemove = {
                "Two",
                "Four"
        };
        final String[] target = {
                "One",
                "Three"
        };
        assertArrayEquals("Error in remove elements operation",
                target,
                instance.removeElements(source, toRemove)
        );
    }

    @Test
    public void testRemoveWithEqualElements() throws Exception {
        final String[] source = {
                "One",
                "Two",
                "Three",
                "Four",
                "Two",
                "Two"
        };
        final String[] toRemove = {
                "Two",
                "Four"
        };
        final String[] target = {
                "One",
                "Three"
        };
        assertArrayEquals("Error in remove elements operation",
                target,
                instance.removeElements(source, toRemove)
        );
    }
}