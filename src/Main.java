
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static BookList blist = new BookList();
    static final String filename = "booklist.txt";

    public static void main(String[] args) throws Exception {

        ReaderList rlist = new ReaderList();
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

        int BookListSelection = 0;
        while (true) {
            System.out.println("Enter selection:");
            Scanner sc = new Scanner(System.in);
            BookListSelection = Integer.parseInt(sc.nextLine().trim());
            switch (BookListSelection) {
                case 1:

                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(filename));
                        String line;
                        while ((line = br.readLine()) != null) {
//                            System.out.println(line);
                            String[] arrOfString = line.split(",", 0);
//                            System.out.println(Arrays.toString(arrOfString));
                            String bcode = arrOfString[0].trim();
                            String title = arrOfString[1].trim();
                            int quantity = Integer.parseInt(arrOfString[2].trim());
                            double price = Double.parseDouble(arrOfString[3].trim());
                            blist.addLast(new Book(bcode, title, quantity, quantity, price));
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
                case 2:
                    System.out.println("Input and add to end!");
                    blist.inputAndAddToEnd();
                    break;
                // Display data
                case 3:
                    blist.displayData();
                    break;
//                    Save data
                case 4:
                    blist.saveData(blist);
                    break;
                case 5:
                    // Search book code
                    System.out.println("Input book code: ");
                    String bcodeA = sc.nextLine();
                    blist.search(bcodeA);
                    break;
                case 6:
//                    Delete by book code
                    System.out.println("DELETE BY BOOKCODE");
                    System.out.println("Input book code: ");
                    String bcodeD = sc.nextLine();
                    blist.removeByName(bcodeD);
                    break;

                // Sort by book code
                case 7:
                    blist.sort();
                    break;
                case 8:
                    // Input and add to beginning
                    System.out.println("Input and add to beginning");
                    blist.inputAndAddToBeginning();
                    break;

                // add after position k
                case 9:
                    System.out.println("Add after position");
                    System.out.println("Enter position ");
                    int indexAdd = sc.nextInt();
                    blist.addAfterPosition(indexAdd);
                    break;
                case 10:
                    System.out.println("Enter position ");
                    int indexDelete = sc.nextInt();
                    blist.deletePosition(indexDelete);
                    break;
                case 11:
                    System.out.println("Exitting program");
                    return;

            }
        }

    }
}
