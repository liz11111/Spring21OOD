package Shape;

/**
 * Color is a helper class that represents the RGB data for a color.
 */
public class Color {
  private int r;
  private int g;
  private int b;

  /**
   * Constructor for Color.
   *
   * @param r int R
   * @param g int G
   * @param b int B
   * @throws IllegalArgumentException if RGB values are invalid
   */
  public Color(int r, int g, int b) throws IllegalArgumentException {
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
  private boolean outOfBound(int r, int g, int b) {
    return r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
  }

  /**
   * getter for R.
   *
   * @return int r
   */
  public int getR() {
    return r;
  }

  /**
   * getter for G.
   *
   * @return int g
   */
  public int getG() {
    return g;
  }

  /**
   * getter for B.
   *
   * @return int b
   */
  public int getB() {
    return b;
  }

  @Override
  public String toString() {
    return "(" + r + "," + g + "," + b + ")";
  }
}
