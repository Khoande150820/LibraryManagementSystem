public class Reader {
    String rcode;
    String name;
    int byear;

    public Reader(String rcode, String name, int byear) {
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }
        @Override
    public String toString() {
        return String.format("%-10s%-15s%-10d", rcode, name,
                byear);

    }
    
}
