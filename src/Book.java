
public class Book {

    String bcode;
    String title;
    int quantity;
    int lended;
    double price;

    public Book(String bcode, String title, int quantity, int lended, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-10d%-10d%-10.1f%-10.2f", bcode, title,
                quantity, lended, price, quantity * price);

    }
}
