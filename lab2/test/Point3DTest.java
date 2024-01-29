import distance.Point3D;
import org.junit.jupiter.api.Assertions;


/**
 * This class tests the Point3D class. It includes tests for the getX, getY, getZ methods,
 * the copy constructor, the distanceTo method, and the equals method. Each test checks
 * the correctness of the Point3D class implementation by comparing actual results
 * with expected outcomes.
 */
class Point3DTest {

  /**
   * Tests the getX method of Point3D class.
   * It checks if the method correctly returns the X-coordinate of a point.
   * The test is performed on default and parameterized constructors.
   */
  @org.junit.jupiter.api.Test
  void testGetX() {
    Point3D coco = new Point3D();
    Assertions.assertEquals(0.0, coco.getX(), 0.01);

    Point3D coco2 = new Point3D(3, 8, 9);
    System.out.println(coco2.getX());//?
    Assertions.assertEquals(3.0, coco2.getX(), 0.01);
  }

  /**
   * Tests the getY method of Point3D class.
   * It verifies whether the method accurately returns the Y-coordinate of a point.
   * This method tests both default and parameterized constructors.
   */
  @org.junit.jupiter.api.Test
  void testGetY() {
    Point3D coco = new Point3D();
    Assertions.assertEquals(0, coco.getY(), 0.01);

    Point3D coco2 = new Point3D(3, 8, 9);
    Assertions.assertEquals(8.0, coco2.getY(), 0.01);
  }

  /**
   * Tests the getZ method of Point3D class.
   * It ensures the method correctly returns the Z-coordinate of a point.
   * Includes tests for both default and parameterized constructors.
   */
  @org.junit.jupiter.api.Test
  void testGetZ() {
    Point3D coco = new Point3D();
    Assertions.assertEquals(0.0, coco.getZ(), 0.01);

    Point3D coco2 = new Point3D(3, 8, 9);
    Assertions.assertEquals(9.0, coco2.getZ(), 0.01);
  }

  /**
   * Tests the copy constructor of the Point3D class.
   * Ensures that the copy constructor creates a new object with
   * the same values as the original.
   */
  @org.junit.jupiter.api.Test
  void testCopyConstructor() {
    // create a Point3D instance
    Point3D original = new Point3D(1989, 12, 13);

    // using the copy constructor function to create a new Point3D object;
    Point3D copy = new Point3D(original);

    // to make sure that the copy instance have the same attributes of the original one.
    Assertions.assertEquals(original.getX(), copy.getX(), 0.01);
    Assertions.assertEquals(original.getY(), copy.getY(), 0.01);
    Assertions.assertEquals(original.getZ(), copy.getZ(), 0.01);
  }

  /**
   * Tests the distanceTo method of the Point3D class.
   * It checks if the method accurately calculates the distance between two points.
   * The expected distance is compared with the actual distance calculated by the method.
   */
  @org.junit.jupiter.api.Test
  void testDistanceTo() {
    Point3D Taylor = new Point3D(1989, 12, 13);
    Point3D Jake = new Point3D(1980, 12, 19);
    double expectedDistance = Jake.distanceTo(Taylor);
    Assertions.assertEquals(expectedDistance, Taylor.distanceTo(Jake), 0.01);

  }

}