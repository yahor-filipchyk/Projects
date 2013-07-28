
package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk
 * Calculate the monthly payments of a fixed term mortgage over given Nth 
 * terms at a given interest rate. Also figure out how long it will take 
 * the user to pay back the loan.
 */
public class MortgageCalculator {
    
    public static double monthlyPayments(int termInMonths, double mortgage, double rateInPercents) {
        double totalPrice = mortgage * (1 + rateInPercents / 100);
        return totalPrice / termInMonths;
    }
    
    public static int monthCountToPay(double mortgage, double rateInPercents, double maximumYouCanPayPerMonth) {
        double totalPrice = mortgage * (1 + rateInPercents / 100);
        return Math.round((float) Math.ceil(totalPrice / maximumYouCanPayPerMonth));
    }
    
    public static void main(String args[]) {
        Console.writeLine("To calculate monthly payments enter term, mortgage size and interest rate.");
        int term = Integer.parseInt(Console.read("Term in month: "));
        double mortgage = Double.parseDouble(Console.read("Mortage: "));
        double rate = Double.parseDouble(Console.read("Rate in percents: "));
        Console.writeLine("Monthly payments: " +  monthlyPayments(term, mortgage, rate));
        Console.writeLine("To calculate how long it will take you to pay back the loan enter mortgage \r\nsize, interest rate and the maximum you can pay per month.");
        mortgage = Double.parseDouble(Console.read("Mortage: "));
        rate = Double.parseDouble(Console.read("Rate in percents: "));
        double maxPayment = Double.parseDouble(Console.read("Maximum payment per month: "));
        Console.writeLine("Monthly payments: " +  monthCountToPay(mortgage, rate, maxPayment));
    }
}
