/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to test the
 * Recipient class.
 */

package hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Locker class.
 * This class performs unit tests to ensure the functionality
 * of the Locker class, including several getter methods,and cavailability,
 * and handling of invalid inputs.
 */
class RecipientTest {

  private Recipient recipient;

  /**
   * Sets up a Recipient object for each test.
   */
  @BeforeEach
  void setUp() {
    recipient = new Recipient("Chan", "Coco", "Chan.Coco@example.com");
  }

  /**
   * Tests the constructor with valid arguments to ensure proper assignment of properties.
   */
  @Test
  void testConstructor_ValidArguments() {
    Assertions.assertEquals("Chan", recipient.getFirstName());
    Assertions.assertEquals("Coco", recipient.getLastName());
    Assertions.assertEquals("Chan.Coco@example.com", recipient.getEmail());
  }

  /**
   * Tests the constructor with null or empty arguments to
   * ensure IllegalArgumentException is thrown.
   */
  @Test
  void testConstructor_NullOrEmptyArguments() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new Recipient(null, "Coco", "jane.Coco@example.com"));
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new Recipient("Jane", "", "jane.Coco@example.com"));
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new Recipient("Jane", "Coco", null));
  }

  /**
   * Tests setEmail with a valid email to ensure the email property is updated correctly.
   */
  @Test
  void testSetEmail_ValidEmail() {
    recipient.setEmail("jane.Coco@example.com");
    assertEquals("jane.Coco@example.com", recipient.getEmail());
  }

  /**
   * Tests setEmail with null or empty email to ensure IllegalArgumentException is thrown.
   */
  @Test
  void testSetEmail_NullOrEmptyEmail() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> recipient.setEmail(null));
    Assertions.assertThrows(IllegalArgumentException.class, () -> recipient.setEmail(""));
  }

  /**
   * Tests the equals method to ensure it returns true for objects with the same property values.
   */
  @Test
  void testEquals_SameObject() {
    Recipient sameRecipient = new Recipient("Chan", "Coco", "Chan.Coco@example.com");
    Assertions.assertTrue(recipient.equals(sameRecipient));
  }

  /**
   * Tests the equals method to ensure it returns false for objects with different property values.
   */
  @Test
  void testEquals_DifferentObject() {
    Recipient differentRecipient = new Recipient("Jane", "Roe", "jane.roe@example.com");
    Assertions.assertFalse(recipient.equals(differentRecipient));
  }

  /**
   * Tests the toString method to ensure it returns the correct string representation of the object.
   */
  @Test
  void testToString() {
    String expectedString = "Chan Coco Email:Chan.Coco@example.com";
    assertEquals(expectedString, recipient.toString());
  }
}
