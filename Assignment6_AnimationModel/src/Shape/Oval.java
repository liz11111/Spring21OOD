package Shape;

public class Oval extends AbstractShape {
  protected double radius;
  private double verticalRadius;
  public Oval(String name, Position position, Color color, int appearTime, int disappearTime, double horizontalRadius, double verticalRadius)
          throws IllegalArgumentException{
    super(name, position, color, appearTime, disappearTime);
    if (horizontalRadius < 0 || verticalRadius < 0) {
      throw new IllegalArgumentException("Radii cannot be negative.");
    }
    this.radius = horizontalRadius;
    this.verticalRadius = verticalRadius;
  }
}
