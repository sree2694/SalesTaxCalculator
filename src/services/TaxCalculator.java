package src.services;

import src.models.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    private static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_DUTY_RATE = new BigDecimal("0.05");

    public BigDecimal calculateTax(Product product) {
        BigDecimal tax = BigDecimal.ZERO;
        if (!product.isExempt()) {
            tax = tax.add(product.getPrice().multiply(BASIC_TAX_RATE));
        }
        if (product.isImported()) {
            tax = tax.add(product.getPrice().multiply(IMPORT_DUTY_RATE));
        }
        return roundUpToNearest005(tax);
    }

    private BigDecimal roundUpToNearest005(BigDecimal amount) {
        return new BigDecimal(Math.ceil(amount.doubleValue() * 20.0) / 20.0).setScale(2, RoundingMode.HALF_UP);
    }
}