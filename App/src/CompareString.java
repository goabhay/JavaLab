/* Write a Java program using compile time polymorphism (function overloading).
 * The program contains two functions, one that takes two strings and compares them.
 * The other function takes two strings and the number of characters to be compared.
 */
import java.util.Scanner;

public class CompareString {

    public static boolean compareStrings(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean compareStrings(String str1, String str2, int numCharacters) {
        if (numCharacters <= 0) {
            System.out.println("Invalid number of characters for comparison.");
            return false;
        }

        String substring1 = str1.substring(0, Math.min(numCharacters, str1.length()));
        String substring2 = str2.substring(0, Math.min(numCharacters, str2.length()));
        return substring1.equals(substring2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String string1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String string2 = scanner.nextLine();

        boolean result;

        System.out.println("Enter your choice:\n(1) Compare two strings fully\n(2) Compare two strings for a given number of characters\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                result = compareStrings(string1, string2);
                break;
            case 2:
                System.out.println("Enter the number of characters to be compared:");
                int n = scanner.nextInt();
                result = compareStrings(string1, string2, n);
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }

        System.out.println("Are the two strings the same: " + result);
    }
}
