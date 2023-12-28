/* Lab 6 - Write a program in Java for Exception Handling.
 It should accept two integers, if the integers are negative it should handle 
 the exception. Again, divide the two integers with each other. 
 If the denominator is 0, handle the exception. Use try, catch, throw and also finally keywords.

 */
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator : ");
            int numerator = scanner.nextInt();

            System.out.print("Enter the denominator : ");
            int denominator = scanner.nextInt();

            if (numerator < 0 || denominator < 0) {
                throw new IllegalArgumentException();
            }
           
            if (denominator == 0) {
                throw new ArithmeticException();
            }

            int result = numerator / denominator;
            System.out.println("Result of division: " + result);
        } 
       catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: Both the numbers should be non-negative" );
        }
       catch (ArithmeticException e) {
            System.out.println("ArithmeticException: Cannot divide by zero");
        } 
       finally {
            System.out.println("Program execution complete.");
        }
    }
}
