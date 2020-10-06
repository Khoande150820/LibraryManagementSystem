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
        return bcode + "      " + title + "      "  + quantity +"      "  + lended +"      "  + price ;
    }
    
}
