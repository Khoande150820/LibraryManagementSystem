
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReaderList {

    ReaderNode head, tail, sort;

    public ReaderList() {
        head = tail = sort = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void addLast(Reader a) {
        ReaderNode q = new ReaderNode(a);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(ReaderNode p) {
        if (p != null) {
            System.out.println(p.info);
        }
    }

    void displayData() {
        System.out.println("Code        name       Year         ");
        ReaderNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void saveData(ReaderList rlist) throws Exception {
        final String filename = "readerlist.txt";
        FileWriter write = new FileWriter(filename, false);
        PrintWriter pw = new PrintWriter(write);
        ReaderNode p = rlist.head;
        while (p != null) {
            pw.println(p.info.rcode + " , " + p.info.name + " , " + p.info.byear);
            p = p.next;
        }
        pw.close();
    }

    Reader inputToAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input reader code: ");
        String rcode = sc.nextLine();
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input book year: ");
        int byear = Integer.parseInt(sc.nextLine().trim());
        Reader a = new Reader(rcode, name, byear);
        return a;
    }

    ReaderNode search(String rcode) {
        ReaderNode p = head;
        while (p != null) {
            if (p.info.rcode.equals(rcode)) {
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

    void remove(ReaderNode q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        ReaderNode f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return;//q is not in the list
        }
        ReaderNode q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }
    
        void removeByName(String bcode) {
        ReaderNode q = search(bcode);
        remove(q);
    }

}
