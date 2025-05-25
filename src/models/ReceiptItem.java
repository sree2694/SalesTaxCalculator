package src.models;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReceiptItem {
    private final Product product;
    private final int quantity;
    private final BigDecimal tax;
    private final BigDecimal totalPrice;

    public ReceiptItem(Product product, int quantity, BigDecimal tax) {
        this.product = product;
        this.quantity = quantity;
        this.tax = tax;
        this.totalPrice = (product.getPrice().add(tax)).multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTax() {
        return tax.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return quantity + " " + product.getName() + ": " + totalPrice;
    }
}
