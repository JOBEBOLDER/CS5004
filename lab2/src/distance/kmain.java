package distance;

/**
 * A test case that is used to test the Physics and Point3D class，
 * A expection will occur if there is an error.
 */
public class kmain {
  /**
   * implement a static main method which is using to test
   * the Physics and Point3D class，
   * Ensure the code developed and runs without issue.
   * @param args String[]
   */

  public static void main(String [] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1,1,1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 5);
      System.out.println("zprof.Keith is on the move! His Velocity is " + velocity);
      System.out.println("Velocity =" + velocity);
    }
    catch (IllegalArgumentException e) {
      System.out.println("Encountered an error : " + e.getMessage());
    }
  }
}
