/*
 * 2024 spring CS5004
 * HW 1: Assignment 1: Writing a simple class and testing it(1 Electric Vehicles)
 * Cathy Chen
 */

package electricvehicle;

import java.text.DecimalFormat;

/**
 * Represents an electric vehicle.
 * This class models an electric vehicle's key attribute such as name,battery size, state of charge,
 * current efficiency, and default efficiency. it provides methods to calculate the range and update
 * the efficiency based on the temperature.
 */

public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private final double defaultEfficiency;


  /**
   * Constructs an ElectricVehicle.ElectricVehicle with specified attributes.
   * Initializes and clamps name, battery size, state of charge, and default efficiency.
   *
   * @param name              Name of the electric vehicle, defaults to "unknown EV" if empty.
   * @param batterySize       Battery size in kWh, clamped between 10.0 and 150.0 kWh.
   * @param stateOfCharge     State of charge as a decimal, clamped between 0.15 and 1.0.
   * @param defaultEfficiency Default efficiency, clamped between 0.5 and 4.5.
   */
  public ElectricVehicle(String name, double batterySize,
                         double stateOfCharge, double defaultEfficiency) {
    this.name = (name == "" || name.isEmpty()) ? "unknown EV" : name;

    if (stateOfCharge <= 0.15) {
      this.stateOfCharge = 0.15;
    } else if (stateOfCharge >= 1.00) {
      this.stateOfCharge = 1.00;
    } else {
      this.stateOfCharge = stateOfCharge;
    }

    if (batterySize <= 10.00) {
      this.batterySize = 10.00;
    } else if (batterySize >= 150.00) {
      this.batterySize = 150.00;
    } else {
      this.batterySize = batterySize;
    }

    if (defaultEfficiency <= 0.5) {
      this.defaultEfficiency = 0.5;
    } else if (defaultEfficiency >= 4.5) {
      this.defaultEfficiency = 4.5;
    } else {
      this.defaultEfficiency = defaultEfficiency;
    }

    this.currentEfficiency = this.defaultEfficiency;

  }

  /**
   * Calculates and returns the range of the electric vehicle.
   * The range is determined by multiplying the params below.
   *
   * @return The calculated range of the vehicle.
   */
  public double range() {
    return currentEfficiency * stateOfCharge * batterySize;
  }


  /**
   * Updates the current efficiency of the electric vehicle based on the current temperature.
   * The efficiency is adjusted according to the temperature and ranges.
   *
   * @param currentTemp The current temperature in Fahrenheit.
   */
  public void updateEfficiency(double currentTemp) {
    if (65.0 <= currentTemp && currentTemp <= 77.0) {
      currentEfficiency = defaultEfficiency;
    } else if (currentTemp > 77.0) {
      currentEfficiency = 0.85 * defaultEfficiency;
    } else {
      //// Calculate the reduction in efficiency: 1% for each degree below 65, up to 50%.
      double decreasePart = Math.min(50, 65.0 - currentTemp) * 0.01;
      currentEfficiency = (1 - decreasePart) * defaultEfficiency;

      //Checks if the current efficiency is less than 50% of the default efficiency,
      // and if so, we set it to 50% of the default efficiency.
      currentEfficiency = Math.max(currentEfficiency, 0.5 * defaultEfficiency);
    }

  }

  /**
   * Gets the name of the electric vehicle.
   *
   * @return The name of the vehicle.
   */
  public String getName() {
    return name;
  }

  /**
   *  Sets the name of the electric vehicle.
   *
   * @param name The new name to be set for the vehicle.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the BatterySize of the electric vehicle.
   *
   * @return The BatterySize of the vehicle.
   */
  public double getBatterySize() {
    return batterySize;
  }

  /**
   * Sets the battery size of the electric vehicle.
   *
   * @param batterySize The batterysize of the electric vehicle.
   */
  public void setBatterySize(double batterySize) {
    this.batterySize = batterySize;
  }

  /**
   * Gets the current state of charge of the electric vehicle's battery.
   *
   * @return The current state of charge as a decimal.
   */
  public double getStateOfCharge() {
    return stateOfCharge;
  }

  /**
   * Sets the current state of charge of the electric vehicle's battery.
   *
   * @param stateOfCharge The new state of charge as a decimal.
   */
  public void setStateOfCharge(double stateOfCharge) {
    this.stateOfCharge = stateOfCharge;
  }

  /**
   * Gets the current efficiency of the electric vehicle.
   *
   * @return The current efficiency.
   */
  public double getCurrentEfficiency() {
    return currentEfficiency;
  }

  /**
   * Sets the current efficiency of the electric vehicle.
   *
   * @param currentEfficiency The new current efficiency.
   */
  public void setCurrentEfficiency(double currentEfficiency) {
    this.currentEfficiency = currentEfficiency;
  }

  /**
   * Gets the default efficiency of the electric vehicle.
   *
   * @return The default efficiency.
   */
  public double getDefaultEfficiency() {
    return defaultEfficiency;
  }

  /**
   * Provides a string representation of the ElectricVehicle.ElectricVehicle instance.
   * The string includes the name, state of charge in percentage, and the calculated range.
   *
   * @return A formatted string representing the electric vehicle's status.
   */
  @Override
  public String toString() {
    DecimalFormat pre = new DecimalFormat("0.0");
    return name + "SOC:" + this.stateOfCharge + "% Range (miles):" + this.range();
  }

}

