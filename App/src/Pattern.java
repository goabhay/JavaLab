import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); // Two spaces for better formatting
            }

            // Print numbers in ascending order
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            System.out.println(); // Move to the next line for the next row
        }
    }
}

