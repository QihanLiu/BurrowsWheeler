import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    private static final int RELEVANT_BITS = 256;
    // apply Burrows-Wheeler transform, reading from standard input and writing to
    // standard output
    public static void transform() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(input);

        int first = 0;
        int len = input.length();
        // find index[i]  = 0
        for (int i = 0; i < len; i++) {
            if (csa.index(i) == 0) {
                first = i;
                break;
            }
        }
        // output first
        BinaryStdOut.write(first);
        // output t array
        for (int i = 0; i < len; i++) {
            int lastIdx = (csa.index(i) - 1 + len) % len;
            BinaryStdOut.write(input.charAt(lastIdx));
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and
    // writing to standard output
    // using key-indexed counting 
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String lastCol = BinaryStdIn.readString();

        int len = lastCol.length();
        int[] next = new int[len];
        int[] count = new int[RELEVANT_BITS + 1];
        char[] firstCol = new char[len];
        // compute frequency counts
        for (int i = 0; i < len; i++) {
            count[lastCol.charAt(i) + 1]++;
        }
        // transform counts to indices
        // pre-sum of pre occuring letters
        for (int i = 0; i < RELEVANT_BITS; i++) {
            count[i + 1] += count[i];
        }
        for (int i = 0; i < len; i++) {
            // count + 1 to increase index of same letter
            int posi = count[lastCol.charAt(i)]++;
            firstCol[posi] = lastCol.charAt(i);
            next[posi] = i;
        }
        // output text based on next array
        for (int i = 0; i < len; i++) {
            BinaryStdOut.write(firstCol[first]);
            first = next[first];
        }
        BinaryStdOut.close();
    }
    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            BurrowsWheeler.transform();
        }
        if (args[0].equals("+")) {
            BurrowsWheeler.inverseTransform();
        }
    }

}