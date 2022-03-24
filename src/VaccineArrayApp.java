import java.io.*;
import java.util.*;

class VaccineArrayApp{
     VaccineArray va = new VaccineArray();

    public void readInFile (){
    // reads in the content of file into data structure
        File f= new File("data/vaccinations.csv");
        try{
        
            Scanner sc= new Scanner(f);
        
            while (sc.hasNextLine()){
                String line=sc.nextLine();
                va.add(new Vaccine (line));
                }
            }
        catch(Exception e)
            {
            e.printStackTrace();
            }
            //System.out.println(va.records);
        }
        
            
        public void userInterface (){
        //interrative user interface
            System.out.println("Enter the date:");
            Scanner user= new Scanner(System.in);
            String dateIn=user.nextLine();
            System.out.println("Enter the list of countries (end with an empty line):");

            String country=user.nextLine();
            String countries="";
            countries=countries+country;
            
            while (!country.equals("")){
                countries=countries+",";
                country=user.nextLine();
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

                //System.out.println(countryAndDate);                                      //check how the countryAndDate string variable is stored

                Vaccine v=new Vaccine(countryAndDate);                                    // new vaccine object
                Vaccine found=va.find(v);                                                //find corresponding element in the vaccine array that has the same name and country
            
                if(found != null){
                  System.out.println(temp+" = "+found.vaccinations);
                  }                      
                                                                                             // if branch closed
                  else{
                    System.out.print(temp+" = "+"<not found>");
                 }                                                                         // else branch closed
         }
                                                                                            //while loop is closed
        }
        

    public static void main(String [] args){ 
    
    VaccineArrayApp vaa=new VaccineArrayApp();
    vaa.readInFile ();
    vaa.userInterface ();   
    

    }
}