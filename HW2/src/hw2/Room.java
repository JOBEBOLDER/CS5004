/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Hotel Rooms> assignment, to construct
 * a 'Room' class.
 */

package hw2;

import java.util.Random;

/** Represents a room in a hotel booking system.
 * This class handles room booking ,occupancy checks,
 * and related information.
 */
public class Room {

  private final double price; // Price of the room per night.
  private int guestNumber; // Current number of guests in the room.
  private final RoomType roomType; // Type of the room.

  // constructor do not have any return type value even void
  /**
   *  Constructor for the Room class.
   *  Initializes a room with a specified type and price.
   * @param roomType The type of the room.
   * @param price The nightly price of the room.
   * @throws IllegalArgumentException if the price is negative.
   */
  public Room(RoomType roomType, double price) {
    if (price < 0) {
      throw new IllegalArgumentException(
              "The price of a room cannot be negative!"
      );
    }
    this.price = price;
    this.roomType = roomType;
    this.guestNumber = 0; // Initial guest count is zero.
  }

  /**
   * Determines the maximum number of guest allowed based on room types.
   * @return the maximum occupancy for the room.
   */
  private int getMaxOccupancy() {
    switch (roomType) {
      case SINGLE:
        return 1;
      case DOUBLE:
        return 2;
      case FAMILY:
        return 4;
      default:
        return 0; //  fallback-should not be reached
    }
  }

  /**
   * Checks if the room is currently available (no guests).
   * @return True if no guest are in the room,false otherwise.
   */
  public boolean isAvailable() {
    return guestNumber == 0;
  }

  /**
   * Attempts to book the room with the specified of guest.
   * A room can only be booked if it is currently available,
   * and the number of guests does not exceed the room's maximum occupancy.
   *
   * @param guests the number of guests to be booked into the room.
   * @return is the booking isn't successful return -1 and booking cannot be made.
   */
  public int bookRoom(int guests) {
    if (isAvailable() == true && 0 < guests && guests <= getMaxOccupancy()) {

      this.guestNumber = guests;
      return guests;
    }
    return -1;
  }

  /**
   * Generate a unique confirmed number for successful booking.
   * This implementation generates a random number between 1 and 1000.
   * @return the generated nique confirmation number for the booking.
   */
  private int confirmedNumber() {
    return new Random().nextInt(1000) + 1;
  }

  /**
   * Retrieves the current number of guests in the room.
   * @return the number of guests.
   */
  public int getNumberOfGuests() {
    return guestNumber;

  }


}
