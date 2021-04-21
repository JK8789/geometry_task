package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class DirectorTest {

    private static final String file = "src/test/resources/file.txt";
    private static final List<String> InputData = Arrays.asList("0.0 0.0 1.0 1.0 0.0 1.0",
            "0.0 0.0 1.0 1.0 2.0 0.0",
            "-3.0 1.0 0.0 1.0",
            "0.0 0.0 0.0 2.0 0.0 5.0",
            "0.0 0.0 0.0 0.0 0.0 5.0",
            "0.0 1.0 0.0 4.0 3.0 0.0",
            "5a.9 6.0 3.0 10.0 3.2 5.0",
            "8.0 2.0 1.0 2.0 -2.0 -8.0",
            "4.3 3.5 5.7 7.0m 0f.8");

    @Test
    public void processTest() throws DataException {

        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readLines(anyString())).thenReturn(InputData);

        TriangleDataValidator validator = Mockito.mock(TriangleDataValidator.class);
        when(validator.validate("0.0 0.0 1.0 1.0 0.0 1.0")).thenReturn(true);
        when(validator.validate("0.0 0.0 1.0 1.0 2.0 0.0")).thenReturn(true);
        when(validator.validate("-3.0 1.0 0.0 1.0")).thenReturn(false);
        when(validator.validate("0.0 0.0 0.0 2.0 0.0 5.0")).thenReturn(false);
        when(validator.validate("0.0 0.0 0.0 0.0 0.0 5.0")).thenReturn(false);
        when(validator.validate("0.0 1.0 0.0 4.0 3.0 0.0")).thenReturn(true);
        when(validator.validate("5a.9 6.0 3.0 10.0 3.2 5.0")).thenReturn(false);
        when(validator.validate("8.0 2.0 1.0 2.0 -2.0 -8.0")).thenReturn(true);
        when(validator.validate("4.3 3.5 5.7 7.0m 0f.8")).thenReturn(false);

        TriangleCreator creator = Mockito.mock(TriangleCreator.class);
        when(creator.createTriangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(0.0, 1.0))).thenReturn
        (new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(0.0, 1.0)));
        when(creator.createTriangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(2.0, 0.0))).thenReturn
        (new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(2.0, 0.0)));
        when(creator.createTriangle(new Point(0.0, 1.0), new Point(0.0, 4.0), new Point(3.0, 0.0))).thenReturn
        (new Triangle(new Point(0.0, 1.0), new Point(0.0, 4.0), new Point(3.0, 0.0)));
        when(creator.createTriangle(new Point(8.0, 2.0), new Point(1.0, 2.0), new Point(-2.0, -8.0))).thenReturn
        (new Triangle(new Point(8.0, 2.0), new Point(1.0, 2.0), new Point(-2.0, -8.0)));
        
        
        Director director = new Director(reader, validator, creator);
        List<Triangle> actualTriangles = director.process(file);
        List<Triangle> expectedTriangle = Arrays.asList
           (new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(0.0, 1.0)),                   
            new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(2.0, 0.0)),
            new Triangle(new Point(0.0, 1.0), new Point(0.0, 4.0), new Point(3.0, 0.0)),
            new Triangle(new Point(8.0, 2.0), new Point(1.0, 2.0), new Point(-2.0, -8.0)));
    
        Assert.assertEquals(expectedTriangle, actualTriangles);
    }
}
