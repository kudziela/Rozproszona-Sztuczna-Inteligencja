public class VIParkingPLace extends AllParking {


    public VIParkingPLace(){}

    public void setVIPlace(int number, AllParking parking){
        if (parking.vipPlaces[number] == 1) {
            System.out.println("Miejsce VIP zajete");
        } else parking.vipPlaces[number] = 1;
    }

    public void unsetVIPlace(int number, AllParking parking){
        if (parking.vipPlaces[number] == 0) {
            System.out.println("Miejsce VIP wolne");
        } else parking.vipPlaces[number] = 0;
    }



}
