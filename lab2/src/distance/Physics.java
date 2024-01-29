package distance;

/**
 * This class provides utility methods for physics calculations.
 */
public class Physics {
  /**
   * Calculates the velocity between two points in 3D space over a given time.
   * @param one The starting Point3D object.
   * @param two The ending Point3D object.
   * @param elapsedTime The time taken to move from point 'one' to point'two' .
   *                    must be positive.
   * @return The average velocity between the two points.
   * @throws IllegalArgumentException If the elapsed time is less than or equal to zero.
   */

  public static double velocity(Point3D one, Point3D two, double elapsedTime) {
    if (elapsedTime <= 0) {
      throw new IllegalArgumentException("Elapsed time must not be negative!");
    }

    double distance = one.distanceTo(two);
    return distance / elapsedTime;

  }


}

