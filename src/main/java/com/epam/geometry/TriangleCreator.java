package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();

    public Triangle createTriangle(Point a, Point b, Point c) throws DataException{
        Triangle triangle = new Triangle(a, b, c);
        LOGGER.info("Triangle is created");
        return triangle;
    }
}
