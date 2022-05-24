package products.product;

import java.time.LocalDate;

public class Product {
    private Type type;
    private double price;
    private boolean discountPresense;
    private LocalDate date;

    public Type getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountPresense() {
        return discountPresense;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public Product (Type type, double price){
        this.price = price;
        this.type = type;
        this.date = LocalDate.now();
    }

    public Product(Type type, double price, boolean discountPresense) {
        this.type = type;
        this.price = price;
        this.discountPresense = discountPresense;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", price=" + price +
                ", discountPresense=" + discountPresense +
                ", date=" + date +
                '}';
    }
}