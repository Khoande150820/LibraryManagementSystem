
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;

public class BookList {

    Node head, tail;

    public BookList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Book a) {
        Node q = new Node(a);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    //1.1
    // 1.2
    void inputAndAddToEnd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input book code: ");
        String bcode = sc.nextLine();
        System.out.println("Input title: ");
        String title = sc.nextLine();
        System.out.println("Input quantity: ");
        int quantity = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Input lended:");
        int lended = Integer.parseInt(sc.nextLine().trim());
        System.out.println("Input price: ");
        double price = Double.parseDouble(sc.nextLine().trim());
        Book a = new Book(bcode, title, quantity, lended, price);
        addLast(a);
    }
// 1.3 

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info);
        }
    }
    
    void displayData(){

        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }
// 1.8

    void addFirst(Book a) {
        head = new Node(a, head);
        if (tail == null) {
            tail = head;
        }
    }
//(1.5)

    Node search(String bcode) {
        Node p = head;
        while (p != null) {
            if (p.info.equals(bcode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }

    }

    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//q is not in the list
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }

    //(1.6)
    void removeByName(String bcode) {
        Node q = search(bcode);
        remove(q);
    }
    // (1.7)

}
