public class normalCar extends Car{
// klasa normal Car dziedziczy z Car
    normalCar[] cars;
    int numberOfCars;

    public normalCar(String name, String model, String number){
        this.name = name;
        this.model = model;
        this.number = number;
    }

    public normalCar(){
    }

    public void makeCarsTable() {
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = null;
        }


    }
}
