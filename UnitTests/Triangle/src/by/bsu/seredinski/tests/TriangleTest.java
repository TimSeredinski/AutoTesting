package by.bsu.seredinski.tests;

import by.bsu.seredinski.triangle.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void isTrueWhenSidesIsValid() {
        Assert.assertTrue(Triangle.buildTriangle(3, 4, 6));
        Assert.assertEquals("Simple", Triangle.typeOfTriangle(3, 4, 6));
    }

    @Test
    public void isFalseWhenSidesIsNotValid() {
        Assert.assertFalse(Triangle.buildTriangle(3, 4, 15));
        Assert.assertFalse(Triangle.buildTriangle(13, 4, 5));
        Assert.assertFalse(Triangle.buildTriangle(3, 14, 5));
    }

    @Test
    public void isFalseWhenZeroSides() {
        Assert.assertFalse(Triangle.buildTriangle(0, 4, 5));
        Assert.assertFalse(Triangle.buildTriangle(3, 0, 5));
        Assert.assertFalse(Triangle.buildTriangle(3, 4, 0));
    }

    @Test
    public void isFalseWhenSidesIsNotPositive() {
        Assert.assertFalse(Triangle.buildTriangle(-3, 4, 5));
        Assert.assertFalse(Triangle.buildTriangle(3, -4, 5));
        Assert.assertFalse(Triangle.buildTriangle(3, 4, -5));
    }

    @Test
    public void isTrueWhenSidesAreEqual(){
        Assert.assertTrue(Triangle.buildTriangle(3,3,3));
    }

    @Test
    public void isTrueWhenTwoSidesAreEqual(){
        Assert.assertTrue(Triangle.buildTriangle(3,3,4));
    }

    @Test
    public void isFalseWhenSumOfTwoAreEqualThird(){
        Assert.assertFalse(Triangle.buildTriangle(3, 4, 7));
    }

    @Test
    public void isEquilateralWhenSidesAreEqual(){
        Assert.assertEquals("Equilateral", Triangle.typeOfTriangle(3, 3, 3));
    }

    @Test
    public void isIsoscelesWhenTwoSidesAreEqual(){
        Assert.assertEquals("Isosceles", Triangle.typeOfTriangle(4, 4, 5));
    }

    @Test
    public void isRightWhenTheoremOfPythagoras(){
        Assert.assertEquals("Right", Triangle.typeOfTriangle(3, 4, 5));
    }

}
