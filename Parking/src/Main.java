import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        AllParking parking = new AllParking(5,5 );
        ParkingPlace place = new ParkingPlace();
        Price allPrice = new Price();
        parking.makeMatrix();
        String promo = "promo";

        while(true){
            System.out.println();
            System.out.println("P A R K I N G ");
            System.out.println(" 1 - >  Wybierz miejsce parkingowe ");
            System.out.println(" 2 - >  Usuń miejsce parkingowe ");
            System.out.println(" 3 - >  Wyświetl wolne miejsca parkingowe");
            System.out.println(" 4 - >  Wyliczanie ceny postoju");

            System.out.println(" 6 - >  KONIEC ");
            System.out.println("  ");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            switch (i) {
                case 1: {
                    System.out.println(" Podaj numer:  ");
                    int number = scanner.nextInt();
                    System.out.println(" Podaj rząd:  ");
                    int raw = scanner.nextInt();
                    place.setPlace(number-1, raw-1, parking);
                }
                break;

                case 2: {
                    System.out.println(" Podaj numer:  ");
                    int number = scanner.nextInt();
                    System.out.println(" Podaj rząd:  ");
                    int raw = scanner.nextInt();
                    place.unsetPlace(number-1, raw-1, parking);
                }
                break;

                case 3: {
                    System.out.println(" Wolne miejsca - 0 ");
                    System.out.println(" Zajęte miejsca - 1 ");
                    parking.Print();

                }
                break;

                case 4: {
                    System.out.println("Podaj czas postoju (godziny)");
                    int hours = scanner.nextInt();
                    double price = allPrice.computingPrice(hours);
                    System.out.println("Kwota do zapłaty: " + price);

                    System.out.println("Czy posiadasz kod rabatowy? (T/N)");
                    char yesNo = scanner.next().charAt(0);
                    if(yesNo=='T') {
                        System.out.println("Podaj kod rabatowy");
                        //=======
                        String promotionCode = scanner.next();
                        if (promo.equals(promotionCode)) {
                            price = price - 0.5 * price;
                            System.out.println("Kwota do zapłaty: " + price);
                        }
                        else {
                            System.out.println("Kod niepoprawny");
                        }

                    }
                }
                break;

                default: {
                    System.exit(0);
                }

            }
        }












    }
}
