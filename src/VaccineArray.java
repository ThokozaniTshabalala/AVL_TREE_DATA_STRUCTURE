class VaccineArray {
     Vaccine[] data ;
     int records;
     int opCount0i;
     int opCount0s;

     public int getOpCount0s() {
          return opCount0s;
     }
     public VaccineArray()
     {
          this.data = new Vaccine[10000];
          this.records=0;
          this.opCount0i=0;
          this.opCount0s=0;

     }
     public void add(Vaccine v){
          opCount0i=0;
     data[records]=v;
     records++;
     opCount0i++;
     }

     public int getOpCount0i() {
          return opCount0i;
     }

     public Vaccine[] getData() {
          return data;
     }
     public Vaccine find(String line)
     {
          Vaccine vac = new Vaccine(line);
          //System.out.println( "   "+ this.records);
          this.opCount0s =0;
          for(int i = 0; i<this.records; i++)
          {
               this.opCount0s++;
               //System.out.println(opCount0s);
               if ((data[i].compareTo(vac))==0)
               {
                    return vac;
               }

          }
      return vac;
     }

     public Vaccine find(Vaccine p){
     int y=0;
     this.opCount0s=0;
     while (y!=records){
          opCount0s++;
          //System.out.println(opCount0s);
          if ((data[y].compareTo(p))==0){
               //opCount0s++;
               //System.out.println(opCount0s);
               return data[y];
               }
                     
          else {
               y++;
               }
          }

     return null;
     }


     //closes find method
}