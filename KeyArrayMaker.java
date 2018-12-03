import sun.awt.SunHints;

import java.util.ArrayList;

/**
 * @author Alex Crick amcrick@purdue.edu
 *         4/13/2017
 */
public class KeyArrayMaker {
    public static ArrayList<String> keyArray = new ArrayList<String>();
    public static ArrayList<String> getKeyArray() {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~`!@#$%^&*()_-+{[}]|:;'<,>.?/";
        for(int i = 0; i <s.length(); i++) {
            keyArray.add(Character.toString(s.charAt(i)));
        }
        return keyArray;
    }
}
