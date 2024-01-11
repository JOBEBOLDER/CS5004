package Stock;


/**
 *  Represents a stock for trading purposes.
 */

public class Stock {
    private String symbol;
    private String name;
    private double costBasis;
    private double currentPrice;

    public Stock(String symbol, String getName, double costBasis){
        this.symbol = symbol;
        this.name = name;
        this.costBasis = costBasis;
    }

    public  String getSymbol(){
        return symbol;
    }
    public String getGetName(){
        return name;
    }
    public double getCostBasis(){

        return costBasis;
    }
    public double getCurrentPrice(){
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }

    public void setCostBasis(double costBasis){
        this.costBasis = costBasis;
    }

    public double getChangePercent(){
        return (currentPrice - costBasis) / costBasis;
    }

    public String toString(){
        double changePercent = getChangePercent() * 100;
        return name + " Current Price: $ " + String.format("%.2f", currentPrice) +
                "\n Gain/Loss: " + String.format("%.2f", changePercent) + "%";
    }
}


