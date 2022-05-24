package products.product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductManager {
    List<Product> productList = new ArrayList<>();

    {
        productList.add(new Product(Type.BOOK, 260.50, true));
        productList.add(new Product(Type.BOOK, 74));
        productList.add(new Product(Type.PEN, 11, true));
        productList.add(new Product(Type.NOTEBOOK, 15.40));
        productList.add(new Product(Type.BOOK, 250.00));
        productList.add(new Product(Type.BOOK, 150.50, true));
    }

    public List<Product> findProductByCategoryAndMinPrice(Type productType, double minPrice) {
        List<Product> searchingList = productList.stream().filter(s -> s.getType().equals(productType))
                .filter(s -> s.getPrice() >= minPrice).collect(Collectors.toList());
        return searchingList;
    }

    public  List<Product> findProductByCategoryWithDiscount(Type productType) {
        List<Product> searchingProductsWithDiscount = productList.stream().filter(s -> s.getType().equals(productType))
                .filter(Product::isDiscountPresense).collect(Collectors.toList());
        searchingProductsWithDiscount.forEach(product -> product.setPrice(product.getPrice() / 100 * 90));
        return searchingProductsWithDiscount;
    }

    public  Product findCheapestBook(Type productType) {
        Product cheapestBook = productList.stream().filter(s -> s.getType().equals(productType))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт не найден"));
        return cheapestBook;
    }

    public  List<Product> getLastThreeAddedProducts() {
        List<Product> lastThreeAddedProducts = productList.stream().filter(product -> product.getDate() != null)
                .filter(product -> product.getDate().getYear() == LocalDate.now().getYear())
                .limit(3)
                .collect(Collectors.toList());

        return lastThreeAddedProducts;
    }

    public  double getSumPriceFromThisYearProductsWithMaxPrice(Type productType, double maxPrice) {
        double totalPriceOfThisYearProducts = productList.stream().
                filter(product -> product.getDate() != null)
                .filter(product -> product.getDate().getYear() == 2022)
                .filter(s -> s.getType().equals(productType))
                .filter(product -> product.getPrice() <= maxPrice)
                .mapToDouble(x -> x.getPrice())
                .sum();
        return totalPriceOfThisYearProducts;
    }

    public Map<Type, List<Product>> groupProducts() {
        Map<Type, List<Product>> groupProducts = productList.stream()
                .collect(Collectors.groupingBy(Product::getType));
        return groupProducts;
    }
}