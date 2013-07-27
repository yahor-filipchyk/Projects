package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk Enter a number and have the program generate the
 * Fibonacci sequence to that number or to the Nth number.
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
        String number = Console.readLine();
        int n = Integer.parseInt(number);
        long sequence[] = fibSequence(100);
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + ", ");
        }
        System.out.println();
    }
}
