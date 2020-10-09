
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static BookList blist = new BookList();
    static final String filename = "booklist.txt";
    static ReaderList rlist = new ReaderList();
    static final String rfilename = "readerlist.txt";

    public static void main(String[] args) throws Exception {

        // MAIN MENU
        System.out.println("1.1.      Load data from file");
        System.out.println("1.2.      Input & add to the end");
        System.out.println("1.3.      Display data");
        System.out.println("1.4.      Save book list to file");
        System.out.println("1.5.      Search by bcode");
        System.out.println("1.6.      Delete by bcode");
        System.out.println("1.7.      Sort by bcode");
        System.out.println("1.8.      Input & add to beginning");
        System.out.println("1.9.      Add after position  k");
        System.out.println("1.10.    Delete position k");
        System.out.println("2.1.      Load data from file");
        System.out.println("2.2.      Input & add to the end");
        System.out.println("2.3.      Display data");
        System.out.println("2.4.      Save reader list to file");
        System.out.println("2.5.      Search by rcode");
        System.out.println("2.6.      Delete by rcode");

        int BookListSelection = 0;
        while (true) {
            System.out.println("Enter selection:");
            Scanner sc = new Scanner(System.in);
            BookListSelection = Integer.parseInt(sc.nextLine().trim());
            switch (BookListSelection) {
                case 11:
                    if (blist.head != null) {
                        blist.clear();
                    }
                    BufferedReader br = null;
                    try {
                        FileReader f = new FileReader(filename);
                        br = new BufferedReader(f);

                        String line;
                        while ((line = br.readLine()) != null) {
//                            System.out.println(line);
                            String[] arrOfString = line.split(",", 0);
//                            System.out.println(Arrays.toString(arrOfString));
                            String bcode = arrOfString[0].trim();
                            String title = arrOfString[1].trim();
                            int quantity = Integer.parseInt(arrOfString[2].trim());
                            double price = Double.parseDouble(arrOfString[3].trim());
                            blist.addLast(new Book(bcode, title, quantity, 0, price));
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    } finally {
                        try {
                            br.close();
                        } catch (IOException e) {
                        }

                    }
                    break;
                // Input and add to the end
                case 12:
                    System.out.println("Input and add to end!");
                    blist.inputAndAddToEnd();
                    break;
                // Display data
                case 13:
                    blist.displayData();
                    break;
//                    Save data
                case 14:
                    blist.saveData(blist);
                    break;
                case 15:
                    // Search book code
                    System.out.println("Find book by book code:");
                    System.out.println("Input book code: ");
                    String bcodeA = sc.nextLine();
                    Node p = blist.search(bcodeA);
                    if (p == null) {
                        System.out.println("Can't find book");
                        break;
                    }
                    System.out.println(p.info);
                    break;
                case 16:
//                    Delete by book code
                    System.out.println("DELETE BY BOOKCODE");
                    System.out.println("Input book code: ");
                    String bcodeD = sc.nextLine();
                    blist.removeByName(bcodeD);
                    break;

                // Sort by book code
                case 17:
                    blist.sort();
                    break;
                case 18:
                    // Input and add to beginning
                    System.out.println("Input and add to beginning");
                    blist.inputAndAddToBeginning();
                    break;

                // add after position k
                case 19:
                    System.out.println("Add after position");
                    System.out.println("Enter position ");
                    int indexAdd = sc.nextInt();
                    blist.addAfterPosition(indexAdd);
                    break;
                case 110:
                    System.out.println("Delete position k");
                    System.out.println("Enter position ");
                    int indexDelete = sc.nextInt();
                    blist.deletePosition(indexDelete);
                    break;

                case 21:
                    if (rlist.head != null) {
                        rlist.clear();
                    }
                    BufferedReader buffreader = null;
                    try {
                        FileReader f = new FileReader(rfilename);
                        buffreader = new BufferedReader(f);

                        String line;
                        while ((line = buffreader.readLine()) != null) {
//                            System.out.println(line);
                            String[] arrOfString = line.split(",", 0);
//                            System.out.println(Arrays.toString(arrOfString));
                            String rcode = arrOfString[0].trim();
                            String title = arrOfString[1].trim();
                            int year = Integer.parseInt(arrOfString[2].trim());
                            rlist.addLast(new Reader(rcode, title, year));
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    } finally {
                        try {
                            buffreader.close();
                        } catch (IOException e) {
                        }

                    }
                    break;
                case 22:
                    // Input and add to end
                    rlist.addLast(rlist.inputToAdd());
                    break;
                case 23:
                    // Display data
                    rlist.displayData();
                    break;
                case 24:
                    //Save data to file
                    rlist.saveData(rlist);
                    break;
                case 25:
                    // Search by rcode
                    System.out.println("Search by rcode");
                    System.out.println("Enter string: ");
                    String rcode = sc.nextLine();
                    ReaderNode pnode = rlist.search(rcode);
                    if (pnode == null) {
                        System.out.println("Can't find book");
                        break;
                    }
                    System.out.println(pnode.info);
                    break;
                case 26:
                    // Remove by rcode
                    System.out.println("Delete by rcode");
                    String rcodeDelete = sc.nextLine();
                    rlist.removeByName(rcodeDelete);

                    break;

                case -1:
                    System.out.println("Exiting program");
                    return;

            }
        }

    }
}
