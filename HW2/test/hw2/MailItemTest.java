/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to test
 * MailItem class,
 */

package hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the MailItem.
 * Validates that the MailItem properties are correctly assigned and managed.
 */
class MailItemTest {

  private MailItem mailItem;
  private Recipient recipient;

  /**
   * Sets up a MailItem and Recipient object for each test.
   */
  @BeforeEach
  void setUp() {
    recipient = new Recipient("Chan", "Coco", "Chan.Coco@example.com");
    mailItem = new MailItem(10, 5, 2, recipient);
  }

  /**
   * Tests whether the MailItem constructor assigns valid arguments correctly.
   */
  @Test
  void testConstructor_ValidArguments() {
    Assertions.assertEquals(10, mailItem.getWidth());
    Assertions.assertEquals(5, mailItem.getHeight());
    Assertions.assertEquals(2, mailItem.getDepth());
    Assertions.assertNotNull(mailItem.getRecipient());
  }

  /**
   * Tests the MailItem constructor's response to invalid dimension arguments.
   */
  @Test
  void testConstructor_InvalidDimensions() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new MailItem(0, 5, 2, recipient));
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new MailItem(10, 0, 2, recipient));
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new MailItem(10, 5, 0, recipient));
  }

  /**
   * Tests the MailItem constructor's response to a null recipient argument.
   */
  @Test
  void testConstructor_NullRecipient() {
    Assertions.assertThrows(IllegalArgumentException.class, () ->
            new MailItem(10, 5, 2, null));
  }

  /**
   * Tests if the getWidth method returns the correct width.
   */
  @Test
  void testGetWidth() {
    Assertions.assertEquals(10, mailItem.getWidth());
  }

  /**
   * Tests if the getHeight method returns the correct height.
   */
  @Test
  void testGetHeight() {
    Assertions.assertEquals(5, mailItem.getHeight());
  }

  /**
   * Tests if the getDepth method returns the correct depth.
   */
  @Test
  void testGetDepth() {
    Assertions.assertEquals(2, mailItem.getDepth());
  }

  /**
   * Tests if the getRecipient method returns the correct recipient.
   */
  @Test
  void testGetRecipient() {
    Recipient expectedRecipient = new Recipient("Chan", "Coco", "Chan.Coco@example.com");
    Assertions.assertEquals(expectedRecipient, mailItem.getRecipient());
  }
}
