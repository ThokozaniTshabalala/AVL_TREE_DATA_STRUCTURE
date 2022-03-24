import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Randomisation {

    public int seed() {
        Random rand = new Random();
        int upperBound = 9919;
        int m = rand.nextInt(upperBound);

        //System.out.println(m);
               return m;
    }

    public void feed() {
        for (int i = 0; i < 30; i++) {
            AVLExperimentation exp= new AVLExperimentation();
            int recSeed = seed();
            //then feed this seed to AVL experiment
            exp.random(recSeed);
            VaccineArray var= new VaccineArray();
            var=exp.getArray();
            ArrayList<Integer> inserts = new ArrayList<Integer>();
            ArrayList<Integer> finds = new ArrayList<Integer>();


            for (int v = 0; v < 9919; v++) {
                // now that it has been the seed has been fed to AVL
                //Now then test insert and find for this randomisation
                //insertion
                exp.readIn(var.data[v]);
                inserts.add(exp.tree.getOpCount0i());
                exp.tree.find(var.data[v]);
                finds.add(exp.tree.getOpCount0s());
                //now for find
            }
            System.out.println("for seed = "+recSeed);
            System.out.println("Max     Min    Avg");
            System.out.println(Collections.max(inserts)+"   " +Collections.min(inserts)+"   " + inserts.stream().collect(Collectors.averagingInt(Integer::intValue)).intValue());
            System.out.println(Collections.max(finds)+"   " +Collections.min(finds)+"   " + finds.stream().collect(Collectors.averagingInt(Integer::intValue)).intValue());

        }
    }


    public static void main(String []args) {
        Randomisation varied= new Randomisation();
        varied.seed();
        varied.feed();


    }
}
