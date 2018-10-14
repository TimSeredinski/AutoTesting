package by.bsu.seredinski.triangle;

public class Triangle {

    public static boolean buildTriangle(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        return a + b > c && a + c > b && b + c > a;
    }

    public static String typeOfTriangle(double a, double b, double c) {

        if (a == b && a == c && b == c) {
            return "Equilateral";
        }
        if (a == b || b == c || a == c) {
            return "Isosceles";
        }
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            return "Right";
        }

        return "Simple";

    }
}
