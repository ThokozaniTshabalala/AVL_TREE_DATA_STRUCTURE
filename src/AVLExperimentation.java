import java.io.File;
import java.util.Scanner;

public class AVLExperimentation {
    AVLTree<Vaccine> tree = new AVLTree<Vaccine> ();



    VaccineArray va= new VaccineArray();
    Scanner user1= new Scanner(System.in);

    public void random() {
    }
    public void random(int seed){
        int rs=seed;
        //System.out.println("randomisation seed= "+rs);
        File f= new File("data/vaccinations.csv");
        try{

            Scanner sc= new Scanner(f);

            //adds vaccine objects to array
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                va.add(new Vaccine(line));
            }

            //now randomise


            for(int i=0;i<rs;i++){
                int index=(int)(Math.random()*rs);
                //System.out.println("index= "+index);
                Vaccine temp=va.data[i];
                va.data[i]=va.data[index];
                va.data[index]=temp;
            } // ends for loop



        } //ends try loop
        catch(Exception e)
        {
            e.printStackTrace();
        } // ends catch loop

        /**System.out.println(va.records);
        //System.out.println(va.data[1].country);
         */

    } // ends randomisation method



    public  void readIn(){
        int count=va.records;

        for(int l=0;l<count;l++){
            tree.insert(va.data[l]);
        }

    }
    public void readIn(Vaccine v){
        tree.insert(v);
    }


    public VaccineArray getArray() {
        return va;
    }


}


