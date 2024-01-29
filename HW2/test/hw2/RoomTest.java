/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to test the
 * Room class.
 */

package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for the Room class.
 * This class performs unit tests to ensure the functionality
 * of the Room class, including room booking, checking room availability,
 * and handling of invalid inputs.
 */
class RoomTest {
  private Room singleRoom;
  private Room doubleRoom;
  private Room familyRoom;

  @BeforeEach
  void setUp() {
    singleRoom = new Room(RoomType.SINGLE, 800);
    doubleRoom = new Room(RoomType.DOUBLE, 1000);
    familyRoom = new Room(RoomType.FAMILY, 2000);
  }

  @org.junit.jupiter.api.Test
  void testIsAvailable() {
    Assertions.assertEquals(true, singleRoom.isAvailable(),
            "Newly created single room should be available");
    Assertions.assertEquals(true, doubleRoom.isAvailable(),
            "Newly created single room should be available");
    Assertions.assertEquals(true, familyRoom.isAvailable(),
            "Newly created single room should be available");

    singleRoom.bookRoom(1);
    Assertions.assertEquals(false, singleRoom.isAvailable(),
            "Room should still be unavailable after failed booking");

    doubleRoom.bookRoom(2);
    Assertions.assertEquals(false, doubleRoom.isAvailable(),
            "Room should still be unavailable after failed booking");

    familyRoom.bookRoom(3);
    Assertions.assertEquals(false, familyRoom.isAvailable(),
            "Room should still be unavailable after failed booking");
  }

  private void assertEquals(boolean b, boolean available, String s) {
  }

  @org.junit.jupiter.api.Test
  void testBookRoom() {
    Assertions.assertEquals(1, singleRoom.bookRoom(1));
    Assertions.assertEquals(-1 ,singleRoom.bookRoom(2));

    Assertions.assertEquals(2, doubleRoom.bookRoom(2));
    Assertions.assertEquals(-1,doubleRoom.bookRoom(3));

    Assertions.assertEquals(3, familyRoom.bookRoom(3));
    Assertions.assertEquals(-1,familyRoom.bookRoom(6));

  }


  @org.junit.jupiter.api.Test
  void testGetNumberOfGuests() {
    singleRoom.bookRoom(1);
    Assertions.assertEquals(1, singleRoom.getNumberOfGuests());

    doubleRoom.bookRoom(2);
    Assertions.assertEquals(2, doubleRoom.getNumberOfGuests());

    familyRoom.bookRoom(3);
    Assertions.assertEquals(3, familyRoom.getNumberOfGuests());
  }


  /**
   * Tests the Room constructor with an invalid price.
   * Expects an IllegalArgumentException to be thrown for negative prices.
   */
  @org.junit.jupiter.api.Test
  public void testInvalidPrice() {
    Assertions.assertThrows(IllegalArgumentException.class, ()
            -> new Room(RoomType.DOUBLE, -100));
  }


}