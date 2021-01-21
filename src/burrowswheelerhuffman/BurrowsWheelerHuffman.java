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
        initText = "The path of the righteous man is beset on all sides by the"
                + " inequities of the selfish and the tyranny of evil men blessed"
                + " is he who, in the name of charity and good will, shepherds"
                + " the weak through the valley of darkness for he is truly his"
                + " brother's keeper and the finder of lost children. And I will"
                + " strike down upon thee with great vengeance and furious anger"
                + " those who attempt to poison and destroy my brothers. And you"
                + " will know my name is the Lord when I lay my vengeance upon thee.";
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
