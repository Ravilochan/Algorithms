import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = "";
        int totalInput = 0;
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            totalInput++;
            if (StdRandom.bernoulli(1.0 / totalInput)) {
                champ = input;
            }
        }
        StdOut.println(champ);
    }
}