package com.epam.geometry.model;

import com.epam.geometry.data.DataException;
import com.epam.geometry.logic.TriangleLogic;

public class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) throws DataException{
        if (!TriangleLogic.validateTriangle(a, b, c)) {
            throw new DataException("Wrong input data", new Throwable());
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.a != null ? this.a.hashCode() : 0);
        hash = 23 * hash + (this.b != null ? this.b.hashCode() : 0);
        hash = 23 * hash + (this.c != null ? this.c.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (this.a != other.a && (this.a == null || !this.a.equals(other.a))) {
            return false;
        }
        if (this.b != other.b && (this.b == null || !this.b.equals(other.b))) {
            return false;
        }
        if (this.c != other.c && (this.c == null || !this.c.equals(other.c))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Triangle (a = " + a + ", b = " + b + ", c = " + c + ")";
    }

}
