package c09_ObjectsClasses;

public class Stock {
    //data fields
    private final String symbol;
    private final String name;
    double previousClosingPrice;
    double currentPrice;

    // constructor
    public Stock(String symbol,String name) {
        this.symbol = symbol;
        this.name = name;
    }

    //method
    public double getChangePercent() {
        return (currentPrice / previousClosingPrice - 1) * 100;
    }
    public void setCurrentPrice(double price) {
        currentPrice = price;
    }
    public void setPreviousClosingPrice(double price) {
        previousClosingPrice = price;
    }
    public String getSymbol(){
        return symbol;
    }
    public String getName(){
        return name;
    }
}
