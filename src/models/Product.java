package src.models;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal price;
    private final boolean isImported;
    private final boolean isExempt;

    public Product(String name, BigDecimal price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }
}

