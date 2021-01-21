package burrowswheelerhuffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a String transformed via the Burrows-Wheeler
 * transformation. It stores the initial text, the transformed text and the line
 * number needed to decrypt the text.
 *
 * @author arthu
 */
public class BurrowsWheeler {

    private String initString;
    private String transformedString;
    private int index;

    public BurrowsWheeler(String init) {
        initString = init;
        ArrayList<String> permutations = computePermutations();
        ArrayList<String> sortedPermutations = (ArrayList<String>) permutations.clone();
        Collections.sort(sortedPermutations);

//        for (String s : sortedPermutations) {
//            System.out.println(s);
//        }
        extractLastColumn(sortedPermutations);
        index = findPosition(initString, sortedPermutations);
//        System.out.println(index + ", " + transformedString);
    }

    public String getTransformedString() {
        return transformedString;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Create the list of all permutations of the initial text.
     *
     */
    private ArrayList<String> computePermutations() {
        // Generate the list of all permutations of the text that we're encoding.
        ArrayList<String> permutations = new ArrayList<>();
        for (int i = 0; i < initString.length(); i++) {
            permutations.add(permute(initString, i));
        }
        return permutations;
    }

    /**
     * Compute the text we get by moving the first n characters to the end of
     * the text.
     *
     * @param initString
     * @param n
     * @return
     */
    private String permute(String initString, int n) {
        String result;
        if (n > 0) {
            // Place the first n characters at the end.
            result = initString.substring(n).concat(initString.substring(0, n));
        } else {
            result = initString;
        }
        return result;
    }

    /**
     * The transformed text is the last column of the matrix, i.e. the
     * concatenation of the last character of each string, in the order of the
     * sorted list.
     *
     */
    private void extractLastColumn(ArrayList<String> list) {
        StringBuilder sBuilder = new StringBuilder();
        int length = initString.length();
        for (int rank = 0; rank < length; rank++) {
            sBuilder.append(list.get(rank).charAt(length - 1));
        }
        transformedString = sBuilder.toString();
    }

    /**
     * Find the position of the required String in a list of Strings.
     *
     * @param target
     * @param list
     * @return the position of @target if it exists in list, or else -1
     */
    private int findPosition(String target, ArrayList<String> list) {
        int rank = 0;
        while (rank < list.size() && !target.equals(list.get(rank))) {
            rank++;
        }
        if (rank == list.size()) {
            return -1;
        }
        return rank;
    }
}
