package main_package;

public class AllParking implements Print {
// klasa AllParking implementuje interfejs Print
   byte[][] allPlaces;
   byte[] vipPlaces;
   int number;
   int raw;
   int vipNumber;

   public AllParking(int number, int raw, int VIPnumber){
       this.number = number;
       this.raw = raw;
       this.vipNumber = VIPnumber;
       allPlaces = new byte[number][raw];
       vipPlaces = new byte[VIPnumber];
   }

    public AllParking() {
    }

    public void makeMatrix(){
       for(int i=0; i< allPlaces.length; i++)
           for(int j=0; j< allPlaces[i].length; j++)
               allPlaces[i][j] = 0;
   }

    public void makeVIPtable() {
        for (int i = 0; i < vipPlaces.length; i++) {
            vipPlaces[i] = 0;
        }
    }


// I N T E R F E J S Y
   public void Print(){
       for(int i=0; i< allPlaces.length; i++) {
           System.out.print(i+1);
           System.out.print("  -  ");
           for (int j = 0; j < allPlaces[i].length; j++) {
               System.out.print(allPlaces[i][j]);
           }
           System.out.println();
       }
   }

    public void VIPrint(){
        for(int i=0; i< vipPlaces.length; i++) {
            System.out.print(i+1);
            System.out.print("  -  ");
            System.out.println(vipPlaces[i]);
        }
    }


}
