/*
 * 2024 spring CS5004
 * lab 2: Methods, Position and Velocity
 *
 * Cathy Chen
 */

package distance;

/**
 *Represents a point in 3D space.This class is immutable,one an instance is created,
 * its x,y,and z corrdinates cannot change.this class provide methods to access
 * these coordinates and to calculate the distance to another point in 3D space.
 */
public class Point3D {
  private final int x;
  private final int y;
  private final int z;

  /**
   * Constructs a default point at the origin of the coordinate space (0,0,0).
   */
  public Point3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  /**
   *  Constructs a point with specified x, y, and z coordinates.
   * @param x The x-coordinate of the new point.
   * @param y The y-coordinate of the new point.
   * @param z The z-coordinate of the new point.
   */
  public Point3D(int x, int y, int z) { // coco自身实例化
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Copy constructor. Creates a new point with the same coordinates as the input point.
   *
   * @param point3D The point from which to copy the coordinates.
   */
  public Point3D(Point3D point3D) { // 把coco变成kitu 的复制品
    this.x = point3D.getX();
    this.y = point3D.getY();
    this.z = point3D.getZ();
  }

  /**
   * Gets the x-coordinate of this point.
   *
   * @return The x-coordinate value of this point.
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y-coordinate of this point.
   *
   * @return The y-coordinate value of this point.
   */
  public int getY() {
    return y;
  }

  /**
   * Gets the z-coordinate of this point.
   *
   * @return The z-coordinate value of this point.
   */
  public int getZ() {
    return z;
  }

  /**
   * A method that calculates and answers (returns)
   * the distance between the current point and another point.
   * @param other the other instance that is created by Point3D.
   * @return the calculation result.
   */
  public double distanceTo(Point3D other) {
    //perform distance calculation.
    return Math.sqrt(Math.pow(other.x - this.x, 2)
            + Math.pow(other.y - this.y, 2)
            + Math.pow(other.z - this.z, 2));
  }

  /**
   * Compares this point to the specified object. The result is true if and only if
   * the argument is not null and is a Point3D object that has the same
   * coordinates as this object.
   *
   * @param obj The object to compare this Point3D against.
   * @return true if the given object represents a Point3D equivalent to
   *        this point, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      Point3D point3D = (Point3D) obj;
      return Double.compare(point3D.x, x) == 0
              && Double.compare(point3D.y, y) == 0
              && Double.compare(point3D.z, z) == 0;
    }
  }
}


