
package my.yahorfilipchyk.digits;

import my.yahorfilipchyk.console.Console;

/**
 *
 * @author Yahor Yahor
 * Find Cost of Tile to Cover W x H Floor - Calculate the total cost of tile it 
 * would take to cover a floor plan of width and height, using a cost entered by the user.
 */
public class FindingCostOfTiles {
    
    public static double totalPrice(double flatWidth, double flatHeight, double tileCost) {
        double flatArea = flatWidth * flatHeight;
        double total = tileCost * flatArea;
        return total;
    }
    
    public static void main(String args[]) {
        Console.writeLine("Width of the flat: ");
        double width = Double.parseDouble(Console.readLine());
        Console.writeLine("Heigth of the flat: ");
        double height = Double.parseDouble(Console.readLine());
        Console.writeLine("Cost of the tile per square meter: ");
        double cost = Double.parseDouble(Console.readLine());
        Console.writeLine("Total cost: " + totalPrice(width, height, cost));
    }
}
