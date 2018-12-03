import java.io.File;
import java.util.ArrayList;
/**
 * @author Alex Crick amcrick@purdue.edu
 *         4/13/2017
 */
public class Compressor {
//im adding something
    public static void newCompression(String fileName) {
        ArrayList<String> keyArray = KeyArrayMaker.getKeyArray();
        int keyCount = keyArray.size();
        ArrayList<String> lines = FileStuff.readFromFile(fileName);
        if (lines == null) {
            return;
        }
        String title = fileName.substring(0, fileName.length() - 4);
        String newFile = (title + ".alx");
        ArrayList<Word> words = new ArrayList<Word>();
        for (String s: lines) {
            String[] word = s.split(" ");
            for (String term: word) {
                boolean found = false;
                for (Word w: words) {
                    if (w.equals(term)) {
                        w.incrementCount();
                        found = true;
                        break;
                    }
                }
                if (!found && term.length() > 1) {
                    words.add(new Word(term));
                }
            }
        }
        words.sort(Word::compareTo);
        ArrayList<String> termArray = new ArrayList<String>();
        ArrayList<String> finalText = new ArrayList<String>();
        for (int i = 0; i < keyCount; i++) {
            if (i < words.size()) {
                if (words.get(i).count >= 3 && words.get(i).value.length() <= 5) {
                    termArray.add(words.get(i).value);
                }
            }
        }
        //Creating symbol index at beginning of file
        for (int j = 0; j < termArray.size(); j++) {
            finalText.add(termArray.get(j) + "=" + keyArray.get(j) + " ");
        }
        //adding stopper symbol
        finalText.add("\n");
        //iterate through list and replace words with symbols

        for (String s: lines) {
            String[] word = s.split(" ");
            ArrayList<String> w = new ArrayList<String>();
            // takes input line and converts to arraylist for methods
            for(String str: word) {
                w.add(str);
            }
            //iterate through arraylist

            for (int i = 0; i < w.size(); i++) {
                if (termArray.contains(w.get(i))) {
                    finalText.add(keyArray.get(termArray.indexOf(w.get(i))));
                    finalText.add(" ");
                }
                else if  (keyArray.contains(w.get(i))) {
                    finalText.add("|" + w.get(i));
                    finalText.add(" ");
                }
                else {
                    finalText.add(w.get(i));
                    finalText.add(" ");
                }
            }
            finalText.remove(finalText.size() - 1);
            finalText.add("\n");
        }
        FileStuff.writeToFile(finalText, newFile);
        System.out.println("Compressing completed!");
    }

    public static void fromCompression(String fileName) {
        String fileN = fileName.substring(0, fileName.length() - 4);
        String newFile = (fileN + ".txt");
        ArrayList<String> lines = FileStuff.readFromFile(fileName);
        ArrayList<String> finalLines = new ArrayList<String>();
        ArrayList<String> keyList = new ArrayList<String>();
        ArrayList<String> termList = new ArrayList<String>();
        String codex = lines.get(0);
        String[] codexWords = codex.split(" ");
        for (String s: codexWords) {
            if (s.contains("=")) {
                String key = s.split("=")[1];
                String term = s.split("=")[0];
                keyList.add(key);
                termList.add(term);
            }
            else {
                System.out.println("De-compression failed, .alx file corrupted!");
                System.exit(0);
            }
        }
        lines.remove(0);

        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] wordsInLine = line.split(" ");
            for (String s: wordsInLine) {
                boolean fixed = false;
                if (s.contains("|") && s.length() > 1) {
                    String newStr = s.substring(1);
                    finalLines.add(newStr);
                    finalLines.add(" ");
                    fixed = true;
                }
                else if (!fixed && keyList.contains(s)) {
                    int keyIndex = keyList.indexOf(s);
                    String term = termList.get(keyIndex);
                    finalLines.add(term);
                    finalLines.add(" ");
                }
                else {
                    finalLines.add(s);
                    finalLines.add(" ");
                }
            }
            finalLines.remove(finalLines.size() - 1);
            finalLines.add("\n");
        }
        FileStuff.writeToFile(finalLines, newFile);
        System.out.println("De-compressing completed successfully!");
    }
}
