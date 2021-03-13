public class Rectangle {
  private double x;
  private double y;
  private double w;
  private double h;

  /**
   * Constuctor for rectangle.
   * @param x double x coordinate of lower left corner
   * @param y double y coordinate of lower left corner
   * @param w double width
   * @param h double height
   * @throws IllegalArgumentException if width and height is negative
   */
  public Rectangle(double x, double y, double w, double h) throws IllegalArgumentException {
    if (w < 0 || h < 0) {
      throw new IllegalArgumentException("Width and height cannot be negative.");
    }

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getW() {
    return w;
  }

  public double getH() {
    return h;
  }

  /**
   * overlap determines if two rectangles overlap with each other.
   *
   * @param other Rectangle other rectangle
   * @return boolean true if they overlap, false if they do not
   */
  public boolean overlap(Rectangle other) {
    double l1x = this.x;
    double l1y = this.y;
    double r1x = this.x + this.w;
    double r1y = this.y + this.h;

    double l2x = other.getX();
    double l2y = other.getY();
    double r2x = other.getX() + other.getW();
    double r2y = other.getY() + other.getH();

    if (r1x <= l2x || r2x <= l1x) {
      return false;
    }

    if (r1y <= l2y || r2y <= l1y) {
      return false;
    }

    return true;
  }

  @Override
  public String toString() {
    return "x:" + this.x + ", " + "y:" + this.y + ", " + "w:" + this.w + ", " + "h:" + this.h;
  }
}
