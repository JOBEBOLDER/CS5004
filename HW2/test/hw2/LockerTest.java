/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to test
 * "Locker"class,
 */

package hw2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test class for the Locker class.
 * This class performs unit tests to ensure the functionality
 * of the Locker class, including add mails and pickup mails availability,
 * and handling of invalid inputs.
 */
class LockerTest {
  private Locker locker;
  private Recipient recipient;
  private MailItem mailItem;

  @BeforeEach
  public void setUp() {
    locker = new Locker(10, 10, 10);
    recipient = new Recipient("Swift", "Taylor", "Taylor@Swift.com");
    mailItem = new MailItem(5, 5, 5, recipient);
  }

  /**
   * Tests adding a mail item to an empty locker.
   */
  @org.junit.jupiter.api.Test
  public void testAddMail_correct() {
    assertDoesNotThrow(() -> locker.addMail(mailItem));
  }

  /**
   * Tests adding a mail item to a locker that is already occupied.
   */
  @org.junit.jupiter.api.Test
  public void testAddMail_occupied() {
    locker.addMail(mailItem);
    MailItem addmail = new MailItem(3, 3, 3, recipient);
    Assertions.assertThrows(IllegalArgumentException.class, () -> locker.addMail(addmail));
  }


  /**
   * Tests adding a mail item that is too large for the locker dimensions.
   */
  @org.junit.jupiter.api.Test
  public void testAddMail_Large() {
    MailItem largeItem = new MailItem(13,13,13,recipient);
    Assertions.assertThrows(IllegalArgumentException.class, () -> locker.addMail(largeItem));

  }

  /**
   * Tests picking up a mail item when the recipient matches.
   */
  @org.junit.jupiter.api.Test
  public void pickupMail() {
    // Test picking up the correct mail item by a matching recipient
    locker.addMail(mailItem);
    assertEquals(mailItem, locker.pickupMail(recipient));

    // Test attempting to pick up mail with a non-matching recipient
    Recipient diffRecipient = new Recipient("COCO","chan","coco@chan.com");
    Assertions.assertNull(locker.pickupMail(diffRecipient));

    // Test attempting to pick up mail from an empty locker
    Assertions.assertNull(locker.pickupMail(recipient));
  }

  /**
   * Tests picking up a mail item when the recipient matches.
   */
  @org.junit.jupiter.api.Test
  public void testToString() {
    String expected = "Swift Taylor Email:Taylor@Swift.com";
    assertEquals(expected, recipient.toString());
  }





}
