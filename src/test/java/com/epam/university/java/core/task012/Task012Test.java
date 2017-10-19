package com.epam.university.java.core.task012;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task012Test {
    private GraphFactory factory;
    private Task012 instance;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(GraphFactory.class);
        instance = TestHelper.getInstance(Task012.class);
    }

    @Test
    public void createGraphAndAddVertexes() throws Exception {
        final Graph sourceGraph = factory.newInstance(4);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(4, 1),
            g -> g.createEdge(1, 3),
            g -> g.createEdge(2, 4)
        ));
        assertTrue("There is no edge between vertexes", targetGraph.edgeExists(2, 1));
        assertTrue("There is no edge between vertexes", targetGraph.edgeExists(3, 2));
        assertTrue("There is no edge between vertexes", targetGraph.edgeExists(3, 1));
    }

    @Test
    public void createGraphAddAndRemoveVertexes() throws Exception {
        final Graph sourceGraph = factory.newInstance(4);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(4, 1),
            g -> g.createEdge(1, 3),
            g -> g.createEdge(2, 4),
            g -> g.removeEdge(1, 3),
            g -> g.removeEdge(2, 4)
        ));
        assertTrue("There is not edge between vertexes", targetGraph.edgeExists(2, 1));
        assertTrue("There is not edge between vertexes", targetGraph.edgeExists(3, 2));
        assertFalse("There is edge between vertexes", targetGraph.edgeExists(3, 1));
        assertFalse("There is edge between vertexes", targetGraph.edgeExists(4, 2));
    }

    @Test
    public void testPathCalculationFirst() throws Exception {
        final Graph sourceGraph = factory.newInstance(5);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(4, 5),
            g -> g.createEdge(5, 1),
            g -> g.removeEdge(1, 2)
        ));
        assertTrue("There is path between vertexes",
                instance.pathExists(targetGraph, 1, 2));
    }

    @Test
    public void testPathCalculationSecond() throws Exception {
        final Graph sourceGraph = factory.newInstance(5);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(4, 5),
            g -> g.createEdge(5, 1),
            g -> g.removeEdge(1, 2),
            g -> g.removeEdge(5, 4)
        ));
        assertFalse("There is no path between vertexes",
            instance.pathExists(targetGraph, 1, 2));
        assertTrue("There is path between vertexes",
            instance.pathExists(targetGraph, 2, 4));
    }

    @Test
    public void testPathCalculationCyclicGraph() throws Exception {
        final Graph sourceGraph = factory.newInstance(6);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(1, 3),
            g -> g.createEdge(1, 4),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(2, 4),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(5, 6)
        ));
        assertFalse("There is no path between vertexes",
            instance.pathExists(targetGraph, 1, 6));
        assertFalse("There is no path between vertexes",
            instance.pathExists(targetGraph, 1, 5));
        assertTrue("There is path between vertexes",
            instance.pathExists(targetGraph, 2, 4));
    }

    @Test
    public void testPathCalculationDisconnectedGraph() throws Exception {
        final Graph sourceGraph = factory.newInstance(9);
        final Graph targetGraph = instance.invokeActions(sourceGraph, Arrays.asList(
            g -> g.createEdge(1, 2),
            g -> g.createEdge(2, 3),
            g -> g.createEdge(3, 4),
            g -> g.createEdge(4, 8),
            g -> g.createEdge(1, 5),
            g -> g.createEdge(6, 1),
            g -> g.createEdge(6, 7),
            g -> g.createEdge(7, 8),
            g -> g.createEdge(9, 1),
            g -> g.removeEdge(8, 4),
            g -> g.removeEdge(1, 2)
        ));
        assertFalse("There is no path between vertexes",
                instance.pathExists(targetGraph, 4, 9));
    }
}