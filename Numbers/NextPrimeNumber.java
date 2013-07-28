
package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk
 * Have the program find prime numbers until the user chooses to stop asking for the next one.
 */
public class NextPrimeNumber {
    
    /**
     * 
     * @param start starting position for finding.
     * @return Next prime number (or start if it's prime). If nothing found 
     * before Long.MAX_VALUE returns 0.
     */
    public static long nextPrime(long start) {
        for (long i = start; i <= Long.MAX_VALUE; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 0;
    }
    
    /**
     * Checks if the number is prime.
     * @param number integer value to be checked.
     * @return True if the number is prime, otherwise returns false.
     */
    public static boolean isPrime(long number) {
        long findLimit = (long) Math.pow(number, 0.5);
        long divider = 2;
        while (divider <= findLimit) {
            if ((number % divider) == 0) {
                return false;
            }
            divider++;
        }
        return true;
    }
    
    public static void main(String args[]) {
        long number = Long.parseLong(Console.readLine());
        long prime = nextPrime(number);
        Console.writeLine(prime + "\r\nDo you want to find next prime number? (y/n)");
        while ("Y".equals(Console.readLine().toUpperCase())) {
            prime = nextPrime(prime + 1);
            Console.writeLine(prime + "\r\nDo you want to find next prime number? (y/n)");
        }
    }
}
