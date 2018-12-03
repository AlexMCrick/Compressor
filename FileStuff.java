import java.io.*;
import java.util.*;
/**
 * @author Alex Crick amcrick@purdue.edu
 *         4/13/2017
 */
public class FileStuff implements Serializable {


    public FileStuff() {
    }

    public static ArrayList<String> readFromFile(String fromFile) {
        File f = new File(fromFile);
        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                lines.add(scan.nextLine());
            }
            return lines;

        } catch (FileNotFoundException e) {
            System.out.print("This file doesn't exist! Please try again!" + "\n");
            return null;

        }

    }

    public static boolean writeToFile(ArrayList<String> file, String newFile) {
        File f = new File(newFile);
        // TODO - redo formatting so no spaces at beginning or end of string. only \n at end
        try {
            FileWriter fw = new FileWriter(f);
            for (String s: file) {
                fw.write(s);
            }
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }



}
