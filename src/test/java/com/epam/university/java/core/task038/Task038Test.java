package com.epam.university.java.core.task038;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task013.Figure;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task038Test {
    private GraphFactory factory;
    private Task038 instance;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(GraphFactory.class);
        instance = TestHelper.getInstance(Task038.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullFigure() throws Exception {
        instance.invokeActions(null, Arrays.asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullActions() throws Exception {
        final Graph sourceGraph = factory.newInstance(3);
        instance.invokeActions(sourceGraph, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyActions() throws Exception {
        final Graph sourceGraph = factory.newInstance(3);
        instance.invokeActions(sourceGraph, Arrays.asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullGraph() throws Exception {
        instance.getShortestPath(null, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTooManyVertexes() throws Exception {
        final Graph sourceGraph = factory.newInstance(3);
        instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createVertex(0, 0, 1),
            g -> g.createVertex(1, 2, 2),
            g -> g.createVertex(2, 0, 1),
            g -> g.createVertex(3, 0, 4))
        );
    }

    @Test
    public void getShortestPath() {
        Graph sourceGraph = factory.newInstance(5);
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createVertex(0, 1, 1),
            g -> g.createVertex(1, 2, 5),
            g -> g.createVertex(2, 3, 4),
            g -> g.createVertex(3, 8, 8),
            g -> g.createVertex(4, 0, 39),
            g -> g.connectVertices(0, 1),
            g -> g.connectVertices(0, 2),
            g -> g.connectVertices(0, 4),
            g -> g.connectVertices(2, 3),
            g -> g.connectVertices(1, 4),
            g -> g.connectVertices(3, 4)
        ));
        PathInfo path1 = new PathInfo(instance.getShortestPath(sourceGraph, 0, 3));
        PathInfo path2 = new PathInfo(instance.getShortestPath(sourceGraph, 0, 4));
        PathInfo path3 = new PathInfo(instance.getShortestPath(sourceGraph, 0, 2));
        assertEquals("Incorrect path", 10, path1.calculateDistance());
        assertEquals("Incorrect path", 38, path2.calculateDistance());
        assertEquals("Incorrect path", 3, path3.calculateDistance());
    }

    @Test
    public void getShortestPathNotExist() {
        Graph sourceGraph = factory.newInstance(5);
        sourceGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createVertex(0, 1, 1),
            g -> g.createVertex(1, 2, 5),
            g -> g.createVertex(2, 3, 4),
            g -> g.createVertex(3, 8, 8),
            g -> g.createVertex(4, 0, 39),
            g -> g.connectVertices(0, 1),
            g -> g.connectVertices(0, 2),
            g -> g.connectVertices(0, 4),
            g -> g.connectVertices(2, 3),
            g -> g.connectVertices(1, 4),
            g -> g.connectVertices(3, 4)
        ));
        PathInfo path1 = new PathInfo(instance.getShortestPath(sourceGraph, 3, 1));
        PathInfo path2 = new PathInfo(instance.getShortestPath(sourceGraph, 1, 0));
        PathInfo path3 = new PathInfo(instance.getShortestPath(sourceGraph, 4, 0));

        assertFalse("Path doesn't exist", path1.isExist());
        assertFalse("Path doesn't exist", path2.isExist());
        assertFalse("Path doesn't exist", path3.isExist());
    }

}