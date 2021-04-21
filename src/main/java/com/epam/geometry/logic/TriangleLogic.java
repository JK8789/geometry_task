package com.epam.geometry.logic;

import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleLogic {

    private static final Logger LOGGER = LogManager.getLogger();

    public static boolean validateTriangle(Point a, Point b, Point c) {
        double x1 = a.getX();
        double x2 = b.getX();
        double x3 = c.getX();
        double y1 = a.getY();
        double y2 = b.getY();
        double y3 = c.getY();
        if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3) || (x1 == x3 && y1 == y3)) {
            LOGGER.error("Vertices of the triangle is the same point");
            return false;
        }
        double t = ((x1 - x2) * (y2 - y3) - (y1 - y2) * (x2 - x3)) / ((x1 - x2) * (y2 - y3) - (y1 - y2) * (x2 - x3));
        double u = ((x2 - x1) * (y1 - y2) - (y2 - y1) * (x1 - x2)) / ((x1 - x2) * (y2 - y3) - (y1 - y2) * (x2 - x3));
        double dseg1 = (x1 - x2) / (y1 - y2);
        double dseg2 = (x2 - x3) / (y2 - y3);
        if ((dseg1) == (dseg2)) {
            LOGGER.error("Exception because such a triangle would be degenerative");
            return false;
        }
        if (t < 0 || t > 1 || u < 0 || u > 1) {
            LOGGER.error("Exception because such a triangle would be degenerative");
            return false;
        }
        return true;
    }

    public enum TypesOfTriangle {
        Equilateral, Isosceles, Rectangular, Acute, Obtuse
    };

    public static List<TypesOfTriangle> defineTypeOfTriangle(Triangle triangle) {
        List<TypesOfTriangle> result = new ArrayList<>();
        double lengthA = getLength(triangle.getA(), triangle.getB());
        double lengthB = getLength(triangle.getB(), triangle.getC());
        double lengthC = getLength(triangle.getC(), triangle.getA());
        if (lengthA == lengthB && lengthA == lengthC) {
            result.add(TypesOfTriangle.Equilateral);
        }
        if (lengthA == lengthB || lengthA == lengthC || lengthB == lengthC) {
            result.add(TypesOfTriangle.Isosceles);
        }
        if (checkRectangular(lengthA, lengthB, lengthC)) {
            result.add(TypesOfTriangle.Rectangular);
        }
        if (checkAcute(lengthA, lengthB, lengthC)) {
            result.add(TypesOfTriangle.Acute);
        }
        if (checkObtuse(lengthA, lengthB, lengthC)) {
            result.add(TypesOfTriangle.Obtuse);
        }

        return result;
    }

    public static boolean checkRectangular(double a, double b, double c) {
        if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkAcute(double a, double b, double c) {
        if ((a * a + b * b > c * c) && (a * a + c * c > b * b) && (b * b + c * c > a * a)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkObtuse(double a, double b, double c) {
        if ((a * a + b * b < c * c) || (a * a + c * c < b * b) || (b * b + c * c < a * a)) {
            return true;
        } else {
            return false;
        }
    }

    public static double getLength(Point a, Point b) {

        double sqra = (b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY());
        if (sqra < 0) {
            throw new IllegalArgumentException();
        }
        double lengthOfSide = sqrt(sqra);
        return lengthOfSide;
    }

    public static double calculateTriangPerimeter(Triangle triangle) {
        double lengthA = getLength(triangle.getA(), triangle.getB());
        double lengthB = getLength(triangle.getB(), triangle.getC());
        double lengthC = getLength(triangle.getC(), triangle.getA());
        double perimeter = lengthA + lengthB + lengthC;
        LOGGER.info("Triangle perimeter is " + perimeter);
        return perimeter;
    }

    public static double calculateTriangArea(Triangle triangle) {
        double lengthA = getLength(triangle.getA(), triangle.getB());
        double lengthB = getLength(triangle.getB(), triangle.getC());
        double lengthC = getLength(triangle.getC(), triangle.getA());
        if ((lengthA + lengthB) > lengthC && (lengthA + lengthC) > lengthB && (lengthB + lengthC) > lengthA) {
            double s = (lengthA + lengthB + lengthC) / 2;
            double area = Math.sqrt(s * (s - lengthA) * (s - lengthB) * (s - lengthC));
            LOGGER.info("Triangle area is " + area);
            return area;
        } else {
            throw new IllegalArgumentException("Area of Triangle not exist");
        }
        //return area;
    }
}
