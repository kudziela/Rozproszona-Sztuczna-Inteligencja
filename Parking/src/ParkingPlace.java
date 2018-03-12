public class ParkingPlace extends AllParking {

   int number;
   int raw;
   AllParking parking = new AllParking();


   public ParkingPlace(){
   }


    public void setPlace(int number, int raw, AllParking parking){
        if (parking.allPlaces[number][raw] == 1) {
            System.out.println("Miejsce zajete  ");
        } else parking.allPlaces[number][raw] = 1;
    }

    public void unsetPlace(int number, int raw, AllParking parking){
        if (parking.allPlaces[number][raw] == 0) {
            System.out.println("Miejsce wolne  ");
        } else parking.allPlaces[number][raw] = 0;
    }

}
