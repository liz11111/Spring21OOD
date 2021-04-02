package Shape;

import Shape.AbstractShape;
import Shape.Color;
import Shape.Position;

/**
 * Position of a triangle is specified by the vertex in the bottom left corner.
 * Shape of a triangle is specified by the two sides of bottom left corner vertex and the angle between them.
 * Side1 is the one in the bottom.
 */
public class Triangle extends AbstractShape {
  private double angle;
  private double side1;
  private double side2;

  public Triangle(String name, Position position, Color color, int appearTime, int disappearTime, double angle, double side1, double side2) throws IllegalArgumentException{
    super(name, position, color, appearTime, disappearTime);
    if (angle < 0 || angle > 180 || side1 < 0 || side2 < 0) {
      throw new IllegalArgumentException("Invalids triangle specs.");
    }
    this.angle = angle;
    this.side1 = side1;
    this.side2 = side2;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "square\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Side1: " + String.format("%.1f", side1) + ", ");
    sb.append("Side2: " + String.format("%.1f", side2) + ", ");
    sb.append("Angle: " + String.format("%.1f", angle) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}