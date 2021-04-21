package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.logic.TriangleLogic;
import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Director {

    public static final String TEXT_DATA = "file.txt";

    private final DataReader reader;
    private final TriangleDataValidator validator;
    private final TriangleCreator creator;

    public Director(DataReader reader, TriangleDataValidator validator, TriangleCreator creator) {
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }
    private static final Logger LOGGER = LogManager.getLogger();

    public List<Triangle> process(String filename) throws DataException {

        List<Triangle> triangles = new ArrayList<>();
        List<String> lines = reader.readLines(filename);
        for (String line : lines) {
            if (validator.validate(line)) {
                String[] splited = line.split("\\s+");
                Point a = new Point(Double.parseDouble(splited[0]), Double.parseDouble(splited[1]));
                Point b = new Point(Double.parseDouble(splited[2]), Double.parseDouble(splited[3]));
                Point c = new Point(Double.parseDouble(splited[4]), Double.parseDouble(splited[5]));
                try {
                    Triangle triangle = creator.createTriangle(a, b, c);
                    List<TriangleLogic.TypesOfTriangle> types = TriangleLogic.defineTypeOfTriangle(triangle);
                    LOGGER.info("Triangle properties: " + types);
                    triangles.add(triangle);

                } catch (DataException e) {
                    LOGGER.error("Wrong input data: '" + line + "'.");

                }
            }
        }
        return triangles;
    }
}
