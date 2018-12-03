/**
 * @author Alex Crick amcrick@purdue.edu
 *         4/13/2017
 */
import java.util.*;
public class CompressorMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Welcome to the Alx text file compressor");
            System.out.println("Enter 1 to compress a text file");
            System.out.println("Enter 2 to de-compress a .alx file");
            System.out.println("enter 3 to exit the program");
            String answer = scan.nextLine();
            switch(answer) {
                case("1"): {
                    System.out.println("Enter the full name of the text file");
                    String fileName = scan.nextLine();
                    Compressor.newCompression(fileName);
                    break;
                }
                case("2"): {
                    System.out.println("Enter the full name of the .alx file");
                    String fileName = scan.nextLine();
                    Compressor.fromCompression(fileName);
                    break;
                }
                case("3"): {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Entry not valid");
                    break;
                }
            }
        }
    }
}
