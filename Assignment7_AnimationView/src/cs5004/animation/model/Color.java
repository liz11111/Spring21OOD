package cs5004.animation.model;

/**
 * Color is a helper class that represents the RGB data for a color.
 */
public class Color {

  private final double r;
  private final double g;
  private final double b;

  /**
   * Constructor for Color.
   *
   * @param r int R
   * @param g int G
   * @param b int B
   * @throws IllegalArgumentException if RGB values are invalid
   */
  public Color(double r, double g, double b) throws IllegalArgumentException {
    if (outOfBound(r, g, b)) {
      throw new IllegalArgumentException("RGB values must be between 0 and 255.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * outOfBound checks if the RGB values are valid.
   *
   * @param r int R
   * @param g int G
   * @param b int B
   * @return boolean whether the values are valid
   */
  private boolean outOfBound(double r, double g, double b) {
    return r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
  }

  public double getR() {
    return this.r;
  }

  public double getG() {
    return this.g;
  }

  public double getB() {
    return this.b;
  }

  @Override
  public String toString() {
    return "(" + r + "," + g + "," + b + ")";
  }

}
