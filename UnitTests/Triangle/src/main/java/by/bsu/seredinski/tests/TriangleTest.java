package by.bsu.seredinski.tests;

import by.bsu.seredinski.triangle.Triangle;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TriangleTest {

    @DataProvider
    public static Object[][] triangleZeroSides() {
        return new Object[][]{
                {0, 4, 5},
                {3, 0, 5},
                {3, 4, 0}
        };
    }

    @DataProvider
    public static Object[][] sidesNotValid() {
        return new Object[][]{
                {3, 4, 15},
                {3, 14, 5},
                {13, 4, 5}
        };
    }
    @DataProvider
    public static Object[][] sidesIsNotPositive() {
        return new Object[][]{
                {3, 4, -5},
                {3, -4, 5},
                {-3, 4, 5}
        };
    }

    @Test
    @UseDataProvider("sidesNotValid")
    public void isFalseWhenSidesIsNotValid(double a, double b, double c) {
        Assert.assertFalse(Triangle.buildTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("triangleZeroSides")
    public void isFalseWhenZeroSides(double a, double b, double c) {
        Assert.assertFalse(Triangle.buildTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("sidesIsNotPositive")
    public void isFalseWhenSidesIsNotPositive(double a, double b, double c) {
        Assert.assertFalse(Triangle.buildTriangle(a,b,c));
    }

    @Test
    public void isTrueWhenSidesAreEqual() {
        Assert.assertTrue(Triangle.buildTriangle(3, 3, 3));
    }

    @Test
    public void isTrueWhenTwoSidesAreEqual() {
        Assert.assertTrue(Triangle.buildTriangle(3, 3, 4));
    }

    @Test
    public void isFalseWhenSumOfTwoAreEqualThird() {
        Assert.assertFalse(Triangle.buildTriangle(3, 4, 7));
    }

    @Test
    public void isEquilateralWhenSidesAreEqual() {
        Assert.assertEquals("Equilateral", Triangle.typeOfTriangle(3, 3, 3));
    }

    @Test
    public void isIsoscelesWhenTwoSidesAreEqual() {
        Assert.assertEquals("Isosceles", Triangle.typeOfTriangle(4, 4, 5));
    }

    @Test
    public void isRightWhenTheoremOfPythagoras() {
        Assert.assertEquals("Right", Triangle.typeOfTriangle(3, 4, 5));
    }

}
