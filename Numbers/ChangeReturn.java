
package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk
 * The user enters a cost and then the amount of money given. The program will 
 * figure out the change and the number of quarters, dimes, nickels, pennies 
 * needed for the change.
 */
public class ChangeReturn {
    
    public static final int QUARTER = 25;
    public static final int DIME = 10;
    public static final int NICKEL = 5;
    public static final int PENNI = 1;
            
    public static int[] changeReturn(double cost, double amountGiven) {
        double change = amountGiven - cost;
        int changeInBills = (int) change;
        int changeInCoins = (int) ((change - changeInBills) * 100);
        int result[] = new int[5]; // bills, quarters, dimes, nickels and pennies
        result[0] = changeInBills;
        result[1] = changeInCoins / QUARTER;    // quarters count
        changeInCoins = changeInCoins - result[1] * QUARTER;
        result[2] = changeInCoins / DIME;       // dimes count
        changeInCoins = changeInCoins - result[2] * DIME;
        result[3] = changeInCoins / NICKEL;     // nickels count
        changeInCoins = changeInCoins - result[3] * NICKEL;
        result[4] = changeInCoins / PENNI;      // pennies count
        return result;
    }
    
    public static void main(String args[]) {
        double cost = Double.parseDouble(Console.read("Cost: "));
        double amountGiven = Double.parseDouble(Console.read("Ammount given: "));
        int[] change = changeReturn(cost, amountGiven);
        Console.writeLine("Bills: " + change[0] + ", quarters: " + change[1] + ", dimes: " + change[2] +
                ", nickels: " + change[3] + ", pennies: " + change[4]);
    }
}
