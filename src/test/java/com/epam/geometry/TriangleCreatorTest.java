package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleCreatorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreatorSamePoint() throws DataException {
        exception.expect(DataException.class);
        TriangleCreator creator = new TriangleCreator();
        Triangle actualTriangle = creator.createTriangle(new Point(0.0, 0.0), new Point(0.0, 0.0), new Point(0.0, 5.0));
        
    }
    @Test
    public void testCreatorDegenerativeTriangle() throws DataException {
        exception.expect(DataException.class);
        TriangleCreator creator = new TriangleCreator();
        Triangle actualTriangle = creator.createTriangle(new Point(0.0, 0.0), new Point(0.0, 2.0), new Point(0.0, 5.0));
        
    }
}
