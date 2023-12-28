/* Write a Java program to define a base class called Bank which holds various details of cutomers such as name,
Account Number, Balance, and member functions to read, display and calculate the rate of interest earned by all the 
account holders. Derive three new classes namely, City Bank, SBI Bank and Canara Bank from this base class
which are offering different rates of interest. Extend the calculate method of base class within these derived classes
to calculate and display the interest earned by different account holders of these banks.

Modification - Calculate the highest interest customer for a given bank.*/

import java.util.Scanner;

class Bank {
    protected String name;
    protected long accountNumber;
    protected double balance;
    public int year;

    public void readDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        this.name = scanner.nextLine();
        System.out.println("Enter Account Number:");
        this.accountNumber = scanner.nextLong();
        System.out.println("Enter Balance:");
        this.balance = scanner.nextDouble();
        System.out.println("Enter the year");
        this.year=scanner.nextInt();
    }

    public void displayDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Year: "+year);
    }

    public void calculateInterest() {
        System.out.println("Interest Calculation: Base Class");
    }
}

class CityBank extends Bank {
    private double interestRate;

    public void readDetails() {
        super.readDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Interest Rate for City Bank:");
        this.interestRate = scanner.nextDouble();
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest earned at City Bank: " + interest);
    }
}

class SBIBank extends Bank {
    private double interestRate;
    private double interestEarned;

    public void readDetails() {
        super.readDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Interest Rate for SBI Bank:");
        this.interestRate = scanner.nextDouble();
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        this.interestEarned = interest; // Track interest earned
        System.out.println("Interest earned at SBI Bank: " + interest);
    }

    public double getInterestEarned() {
        return interestEarned;
    }
}

class CanaraBank extends Bank {
    private double interestRate;

    public void readDetails() {
        super.readDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Interest Rate for Canara Bank:");
        this.interestRate = scanner.nextDouble();
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest earned at Canara Bank: " + interest);
    }
}

public class BankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        CityBank[] cityBanks = new CityBank[3];
        SBIBank[] sbiBanks = new SBIBank[3];
        CanaraBank[] canaraBanks = new CanaraBank[3];

        
        System.out.println("Enter details for City Bank:");
        for (int i = 0; i < cityBanks.length; i++) {
            cityBanks[i] = new CityBank();
            cityBanks[i].readDetails();
        }

       
        System.out.println("\nEnter details for SBI Bank:");
        for (int i = 0; i < sbiBanks.length; i++) {
           sbiBanks[i] = new SBIBank();
            sbiBanks[i].readDetails();
        }

        
        System.out.println("\nEnter details for Canara Bank:");
        for (int i = 0; i < canaraBanks.length; i++) {
            canaraBanks[i] = new CanaraBank();
            canaraBanks[i].readDetails();
        }

        
        System.out.println("\nCity Bank Details:");
        for (CityBank cityBank : cityBanks) {
            cityBank.displayDetails();
            cityBank.calculateInterest();
        }

        System.out.println("\nSBI Bank Details:");
        for (SBIBank sbiBank : sbiBanks) {
            sbiBank.displayDetails();
            sbiBank.calculateInterest();
        }

        System.out.println("\nCanara Bank Details:");
        for (CanaraBank canaraBank : canaraBanks) {
            canaraBank.displayDetails();
            canaraBank.calculateInterest();
        }

        
        double maxInterest = 0;
        SBIBank highestInterestCustomer = null;
        System.out.println("Enter the year you want to see the highest interest:");
        int y = scanner.nextInt();
        for (SBIBank sbiBank : sbiBanks) {
            if (sbiBank.getInterestEarned() > maxInterest && sbiBank.year==y) {
                maxInterest = sbiBank.getInterestEarned();
                highestInterestCustomer = sbiBank;
            }
        }

        if (highestInterestCustomer != null) {
            System.out.println("\nCustomer with the highest interest in SBI Bank:");
            highestInterestCustomer.displayDetails();
        } else {
            System.out.println("\nNo customers in SBI Bank.");
        }
    }
}
