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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "oval\n");
    sb.append("Center: " + position.toString() + ", ");
    sb.append("Horizontal Radius: " + String.format("%.1f", this.radius) + ", " + "Vertical Radius: " + String.format("%.1f", this.verticalRadius) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}
