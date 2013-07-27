
package my.yahorfilipchyk.digits;

/**
 *
 * @author Yahor Filipchyk
 * Find PI to the Nth Digit - Enter a number and have the program generate PI 
 * up to that many decimal places. Keep a limit to how far the program will go.
 */
public class PiCalculator {
    
    public static String piSpigot(final int n) {
        // check the n parameter
        if (n < 1 || n > 644245094) {
            throw new IllegalArgumentException("Number of pi digits must be more than 0 and less than 644245094");
        }
        // create new StringBuilder object to store digits of pi in it
        StringBuilder pi = new StringBuilder(n);
        // calculate size of the array needed to calculate n digits of pi
        int boxes = n * 10 / 3;
        int reminders[] = new int[boxes]; 
        // initialize an array
        for (int i = 0; i < boxes; i++) {
            reminders[i] = 2;
        }
        int heldDigits = 0; // number of cuurently not true digits in the end of found sequence
        // find one digit per one loop iteration
        for (int i = 0; i < n; i++) {
            int quotient;   // result of division
            int carriedOver = 0;    // carried to next iteration of inner loop
            int sum = 0; 
            for (int j = boxes - 1; j >= 0; j--) {
                reminders[j] *= 10;
                sum = reminders[j] + carriedOver;
                quotient = sum / (j * 2 + 1);
                reminders[j] = sum % (j * 2 + 1);
                carriedOver = quotient * j;
            }
            reminders[0] = sum % 10;
            // get new predigit
            int q = sum / 10;
            // adjust the predigits
            if (q == 9) {
                heldDigits++;
            } else if (q == 10) {
                q = 0;
                for (int k = 1; k <= heldDigits; k++) {
                    int replaced = Integer.parseInt(pi.substring(i - k, i - k + 1));
                    if (replaced == 9) {
                        replaced = 0;
                    } else {
                        replaced++;
                    }
                    pi.deleteCharAt(i - k);
                    pi.insert(i - k, replaced);
                }
                heldDigits = 1;
            } else {
               heldDigits = 1;
            }
            // append new predigit to sequence
            pi.append(q);
        }
        // insert dot first digit
        if (pi.length() >= 2) {
            pi.insert(1, '.');
        }
        return pi.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Wrong command line parameters.");
        } else {
            int digits = Integer.parseInt(args[0]);
            System.out.println(piSpigot(digits));
        }
    }
}
