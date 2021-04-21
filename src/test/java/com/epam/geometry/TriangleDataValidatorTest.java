package com.epam.geometry;

import org.junit.Assert;
import org.junit.Test;

public class TriangleDataValidatorTest {
    @Test
    public void testCreatorWrongInputData() {
        TriangleDataValidator dataValidator = new TriangleDataValidator();
        boolean actual = dataValidator.validate("5a.9 6.0 3.0 10.0 3.2 5.0");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCreatorWrongInput() {
        TriangleDataValidator dataValidator = new TriangleDataValidator();
        boolean actual = dataValidator.validate("4.3 3.5 5.7 7.0m 0f.8");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testCreatorWrongData() {
        TriangleDataValidator dataValidator = new TriangleDataValidator();
        boolean actual = dataValidator.validate("-3.0 1.0 0.0 1.0");
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
}
