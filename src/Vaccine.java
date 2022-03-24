class Vaccine implements Comparable<Vaccine>
{

String country;
String date;
String vaccinations;

    public Vaccine(){
    this.country="";
    this.date="";
    this.vaccinations="";
    }
 
    public Vaccine(String line){
    String[] words=line.split(",");
    this.country=words[0];
    this.date=words[1];
    
        if (words.length==3){
        vaccinations=words[2];
        }
        
        else if(words.length==1) {
            date="";
        vaccinations="0";
        }
     
    }
    @Override
    public int compareTo(Vaccine v){
        int num=(country+date).compareTo(v.country+v.date);
    if(num==0){
     return 0;
     }
     else if(num<0){
         return -1;
    }
    else{
     return 1;
     }
    }



}