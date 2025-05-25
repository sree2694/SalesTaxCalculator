package src;

import src.models.Receipt;
import src.models.ReceiptItem;
import src.services.TaxCalculator;
import src.utils.InputParser;

import java.util.List;

public class SalesTaxCalculator {
    public static void main(String[] args) {
        List<List<String>> baskets = List.of(
            List.of("1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85"),
            List.of("1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50"),
            List.of("1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25")
        );

        int basketNum = 1;
        TaxCalculator calculator = new TaxCalculator();

        for (List<String> basket : baskets) {
            System.out.println("Output " + basketNum + ":");
            Receipt receipt = new Receipt();
            for (String line : basket) {
                ReceiptItem item = InputParser.parseLine(line, calculator);
                receipt.addItem(item);
            }
            receipt.printReceipt();
            System.out.println();
            basketNum++;
        }
    }
}