// Thokozani Tshabalala's Binary Search Tree
// 01 March 2022
// Thokozani Tshabalala

import java.io.File;
import java.util.Scanner;

public class VaccineBSTApp {
    AVLTree<Vaccine> tree = new AVLTree<Vaccine>();

    public void readIn() {
        File f = new File("data/vaccinations.csv");
        try {

            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                tree.insert(new Vaccine(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userInterface() {


        System.out.println("Enter the date:");
        Scanner user1 = new Scanner(System.in);
        String dateIn = user1.nextLine();
        System.out.println("Enter the list of countries (end with an empty line):");

        String country = user1.nextLine();
        String countries = "";
        countries = countries + country;

        /**Ask for input until empty line is left*/

        while (!country.equals("")) {
            countries = countries + ",";
            country = user1.nextLine();
            countries = countries + country;
        }

        Scanner frmCountries = new Scanner(countries);
        frmCountries.useDelimiter(",");

        System.out.println("Results:");
        /**check this part if it does print country and vaccination numbers,
         **/


        while (frmCountries.hasNext()) {
            String temp = frmCountries.next();
            String countryAndDate = temp + "," + dateIn + ",";
            Vaccine v = new Vaccine(countryAndDate);
            BinaryTreeNode<Vaccine> found = tree.find(v);

            if (found != null) {
                Vaccine vacFound = found.data;
                if (vacFound.vaccinations.equals("")) {
                    System.out.println(temp + " = " + "<Not found>");
                } else {
                    System.out.println(temp + " = " + vacFound.vaccinations);
                }
            }
            // if branch closed
            else {
                System.out.println(temp + " = " + "<Not found>");

            }
        }
    }

    public static void main(String[] args)
    {
        AVLExperiment exp= new AVLExperiment();
        exp.readIn();
        exp.userInterface();
   }
}
