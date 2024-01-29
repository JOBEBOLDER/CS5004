/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to construct
 * a 'Locker' class.
 */

package hw2;

/**
 * Represents a locker that can store a
 * single MailItem with their  maximum dimensions.
 */
public class Locker {
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;

  /**
   * Constructs a new Locker with the specified maximum dimensions.
   * @param maxWidth the maximum width of the locker in inches.
   * @param maxDepth the max depth of the locker in inches
   * @param maxHeight the max height of the locker in inches.
   * @throws IllegalArgumentException if any dimension is less than 1
   */
  public Locker(int maxWidth, int maxDepth, int maxHeight) {
    if (maxWidth < 1 || maxHeight < 1 || maxDepth < 1) {
      throw new IllegalArgumentException(
              "Please check your width and height and depth");
    }
    this.maxDepth = maxDepth;
    this.maxHeight = maxHeight;
    this.maxWidth = maxWidth;
    this.mailItem = null;
  }

  /**
   * Adds a mailitem to the locker if the locker is empty and
   * the mailitem fits into the locker dimension.
   * @param mail the mail item to be added.
   * @throws IllegalArgumentException if the mail is null or be
   *          occupied and beyond the dimension.
   */
  public void addMail(MailItem mail) {
    if (mail == null || this.mailItem != null
            || mail.getWidth() > this.maxWidth
            || mail.getDepth() > this.maxDepth
            || mail.getHeight() > this.maxHeight) {
      return;
    }
    this.mailItem = mail;
  }

  /**
   * Removes and returns the MailItem from the locker
   * if the recipient matches the mail item's recipient.
   * @param recipient the recipient of the mail item to be picked up
   * @return the removed MailItem if the recipient matches; null if there is
   *      no mail in the locker or the recipient does not match.
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null
         && this.mailItem.getRecipient().equals(recipient)) {
      MailItem sameEmail = this.mailItem;
      this.mailItem = null;
      return sameEmail;
    }
    return null;
  }
}
