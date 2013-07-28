
package my.yahorfilipchyk.digits;

import java.util.ArrayList;
import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk 
 * Have the user enter a number and find all Prime Factors (if there are any) and display them.
 */
public class PrimeFactorization {
    
    public static int[] factorize(int number) {
        ArrayList<Integer> primeNumbers = new ArrayList();
        // for finding all prime fictors of the number it's enough to
        // check all numbers from 2 to number^(1/2)
        int findLimit = (int) Math.pow(number, 0.5);
        int divider = 2;
        while (divider <= findLimit) {
            boolean divFound = false;
            while (!divFound) {
                if ((number % divider) == 0) {
                    primeNumbers.add(divider);
                    number /= divider;
                } else {
                    divFound = true;
                    divider++;
                }
            }
        }
        if (number != 1) {
            primeNumbers.add(number);
        }
        return listToArray(primeNumbers);                
    }
    
    // method for copying of ArrayList to an array if integers
    public static int[] listToArray(ArrayList<Integer> list) {
        int result[] = new int[list.size()];
        int i = 0;
        for (Integer number : list) {
            result[i] = number.intValue();
            i++;
        }
        return result;
    }
    
    public static void main(String args[]) {
        int number = Integer.parseInt(Console.readLine());
        int primes[] = factorize(number);
        for (int i = 0; i < primes.length; i++) {
            Console.writeLine(primes[i] + "");
        }
    }
}
