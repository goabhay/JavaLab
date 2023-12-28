import java.util.Scanner;

class Employee {
    public String name;
    public int employeeId;
    public String department;
    public int age;
    public String designation;
    public double salary;

    public Employee(String name, int employeeId, String department, int age, String designation, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + ", Employee ID: " + employeeId + ", Department: " + department +
                ", Age: " + age + ", Designation: " + designation + ", Salary: " + salary;
    }
}

public class EmployeeDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[3];

      
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Designation: ");
            String designation = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); 

            employees[i] = new Employee(name, employeeId, department, age, designation, salary);
        }

        
        System.out.println("Employee Details:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.print("Enter the department to calculate the sum of salaries: ");
        String targetDepartment = scanner.nextLine();
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee.department.equalsIgnoreCase(targetDepartment)) {
                totalSalary += employee.salary;
            }
        }
        System.out.println("Total salary of " + targetDepartment + " department: " + totalSalary);

        
        double highestSalary = 0;
        Employee highestPaidManager = null;
        for (Employee employee : employees) {
            if (employee.department.equalsIgnoreCase("Purchase")  && employee.designation.equalsIgnoreCase("Manager")
                    && employee.salary >= highestSalary) {
                highestSalary = employee.salary;
                highestPaidManager = employee;
            }
        }
        if (highestPaidManager != null)  System.out.println("Highest paid manager in the Purchase Department: " + highestPaidManager);
        else System.out.println("No manager found in the Purchase Department.");
        
     System.out.println("Hiking the salaries of all the Employees of 'Sales' Department by 10%");
     for(int i=0; i<3; i++){
        if(employees[i].department.equalsIgnoreCase("Sales")){
            employees[i].salary+=employees[i].salary*0.10;
            System.out.println("New Salary of Employee "+(i+1)+" is "+employees[i].salary);
        }
     }
    
    }
}

