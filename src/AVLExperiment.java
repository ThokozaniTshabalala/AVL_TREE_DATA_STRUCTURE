import java.io.File;
import java.util.Scanner;

public class AVLExperiment {
    AVLTree<Vaccine> tree = new AVLTree<Vaccine> ();
    VaccineArray va= new VaccineArray();
    Scanner user1= new Scanner(System.in);


    public void random(){
        System.out.println("Enter randomisation seed(as an integer):");
        int rs=user1.nextInt();
        //System.out.println("randomisation seed= "+rs);
        File f= new File("data/vaccinations.csv");
        try{

            Scanner sc= new Scanner(f);

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

        //System.out.println(va.records);
       // System.out.println(va.data[1].country);
    } // ends randomisation method



    public void readIn(){
        int count=va.records;

        for(int l=0;l<count;l++){
            tree.insert(va.data[l]);
        }

    }

    public void userInterface(){
        System.out.println("Enter the date:");
        user1= new Scanner(System.in);
        String dateIn=user1.nextLine();
        System.out.println("Enter the list of countries (end with an empty line):");

        String country=user1.nextLine();
        String countries="";
        countries=countries+country;
        /**Ask for input until empty line is left*/

        while (!country.equals("")){
            countries=countries+",";
            country=user1.nextLine();
            countries=countries+country;
        }

        Scanner frmCountries=new Scanner(countries);
        frmCountries.useDelimiter(",");

        System.out.println("Results:");
        /**check this part if it does print country and vaccination numbers,
         **/
        while(frmCountries.hasNext()){
            String temp=frmCountries.next();
            String countryAndDate=temp+","+dateIn+",";
            Vaccine v= new Vaccine(countryAndDate);
            BinaryTreeNode<Vaccine> found= tree.find(v);

            if(found!=null){
                Vaccine vacFound=found.data;
                if(vacFound.vaccinations.equals("")) {
                    System.out.println(temp + " = " + "<Not found>");
                }
                else{
                    System.out.println(temp+" = "+ vacFound.vaccinations);
                }
            }
            // if branch closed
            else{
                System.out.println(temp + " = " + "<Not found>");

            }
            // else branch closed
        }

    }

    public static void main(String []args){
        AVLExperiment vaa=new AVLExperiment();
        vaa.random();
        vaa.readIn ();
        vaa.userInterface ();



    }
}



