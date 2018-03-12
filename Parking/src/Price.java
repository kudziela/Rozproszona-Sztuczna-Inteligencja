public class Price {

    double  price1Hour       = 4.5;
    double  priceRestHour    = 2.5;
    int     hours;

    public Price(){
    }

    public double computingPrice(int hours){
        double sumPrice;
        sumPrice = price1Hour + ( ( hours - 1 ) * priceRestHour );
        return sumPrice;
    }
}
