/* Lab 5 - Write a Java program to perform different operations on complex numbers, namely 
 * Addition,
 *  Subtraction, 
 * Increment 
 * and Decrement. Use Constructors and create separate 
 * functions for doing these operations.
 */

import java.util.Scanner;
class Complex{
   protected int real;
   protected int imaginary;

   public Complex(){
     this.real = 0;
     this.imaginary = 0;
   }

   public Complex(int r, int i){
     this.real = r;
     this.imaginary = i;
   }
   public void display(){
    System.out.println("Real part : "+this.real);
    System.out.println("Imaginary part : "+this.imaginary);

   }
   public Complex addComplex(Complex c2){
    Complex c3 = new Complex();
    c3.real = this.real + c2.real;
    c3.imaginary = this.imaginary + c2.imaginary;
    return c3;
   }
    public Complex subComplex(Complex c2){
    Complex c3 = new Complex();
    c3.real = this.real - c2.real;
    c3.imaginary = this.imaginary - c2.imaginary;
    return c3;
   }
    public void increment(){
   this.real++;
   this.imaginary++;
   }
   public void decrement(){
    this.real--;
    this.imaginary--;
   }
}

public class ComplexNumbers {
     public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
    System.out.println("Enter the real and imaginary parts of both complex numbers");
    int r1 = scanner.nextInt();
    int i1 = scanner.nextInt();
    int r2 = scanner.nextInt();
    int i2 = scanner.nextInt();
    Complex c1 = new Complex(r1, i1);
    Complex c2 = new Complex(r2, i2);
    while(true){
    System.out.println("Enter your choice :\n(1) Add two complex numbers\n(2) Subtract two complex numbers\n(3) Increment\n(4) Decrement\n(5) Exit");
    int choice = scanner.nextInt();
    switch (choice){
        case 1: {  Complex c3 = c1.addComplex(c2);
                   c3.display();
                   break;
        }
        case 2: {  Complex c3 = c1.subComplex(c2);
                  c3.display();
                  break;
        }
        case 3: {
            c1.increment();
            c1.display();
            break;
        }
        case 4: {
            c1.decrement();
            c1.display();
            break;
        }
        case 5: {
            System.exit(0); 
        }
        default: System.out.println("Invalid Choice");
    }

    }

}
}
