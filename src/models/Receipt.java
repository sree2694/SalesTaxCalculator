package src.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<ReceiptItem> items = new ArrayList<>();

    public void addItem(ReceiptItem item) {
        items.add(item);
    }

    public void printReceipt() {
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (ReceiptItem item : items) {
            System.out.println(item);
            totalTax = totalTax.add(item.getTax());
            totalAmount = totalAmount.add(item.getTotalPrice());
        }

        System.out.println("Sales Taxes: " + totalTax.setScale(2, RoundingMode.HALF_UP));
        System.out.println("Total: " + totalAmount.setScale(2, RoundingMode.HALF_UP));
    }
}