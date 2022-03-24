import java.util.Random;

public class Randomii {

    public static void main(String []args) {
        Random rand = new Random();
        int upperBound = 9919;
        int randy = rand.nextInt(upperBound);

        System.out.println(randy);
    }
}
