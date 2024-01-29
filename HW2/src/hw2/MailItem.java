/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to construct
 * a 'MailItem' class.
 */

package hw2;

/**Represents an immutable mail item specific dimensions and a recipient.
 *Once a mailItem is created, its properties cannot be changed.
 */
public class MailItem {
  private final int width;
  private final int height;
  private final int depth;
  private final Recipient recipient;

  /**
   *  Constructs a new MailItem with the specified dimensions and recipient.
   * @param width A width in inches, an integer greater than or equal to 1.
   * @param height  A height in inches, an integer greater than or equal to 1
   * @param depth A depth in inches, an integer greater than or equal to 1.
   * @param recipient A recipient of the mail item,must not be null.
   */
  public MailItem(int width, int height, int depth, Recipient recipient) {

    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException(
              "Please check your width and height and depth"
      );
    }
    this.width = width;
    this.height = height;
    this.depth = depth;

    if (recipient == null) {
      throw new IllegalArgumentException(
              "Recipient should not be empty!");
    }
    this.recipient = new Recipient(recipient.getFirstName(),
            recipient.getLastName(), recipient.getEmail());
  }

  /**
   * Returns the width of this mail item.
   *
   * @return the width in inches
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns the height of this mail item.
   *
   * @return the height in inches
   */
  public int getHeight() {
    return height;
  }

  /**
   * Returns the depth of this mail item.
   *
   * @return the depth in inches
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Returns the recipient of this mail item.
   *
   * @return the recipient object
   */
  public Recipient getRecipient() {
    return recipient;
  }

}
