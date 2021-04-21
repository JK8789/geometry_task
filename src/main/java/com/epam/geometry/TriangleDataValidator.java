package com.epam.geometry;

public class TriangleDataValidator {

    private static final String TRIANGLE_PATTERN = "[+-]?([0-9]*[.])?[0-9]+\\s[+-]?([0-9]*[.])?[0-9]+\\s"
            + "[+-]?([0-9]*[.])?[0-9]+\\s[+-]?([0-9]*[.])?[0-9]+\\s"
            + "[+-]?([0-9]*[.])?[0-9]+\\s[+-]?([0-9]*[.])?[0-9]+\\s";    

    public boolean validate(String line) {
        return line != null && line.matches(TRIANGLE_PATTERN);
    }
}
