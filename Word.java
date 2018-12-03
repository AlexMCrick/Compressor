/**
 * @author Alex Crick amcrick@purdue.edu
 *         4/13/2017
 */


public class Word implements Comparable<Word> {
    int count = 1;
    String value;

    public Word(String value) {
        this.value = value;
    }
    public void incrementCount() {
        this.count++;
    }


    public boolean equals(String s) {
        if (this.value.equals(s)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int compareTo(Word o) {
        if (this.count > o.count) {
           return -1;
        }
        else if (this.count < o.count) {
            return 1;
        }
        else {
           return 0;
        }
    }
}
