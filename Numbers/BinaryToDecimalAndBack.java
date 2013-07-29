/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Filipchyk
 * Develop a converter to convert a decimal number to binary or 
 * a binary number to its decimal equivalent.
 */
public class BinaryToDecimalAndBack {
    
    public static String binToDec(String number) {
        return new Integer(Integer.parseInt(number, 2)).toString();
    }
    
    public static String decToBin(String number) {
        return Integer.toBinaryString(Integer.parseInt(number));
    }
    
    public static void main(String args[]) {
        String command;
        while (!"q".equals(command = Console.read("Bin to dec of dec to bin? (bd / db / q to exit) ").toLowerCase())) {
            switch (command) {
                case "bd":
                    Console.writeLine(binToDec(Console.read("number: ")));
                    break;
                case "db":
                    Console.writeLine(decToBin(Console.read("number: ")));
                    break;
            }
        }
    }
}
