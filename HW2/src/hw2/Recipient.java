/*
 * 2024 spring CS5004 :Jieyao Chen
 * HW 2: Assignment 2: Methods, Packages and Exceptions
 * This file is part of the <Locker Storage> assignment, to construct
 * a 'Recipient' class.
 */

package hw2;

import java.util.Objects;

/**
 ** The {@code Recipient} class represents a recipient with
 *  first name, last name, and email address.
 * This class provides methods to set the email address and
 * check for equality with other Recipient objects.
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private String email;

  /**
   * Constructs a new Recipient with the specified first name,
   * last name, and email address.
   * @param firstName the first name of the recipient.
   * @param lastName the last name of the recipient.
   * @param email the email address of the recipient.
   */
  public Recipient(String firstName, String lastName, String email) {
    if (firstName == null || firstName.isEmpty()
            || lastName == null || lastName.isEmpty()
            || email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Please check your firstname, "
              + "lastname and email,any of those can not be empty!!");
    }

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  /**
   * Sets the email address of this recipient.
   * @param email Sets the new email address of the recipient.
   */
  public void setEmail(String email) {
    if (email == null || email.isEmpty()) {
      throw new IllegalArgumentException(
              "Please check your email,it should not be empty!"
      );
    }
    this.email = email;
  }

  /**
   *To compare the current Recipient to another Recipient for equality.
   * @param obj To compare the obj and this recipient
   * @return true if the given object is equal to this recipient.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) obj;
    return Objects.equals(firstName, recipient.firstName)
            && Objects.equals(lastName, recipient.lastName)
            && Objects.equals(email, recipient.email);
  }

  /**
   * Return a string representation of this recipient.
   * @return a String representation of this recipient.
   */
  public String toString() {
    return firstName + " " + lastName + " " + "Email:" + email;
  }
}
