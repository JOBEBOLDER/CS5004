/*
 * 2024 spring CS5004
 * Lab 1: Simple Classes & Testing
 * Cathy Chen
 */

package stock;

/**
 *  Represents a stock for trading purposes.
 */
@SuppressWarnings("checkstyle:Indentation")
public class Stock {
  private String symbol;
  private String name;
  private double costBasis;
  private double currentPrice;

  /**
   * Constructs a new Stock instance.
   *
   * @param symbol    the stock symbol
   * @param name     the name of the company
   * @param costBasis the original cost basis of the stock
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
  }

  /**
   * Returns the stock symbol.
   *
   * @return the stock symbol
   */
  public  String getSymbol() {
    return symbol;
  }

  /**
   * Gets the stock name.
   *
   * @return the stock name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the cost basis of the stock.
   *
   * @return the cost basis
   */
  public double getCostBasis() {
    return costBasis;
  }

  /**
   * Gets the current price of the stock.
   *
   * @return the current price
   */
  public double getCurrentPrice() {
    return currentPrice;
  }

  /**
   * Sets the current price of the stock.
   *
   * @param currentPrice the new current price
   * */
  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }

  /**
   * Sets the cost basis of the stock.
   *
   * @param costBasis the new cost basis
   */
  public void setCostBasis(double costBasis) {
    this.costBasis = costBasis;
  }

  /**
   * Calculates and returns the fractional change
   * between the original cost basis and the current price.
   * @return the fractional change, or Double.NaN if cost basis is zero
   */
  public double getChangePercent() {
    return (this.currentPrice - this.costBasis) / this.costBasis;
  }

  /**
   * Returns a string representation of the Stock instance,
   * showing the company name,current price, and gain/loss percentage.
   * @return a formatted string representing the stock.
   */
  @Override
  public String toString() {
    double changePercent = this.getChangePercent() * 100;
    return this.name + " Current Price: $ "
            + String.format("%.2f", this.currentPrice)
            + "\n Gain/Loss: " + String.format("%.2f", changePercent)
            + "%";
  }
}


