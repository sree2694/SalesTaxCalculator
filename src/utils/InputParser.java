package src.utils;

import src.models.Product;
import src.models.ReceiptItem;
import src.services.TaxCalculator;

import java.math.BigDecimal;
import java.util.Set;

public class InputParser {
    private static final Set<String> exemptKeywords = Set.of("book", "chocolate", "pills");

    public static ReceiptItem parseLine(String line, TaxCalculator calculator) {
        String[] parts = line.split(" at ");
        String namePart = parts[0].trim();
        BigDecimal price = new BigDecimal(parts[1].trim());

        int quantity = Integer.parseInt(namePart.split(" ")[0]);
        String name = namePart.substring(namePart.indexOf(' ') + 1);

        boolean isImported = name.contains("imported");
        boolean isExempt = exemptKeywords.stream().anyMatch(name::contains);

        Product product = new Product(name, price, isImported, isExempt);
        BigDecimal tax = calculator.calculateTax(product);

        return new ReceiptItem(product, quantity, tax);
    }
}