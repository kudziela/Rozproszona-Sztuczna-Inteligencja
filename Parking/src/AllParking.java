public class AllParking {

   byte[][] allPlaces;
   int number;
   int raw;

   public AllParking(int number, int raw){
       this.number = number;
       this.raw = raw;
       allPlaces = new byte[number][raw];
   }

    public AllParking() {
    }

    public void makeMatrix(){
       for(int i=0; i< allPlaces.length; i++)
           for(int j=0; j< allPlaces[i].length; j++)
               allPlaces[i][j] = 0;
   }



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


}
