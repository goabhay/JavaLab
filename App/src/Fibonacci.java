/*Write a Java program to find Fibonacci Series using recursive and non-recursive functions. */
import java.util.Scanner;
public class Fibonacci{
    static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
    static int fibonacciNonRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 0, a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Series using recursion:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }

        System.out.println(); 

        System.out.println("Fibonacci Series using iteration:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciNonRecursive(i) + " ");
        }
    }
}
