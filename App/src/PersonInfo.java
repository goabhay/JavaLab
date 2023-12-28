/*   */

import java.util.Scanner;

class Person {
    public String name;
    public int age;
    public String gender;
    public String country;

     public Person() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.country = null;
    }

    public Person(String name, int age, String gender, String country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Country: " + country);
    }
}

class Employee extends Person {
    public int employeeId;
    public String department;
    public double salary;


 public Employee() {
        //super(name, age, gender, country);
        this.employeeId = 0;
        this.department = null;
        this.salary = 0;
 }
    public Employee(String name, int age, String gender, String country, int employeeId, String department, double salary) {
        super(name, age, gender, country);
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayDetails();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Student extends Person {
    public int studentId;
    public String major;

      public Student() {
        //super(name, age, gender, country);
        this.studentId = 0;
        this.major = null;
    }

    public Student(String name, int age, String gender, String country, int studentId, String major) {
        super(name, age, gender, country);
        this.studentId = studentId;
        this.major = major;
    }

    public void displayStudentDetails() {
        displayDetails();
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Major: " + this.major);
    }
}

public class PersonInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[5];
        Student[] students = new Student[5];

        System.out.println("Enter Employee Details:");
        for (int i = 0; i < 5; i++) {
            employees[i] = new Employee();
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Country: ");
            String country = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Employee ID: ");
            int employeeId = scanner.nextInt();
           // scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
           employees[i] = new Employee(name, age, gender, country, employeeId, department, salary);
        }

        System.out.println("Enter Student Details:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Country: ");
            String country = scanner.nextLine();
            System.out.print("Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Major: ");
            String major = scanner.nextLine();

            students[i] = new Student(name, age, gender, country, studentId, major);
        }

        System.out.println("Employee Details:");
        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
            System.out.println();
        }

        System.out.println("Student Details:");
        for (Student student : students) {
            student.displayStudentDetails();
            System.out.println();
        }
        scanner.close();
    }
}
