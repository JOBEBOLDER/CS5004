/*
 * 2024 spring CS5004
 * HW 1: Assignment 1: Writing a simple class and testing it
 * ( Testing 1 Electric Vehicles)
 * Cathy Chen
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the ElectricVehicle class.
 * This class contains tests to verify the functionality of the ElectricVehicle class,
 * including range calculation and efficiency updates based on temperature.
 */
public class ElectricVehicleTest {
  private ElectricVehicle Tesla;


  /**
   * Sets up the test environment.
   * This method is executed before each test.It initializes
   * and ElectricVehicle instance representing a Tesla Model S
   * with specified attributes.
   */
  @Before
  public void setUp() {
    Tesla = new ElectricVehicle("Tesla Model S", 100.0,
            1.0, 4.0);
  }

  /**
   * Tests the range calculation of th eElectricVehicle.
   * Verifies if the range method correctly calculates the vehicle's range.
   */
  @Test
  public void testRange() {
    double expectedRange = 100.0 * 1.0 * 4.0;
    assertEquals(expectedRange,Tesla.range(), 0.0);
  }

  /**
   * Tests the updateEfficiency method of the ElectricVehicle.
   * This test checks the method's functionality at normal,low,a
   * nd high temperature.
   */
  @Test
  public void testUpdateEfficiency() {
    //testing UpdateEfficiency method with NormalTemperature.
    Tesla.updateEfficiency(70.0);
    assertEquals(4.0, Tesla.getEfficiency(), 0.0);

    //testing UpdateEfficiency method with low Temperature.
    Tesla.updateEfficiency(63);
    assertEquals(3.92, Tesla.getEfficiency(), 0.0);

    //testing UpdateEfficiency method with high Temperature.
    Tesla.updateEfficiency(88);
    assertEquals(3.4, Tesla.getEfficiency(),0.0);

  }

  /**
   * Tests the string representation of the Tesla instance.
   */
  @Test
  public void testToString() {
    String a = Tesla.toString();
    assertEquals("Tesla Model S SOC: 100.0% Range (miles): 400.0", a);
  }


}
