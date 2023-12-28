/* Write a Java program to define an interface Compute with an abstract method Convert. Define two classes 
 * which implement this Compute interface and extend the Convert method to convert kilobytes to gigabytes
 * and Euro to Rupees. Declare objects for both the classes and demonstrate the conversions from kilobytes to gigabytes
 * and Euro to Rupees.
 */
import java.util.Scanner;

interface Compute{
    double convert(double value);
}

class ByteConversion implements Compute{
    public double convert(double kilobytes) {
        return kilobytes / (1024.0 * 1024.0);
    }
}

class RupeeConversion implements Compute {
    public double convert(double euros) {
        return euros * 85.0;
    }
}


public class Interfaces {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);

      ByteConversion ob1 = new ByteConversion();
      System.out.println("Enter the number of kilobytes to be converted to gigabytes:");
      double kb = scanner.nextDouble();
      double gb = ob1.convert(kb);
      System.out.println("Required value in gigabytes: "+gb);

      RupeeConversion ob2 = new RupeeConversion();
      System.out.println("Enter the amount in Euros to be converted to Rupees:");
      double euro = scanner.nextDouble();
      double rupee = ob2.convert(euro);
      System.out.println("Required value in Rupees: "+rupee);

      
    }
    
}
