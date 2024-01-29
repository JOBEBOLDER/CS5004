/*
 * 2024 spring CS5004
 * Lab 1: Simple Classes & Testing
 * Cathy Chen
 */

package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 *Tests the Stock class.
 */
public class TestStock {
  private Stock stock;

  /**
   * Sets up a Stock instance before each test method.
   */
  @Before//测试的前置方法，
  public void setUp() {
    // This method will be executed before each test method
    stock = new Stock("GOOGL", "Alphabet Inc.",
            1500.0);
  }

  /**
   * Tests getting the stock symbol.
   */
  @Test
  public void testGetSymbol() {
    assertEquals("GOOGL",
            stock.getSymbol());
  }

  /**
   * Tests getting the stock name.
   */
  @Test
  public void testGetName() {
    assertEquals("Alphabet Inc.",
            stock.getName());
  }

  /**
   * Tests setting and getting the cost basis of the stock.
   */
  @Test
  public void testCostBasis() {
    stock.setCostBasis(120.0);
    assertEquals(120.0, stock.getCostBasis(), 0.0);
  }

  /**
   * Tests setting and getting the current price of the stock.
   */
  @Test
  public void testCurrentPrice() {
    stock.setCurrentPrice(150.0);
    assertEquals(150.0, stock.getCurrentPrice(), 0.0);
  }

  /**
   * Tests calculating the percentage change in stock price.
   */
  @Test
  public void testGetChangePercent() {
    stock.setCurrentPrice(150.0);
    assertEquals(-0.90, stock.getChangePercent(), 0.0);
  }

  /**
   * Tests the string representation of the Stock instance.
   */
  @Test
  public void testToString() {
    stock.setCurrentPrice(150.0);
    String expected = "Alphabet Inc. Current Price: $ 150.00\n "
            + "Gain/Loss: -90.00%";
    assertEquals(expected, stock.toString());
  }



}
