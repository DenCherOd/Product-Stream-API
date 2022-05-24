package products.product;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        System.out.println(productManager.findProductByCategoryAndMinPrice(Type.BOOK, 250));
        System.out.println(productManager.findProductByCategoryWithDiscount(Type.BOOK));
        System.out.println(productManager.findCheapestBook(Type.BOOK));
        System.out.println(productManager.getLastThreeAddedProducts());
        System.out.println(productManager.getSumPriceFromThisYearProductsWithMaxPrice(Type.BOOK, 75));
    }
}