package burrowswheelerhuffman;

import java.util.ArrayList;

/**
 *
 * @author arthu
 */
public class BurrowsWheelerHuffman {

    public static void main(String[] args) {

        String initText;
        initText = "Hello_this_is_a_text";
//        initText = "texte";

//        BurrowsWheeler bw = new BurrowsWheeler(initText);
        BurrowsWheeler bw = new BurrowsWheeler(initText);
        String burrowsWheeler = bw.getTransformedString();
        int index = bw.getIndex();
        System.out.println("Burrows-Wheeler:");
        System.out.println(burrowsWheeler);
        System.out.println(index);

        System.out.println("Move to Front:");
        MoveToFront mtf = new MoveToFront(burrowsWheeler);
        ArrayList<Integer> list = mtf.encode();
        for (int rank = 0; rank < list.size(); rank++) {
            System.out.print(list.get(rank) + " ");
        }
        System.out.println("");
    }

}
