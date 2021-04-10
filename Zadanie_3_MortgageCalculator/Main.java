package zadania.MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    //This program calculates monthly payment and payments schedule
    //knowing principal, annual interest rate and amount of years
    //and prints it to the console
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate (In Percent)", 1, 30);
        byte years = (byte) readNumber("Period (In Years)", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        //PRINTING
        //Format mortgage payment to have currency and print it
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("\nMORTGAGE\n--------\nMonthly Payments: " + currency.format(calculator.calculateMortgage()));
        //Print mortgage payments schedule
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (double balance : calculator.getRemainingBalances()) {
            System.out.println(currency.format(balance));
        }
    }

    //Reading necessary values from console
    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter the value between " + min + " and " + max + ".");
        }
        return value;
    }
}
