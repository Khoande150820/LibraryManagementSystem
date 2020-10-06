public class Book {
    String bcode;
    String title;
    int quantity;
    int lended;
    double price ;

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "bcode=" + bcode + ", title=" + title + ", quantity=" + quantity + ", lended=" + lended + ", price=" + price + '}';
    }
    
}
