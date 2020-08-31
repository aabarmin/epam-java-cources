package com.epam.university.java.core.task013;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task013Test {
    private FigureFactory factory;
    private Task013 instance;

    @Before
    public void setUp() throws Exception {
        factory = TestHelper.getInstance(FigureFactory.class);
        instance = TestHelper.getInstance(Task013.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lessThanThreeVertexes() throws Exception {
        factory.newInstance(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullFigure() throws Exception {
        instance.invokeActions(null, Arrays.asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullActions() throws Exception {
        final Figure sourceFigure = factory.newInstance(3);
        instance.invokeActions(sourceFigure, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyActions() throws Exception {
        final Figure sourceFigure = factory.newInstance(3);
        instance.invokeActions(sourceFigure, Arrays.asList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkingConvexPolygonWithNullFigure() throws Exception {
        instance.isConvexPolygon(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTooManyVertexes() throws Exception {
        final Figure sourceFigure = factory.newInstance(3);
        instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(0, 2)),
            f -> f.addVertex(factory.newInstance(2, 0)),
            f -> f.addVertex(factory.newInstance(1, 0))
        ));
    }

    @Test
    public void testWithTriangle() throws Exception {
        final Figure sourceFigure = factory.newInstance(3);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(0, 2)),
            f -> f.addVertex(factory.newInstance(2, 0))
        ));
        assertTrue("Figure is convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

    @Test
    public void testWithSquare() throws Exception {
        final Figure sourceFigure = factory.newInstance(4);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(0, 2)),
            f -> f.addVertex(factory.newInstance(2, 0)),
            f -> f.addVertex(factory.newInstance(2, 2))
        ));
        assertTrue("Figure is convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

    @Test
    public void testWithStar() throws Exception {
        final Figure sourceFigure = factory.newInstance(5);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(2, 3)),
            f -> f.addVertex(factory.newInstance(4, 0)),
            f -> f.addVertex(factory.newInstance(0, 2)),
            f -> f.addVertex(factory.newInstance(4, 2))
        ));
        assertTrue("Figure is convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

    @Test

    public void testWithPentagon() throws Exception {
        final Figure sourceFigure = factory.newInstance(5);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(0, 4)),
            f -> f.addVertex(factory.newInstance(3, 6)),
            f -> f.addVertex(factory.newInstance(6, 0)),
            f -> f.addVertex(factory.newInstance(6, 4))

        ));
        assertTrue("Figure is convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

    @Test
    public void testWithOctagon() throws Exception {
        final Figure sourceFigure = factory.newInstance(8);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 4)),
            f -> f.addVertex(factory.newInstance(0, 2)),
            f -> f.addVertex(factory.newInstance(2, 0)),
            f -> f.addVertex(factory.newInstance(2, 6)),
            f -> f.addVertex(factory.newInstance(4, 6)),
            f -> f.addVertex(factory.newInstance(6, 2)),
            f -> f.addVertex(factory.newInstance(4, 0)),
            f -> f.addVertex(factory.newInstance(6, 4))

        ));
        assertTrue("Figure is convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

    @Test

    public void testWithWrongFigure() throws Exception {
        final Figure sourceFigure = factory.newInstance(5);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(0, 3)),
            f -> f.addVertex(factory.newInstance(2, 2)),
            f -> f.addVertex(factory.newInstance(4, 3)),
            f -> f.addVertex(factory.newInstance(4, 0))
        ));
        assertFalse("Figure is not a convex polygon", instance.isConvexPolygon(modifiedFigure));
    }


    @Test
    public void testWithWrongFigure2() throws Exception {
        final Figure sourceFigure = factory.newInstance(6);
        final Figure modifiedFigure = instance.invokeActions(sourceFigure, Arrays.asList(
            f -> f.addVertex(factory.newInstance(1, 2)),
            f -> f.addVertex(factory.newInstance(0, 4)),
            f -> f.addVertex(factory.newInstance(3, 2)),
            f -> f.addVertex(factory.newInstance(4, 4)),
            f -> f.addVertex(factory.newInstance(0, 0)),
            f -> f.addVertex(factory.newInstance(4, 0))
        ));
        assertFalse("Figure is not a convex polygon", instance.isConvexPolygon(modifiedFigure));
    }

}
