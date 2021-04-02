package Shape;

public class Color {
  private int r;
  private int g;
  private int b;

  public Color(int r, int g, int b) throws IllegalArgumentException {
    if (outOfBound(r, g, b)) {
      throw new IllegalArgumentException("RGB values must be between 0 and 255.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  private boolean outOfBound(int r, int g, int b) {
    return r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255;
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

  @Override
  public String toString() {
    return "(" + r + "," + g + "," + b + ")";
  }
}
