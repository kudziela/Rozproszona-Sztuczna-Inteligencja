package main_package;

import my_exception.MyExceptionClass;

import java.io.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws MyExceptionClass, FileNotFoundException {

// Dane programu - > obiekty
        AllParking parking = new AllParking(7,7 ,10);
        ParkingPlace place = new ParkingPlace();
        VIParkingPLace viParkingPLace = new VIParkingPLace();
        Price allPrice = new Price();
        parking.makeMatrix();
        parking.makeVIPtable();
        int counterCars = 49;
        int counterVIPCars = 10;
        normalCar normalCar;
        String name, model, numberC;
        name = "";
        model = "";
        numberC = "";
        normalCar = new normalCar(name, model, numberC);
        normalCar[] allCars = new normalCar[counterCars];
        VIPcar[] allVIPcar = new VIPcar[counterVIPCars];
        normalCar.makeCarsTable();
        String promo = "promo";

        while(true){
            System.out.println();
            System.out.println("P A R K I N G ");
            System.out.println(" 1 - >  Wybierz miejsce parkingowe ");
            System.out.println(" 2 - >  Usuń miejsce parkingowe ");
            System.out.println(" 3 - >  Wyświetl wolne miejsca parkingowe");
            System.out.println(" 4 - >  Wyliczanie ceny postoju");
            System.out.println(" 5 - >  Wybierz miejsce parkingowe VIP");
            System.out.println(" 6 - >  Usuń miejsce parkingowe VIP");
            System.out.println(" 7 - >  Wyświetl miejsca VIP ");
            System.out.println(" 8 - >  Dane samochodu - dodaj auto ");
            //System.out.println(" 9 - > Wyświetl dane samochodow na parkingu  ");
            System.out.println(" 10 - > Ustawienia (tylko dla obsługi)");
            System.out.println(" 11 - >  KONIEC ");
            System.out.println("  ");

            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();

            switch (i) {
                case 1: {
                    // WYJĄTEK TRY CATCH
                    try {
                        System.out.println(" Podaj numer:  ");
                        int number = scanner.nextInt();
                        System.out.println(" Podaj rząd:  ");
                        int raw = scanner.nextInt();
                        place.setPlace(number - 1, raw - 1, parking);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.err.println("Nie ma takiego miejsca parkingowego!");
                    } finally {
                        System.out.println("Jeśli poprawnie wybrałeś/aś miejsce parkingowe przejdź do przeliczenia kwoty postoju");
                    }
                }
                break;

                case 2: {
                // WYJĄTEK
                    try{
                        System.out.println(" Podaj numer:  ");
                        int number = scanner.nextInt();
                        System.out.println(" Podaj rząd:  ");
                        int raw = scanner.nextInt();
                        place.unsetPlace(number-1, raw-1, parking);
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.err.println("Nie ma takiego miejsca parkingowego!");
                    }finally {
                        System.out.println("Jeśli poprawnie wybrałeś/aś miejsce parkingowe przejdź do przeliczenia kwoty postoju");
                    }
                }
                break;

                case 3: {
                    System.out.println(" Wolne miejsca - 0 ");
                    System.out.println(" Zajęte miejsca - 1 ");
                    parking.Print();
                }
                break;

                case 4: {
                    // wczytanie cennika cen
                    String line="";
                    FileInputStream priceFile =null;
                    try{
                        priceFile =new FileInputStream("cennnik.txt");
                    }catch (FileNotFoundException e){
                        System.out.println("eRRoR nie  ma pliku !!!" +e);
                        System.exit(-1);
                    }
                    try{
                        priceFile  =new FileInputStream("cennnik.txt");

                    }catch (FileNotFoundException e){
                        System.out.println("eRRoR nie  ma pliku !!!" +e);
                        System.exit(-1);
                    }
                    BufferedReader reader=new BufferedReader(new InputStreamReader(priceFile ));
                    try{
                        while((line=reader.readLine()) !=null){
                            System.out.println(line);
                        }

                    }catch(IOException e){
                        System.out.println("Blad");
                    }

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
// Mój własny wyjątek !
                case 5: {
                    String pass = "VIP";
                    System.out.println(" Podaj hasło dla konta VIP:  ");
                    String myPass = scanner.next();
                    if (pass.equals(myPass)) {
                        System.out.println(" Podaj numer miesjca VIP:  ");
                        int number = scanner.nextInt();
                        viParkingPLace.setVIPlace(number - 1, viParkingPLace);
                    }
                    else throw new MyExceptionClass("Podano złe hasło Vip");
                    }
                    break;

                case 6: {
                    System.out.println(" Podaj numer miesjca VIP:  ");
                    int number = scanner.nextInt();
                    viParkingPLace.unsetVIPlace(number-1, viParkingPLace);
                }
                    break;

                case 7: {
                    System.out.println(" Wolne miejsca - 0 ");
                    System.out.println(" Zajęte miejsca - 1 ");
                    parking.VIPrint();

                }
                break;

                case 8: {
                    System.out.println("Podaj numer na ktorym znajduje sie samochod");
                    int numberPlace = scanner.nextInt();
                   /* System.out.println("Podaj rzad w ktorym znajduje sie samochod");
                    int rawPlace = scanner.nextInt();
                    */
                    if (allCars[numberPlace] != null) {
                        System.out.println(" Tu już jest samochod !!! ");
                    }
                    else {
                        System.out.println("Podaj markę auta");
                        name = scanner.next();
                        System.out.println("Podaj model auta");
                        model = scanner.next();
                        System.out.println("Podaj numer rejestracyjny auta (bez liter)");
                        numberC = scanner.next();
                        normalCar = new normalCar(name, model, numberC);
                        allCars[numberPlace] = normalCar;
                    }
                }
                break;

                case 9:{
                        for(int k = 0; k < counterCars; k++){
                            System.out.print(k+1 + " -> ");
                            System.out.println("  Marka: " + allCars[k].name +
                                    "  Model:" + allCars[k].model +
                                    "  Numery: " + allCars[k].number);
                        }
                }
                break;

                case 10:
                {
                    String pass = "admin";
                    System.out.println(" Podaj hasło administratora:  ");
                    String myPass = scanner.next();
                    if (pass.equals(myPass)) {
                        System.out.println("Podaj imie i nazwisko pracownika oraz godzinę pracy - pracownik rano");
                        String workInfo1;
                        workInfo1 = scanner.next();
                        System.out.println("Podaj imie i nazwisko pracownika oraz godzinę pracy - pracownik wieczór");
                        String workInfo2;
                        workInfo2 = scanner.next();
                        CreateTxt createTxt = new CreateTxt();
                        createTxt.CreateTxt(workInfo1, workInfo2);
                    }
                    else throw new MyExceptionClass("Podano złe hasło Administratora");
                }

                default: {
                    System.exit(0);
                }

            }
        }


    }
}
