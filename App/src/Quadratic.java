/*Wrie a Java program that prints all the real solutions to the quadratic equation
 ax^2+bx+c = 0
 Read a, b and c from the user. 
 
 */

import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter the coefficient a:");
        double a = scanner.nextDouble();

        System.out.println("Enter the coefficient b:");
        double b = scanner.nextDouble();

        System.out.println("Enter the coefficient c:");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("The equation has two real and distinct roots:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {            double root = -b / (2 * a);

            System.out.println("The equation has one real root (double root):");
            System.out.println("Root: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(Math.abs(discriminant)) / (2 * a);

            System.out.println("The equation has no real roots (complex roots):");
            System.out.println("Root 1: " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2: " + realPart + " - " + imaginaryPart + "i");
        }
    }
}

