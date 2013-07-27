
package my.yahorfilipchyk.digits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yahor Filipchyk  
 * Enter a number and have the program generate the Fibonacci sequence to that number or to the Nth number.
 */
public class Fibonacci {
    
    public static long[] fibSequence(int n) {
        long sequence[] = new long[n];
        if (n > 0) {
            sequence[0] = 0;
            if (n > 1) {
                sequence[1] = 1;
                for (int i = 2; i < n; i++) {
                    sequence[i] = sequence[i - 1] + sequence[i - 2];
                    // if next element is higher than Long.MAX_VALUE return only first part of found sequence
                    if (sequence[i] < 0) {
                        long newSequence[] = new long[i];
                        System.arraycopy(sequence, 0, newSequence, 0, newSequence.length);
                        return newSequence;
                    }
                }
            }
        }
        return sequence;
    }
    
    public static void main(String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {        
            String number = reader.readLine();
            int n = Integer.parseInt(number);
            long sequence[] = fibSequence(100);
            for (int i = 0; i < sequence.length; i++) {
                System.out.print(sequence[i] + ", ");
            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(Fibonacci.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
