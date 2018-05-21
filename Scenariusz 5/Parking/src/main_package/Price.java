package main_package;

import java.io.*;

public class Price implements Serializable {

    double price1Hour = 4.5;
    double priceRestHour = 2.5;
    int hours;

    public Price() {
    }

    public double computingPrice(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException(" Godzina nie może być mniejsza od zera!" + hours);
        }
        if (hours > 24) {
            throw new IllegalArgumentException(" Doba ma tylko 24h! " + hours);
        }
        double sumPrice;
        sumPrice = price1Hour + ((hours - 1) * priceRestHour);
        return sumPrice;


    }

    public void readPrice(){

    }
}
