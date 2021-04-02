package Shape;

/**
 * Rectangle represents a rectangle shape.
 * Position of rectangle is specified by the position of bottom left vertex.
 * Shape of the rectangle is specified by side1(width) and side2(height).
 */
public class Rectangle extends Parallelogram {
  public Rectangle(String name, Position position, Color color, int appearTime, int disappearTime, double side1, double side2) {
    super(name, position, color, appearTime, disappearTime, 90, side1, side2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "rectangle\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Width: " + String.format("%.1f", side1) + ", " + "Height: " + String.format("%.1f", side2) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}
