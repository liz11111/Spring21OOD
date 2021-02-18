/**
 * Vector3D class represents a 3D vector. It has attributes x, y, z coordinates and methods
 * associated with vector operations.
 */

public class Vector3D {
  private double x;
  private double y;
  private double z;

  /**
   * Constructor that instantiates a new Vector3D object by taking x, y, z parameters.
   * @param x double represents x coordinate of the vector
   * @param y double represents y coordinate of the vector
   * @param z double represents z coordinate of the vector
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Getter method for parameter X.
   * @return double X coordinate of vector
   */
  public double getX() {
    return x;
  }

  /**
   * Getter method for parameter Y.
   * @return double Y coordinate of vector
   */
  public double getY() {
    return y;
  }

  /**
   * Getter method for parameter Z.
   * @return double Z coordinate of vector
   */
  public double getZ() {
    return z;
  }

  /**
   * toString method returns a String representation of vector in form of "(x,y,z)".
   * @return String representation of the vector
   */
  public String toString() {
    String x = String.format("%.2f", this.x);
    String y = String.format("%.2f", this.y);
    String z = String.format("%.2f", this.z);
    return "(" + x + "," + y + "," + z + ")";
  }

  /**
   * getMagnitude returns the magnitude of the 3D vector.
   * @return double magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(x * x + y * y + z * z);
  }

  /**
   * normalize returns a normalized version of the 3D vector without modifying the original one.
   * @return Vector3D a normalized version of the vector
   * @throws IllegalStateException if magnitude of the vector was 0
   */
  public Vector3D normalize() throws IllegalStateException {
    double magnitude = getMagnitude();
    if (magnitude == 0.0) {
      throw new IllegalStateException("Attempting to divide by 0.");
    }
    return new Vector3D(this.x / magnitude, this.y / magnitude, this.z / magnitude);
  }

  /**
   * add returns the result of adding the vector to other 3D vector.
   * @param other Vector3D object to be added
   * @return Vector3D result of addition
   */
  public Vector3D add(Vector3D other) {
    if (other == null) {
      return new Vector3D(this.x, this.y, this.z);
    }

    return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
  }

  /**
   * multiply returns the result of multiplying the vector by a constant.
   * @param c double constant to be multiplied
   * @return Vector3D object result of multiplication
   */
  public Vector3D multiply(double c) {
    return new Vector3D(c * this.x, c * this.y, c * this.z);
  }

  /**
   * dotProduct returns the dot product of this vector and another vector.
   * @param other Vector3D object
   * @return double result of taking dot product
   */
  public double dotProduct(Vector3D other) {
    return this.x * other.x + this.y * other.y + this.z * other.z;
  }

  /**
   * angleBetween returns the smaller angle between the two vectors.
   * @param other Vector3D object to calculate angle with
   * @return double angle between two vectors in degrees
   * @throws IllegalStateException if either one of magnitude of the vectors was zero
   */
  public double angleBetween(Vector3D other) throws IllegalStateException {
    double mag1 = this.getMagnitude();
    double mag2 = other.getMagnitude();

    if (mag1 == 0.0 || mag2 == 0.0) {
      throw new IllegalStateException("Attempting to divide by 0.");
    }

    double dotProd = dotProduct(other);

    return Math.acos(dotProd / (mag1 * mag2)) * (180 / Math.PI);
  }
}
