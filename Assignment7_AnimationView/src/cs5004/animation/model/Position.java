package cs5004.animation.model;

/**
 * Position is a helper class that represents the position of a shape.
 */
public class Position {

  private final double x;
  private final double y;

  /**
   * Constructor for Position.
   *
   * @param x double x
   * @param y double y
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return "(" + String.format("%.1f", this.x) + "," + String.format("%.1f", this.y) + ")";
  }
}