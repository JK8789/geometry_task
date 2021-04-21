package com.epam.geometry.logic;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TriangleLogicTest {

    @Test
    public void testDefineTypeOfTriangle() throws DataException {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(0.0, 1.0));
        List<TriangleLogic.TypesOfTriangle> actual = TriangleLogic.defineTypeOfTriangle(triangle);
        Assert.assertTrue(actual.contains(TriangleLogic.TypesOfTriangle.Isosceles));
        Assert.assertTrue(actual.contains(TriangleLogic.TypesOfTriangle.Obtuse));
        Assert.assertEquals(actual.size(), 2);

    }

    @Test
    public void testDefineTypeTriangle() throws DataException {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(2.0, 0.0));
        List<TriangleLogic.TypesOfTriangle> actual = TriangleLogic.defineTypeOfTriangle(triangle);
        Assert.assertTrue(actual.contains(TriangleLogic.TypesOfTriangle.Isosceles));
        Assert.assertTrue(actual.contains(TriangleLogic.TypesOfTriangle.Acute));
        Assert.assertEquals(actual.size(), 2);
    }

    @Test
    public void calculateTriangArea() throws DataException {
        Triangle triangle = new Triangle(new Point(8.0, 2.0), new Point(1.0, 2.0), new Point(-2.0, -8.0));
        double actual = TriangleLogic.calculateTriangArea(triangle);
        Assert.assertEquals(35.0, actual, 0.001);
    }

    @Test
    public void calculateTriangPerimeter() throws DataException {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(0.0, 1.0));
        double actual = TriangleLogic.calculateTriangPerimeter(triangle);
        Assert.assertEquals(3.414, actual, 0.001);
        //0.0 0.0 1.0 1.0 0.0 1.0
    }
}
