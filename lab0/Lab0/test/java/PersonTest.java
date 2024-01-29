import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;

  /**
   * the method is set to initiating the setup environment.
   */
  @Before
  public void setUp() {
    john = new Person("John", "Doe", 1945);
  }

  /**
   * the method is setting to testing the getFirstName function.
   */
  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());

  }

  /**
   * the method is setting to testing the getLastName function.
   */
  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  /**
   * the method is setting to testing the getYearOfBirth function.
   */
  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }

}
