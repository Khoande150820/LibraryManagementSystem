
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String filename = "booklist.txt";
        BookList blist = new BookList();
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

        int selection = 0;
        while (true) {
            System.out.println("Enter selection");
            Scanner sc = new Scanner(System.in);
            selection = Integer.parseInt(sc.nextLine().trim());
            switch (selection) {
                case 1:

                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(filename));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
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

                case 2:
                    blist.inputAndAddToEnd();
                    break;
                case 3:
                    blist.displayData();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Input book code: ");
                    String bcode = sc.nextLine();
                    blist.search(bcode);

                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;

            }
        }

    }
}
