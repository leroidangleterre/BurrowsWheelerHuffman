package burrowswheelerhuffman;

import java.util.ArrayList;

/**
 * This class computes the Move-To-Front algorithm on a given String.
 *
 * @author arthu
 */
public class MoveToFront {

    private String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ _";
    private String usedAlphabet;

    private String textToEncode;

    public MoveToFront(String text, String alphabet) {
        textToEncode = text;
        if (alphabet == null) {
            usedAlphabet = defaultAlphabet;
        } else {
            usedAlphabet = alphabet;
        }

    }

    public MoveToFront(String text) {
        this(text, null);
    }

    public ArrayList<Integer> encode() {
        ArrayList<Integer> result = new ArrayList<>();

        for (int rank = 0; rank < textToEncode.length(); rank++) {
            char c = textToEncode.charAt(rank);
            int index = firstIndexOf(c, usedAlphabet);
            if (index == -1) {
                System.out.println("Character " + c + " does not exist in alphabet.");
            } else {
                result.add(index);
                usedAlphabet = moveCharacterToFront(index, usedAlphabet);
            }
        }

        return result;
    }

    /**
     * Get the index of the first occurrence of a character in a text.
     *
     * @param c
     * @param text
     * @return -1 if character not found, or actual rank.
     */
    private int firstIndexOf(char c, String text) {
        int result = -1;
        for (int rank = text.length() - 1; rank >= 0; rank--) {
            if (text.charAt(rank) == c) {
                result = rank;
            }
        }
        return result;
    }

    /**
     * Return a String where the chose character is removed and placed at the
     * beginning.
     *
     * @param index
     * @param text
     * @return the unchanged text if the index is invalid, or the appropriately
     * modified text.
     */
    private String moveCharacterToFront(int index, String text) {
        if (index >= text.length() || index <= 0) {
            return text;
        }
        String firstPart = text.substring(0, index);
        String secondPart = text.substring(index + 1);
        return text.charAt(index) + firstPart.concat(secondPart);
    }

}
