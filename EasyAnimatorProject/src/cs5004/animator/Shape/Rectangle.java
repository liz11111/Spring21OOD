package cs5004.animator.Shape;

/**
 * Rectangle represents a rectangle shape. Position of rectangle is specified by the position of
 * bottom left vertex. Shape of the rectangle is specified by side1(width) and side2(height).
 */
public class Rectangle extends Parallelogram {
  /**
   * Constructor for Rectangle.
   *
   * @param name          String name
   * @param position      Position position
   * @param color         Color color
   * @param appearTime    int appear time
   * @param disappearTime int disappear time
   * @param side1         double width
   * @param side2         double height
   */
  public Rectangle(String name, Position position, Color color,
                   int appearTime, int disappearTime, double side1, double side2) {
    super(name, position, color, appearTime, disappearTime, 90, side1, side2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "rectangle\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Width: " + String.format("%.1f", side1) + ", " +
            "Height: " + String.format("%.1f", side2) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("Disappears at t=" + disappearTime + "\n\n");
    return sb.toString();
  }

  @Override
  public String getScale() {
    return "Width: "
            + String.format("%.1f", this.side1) + ", "
            + "Height: "
            + String.format("%.1f", this.side2) + " ";
  }

  @Override
  public Rectangle move(Position newPosition) {
    return new Rectangle(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.side1, this.side2);
  }

  @Override
  public Rectangle changeColor(Color newColor) {
    return new Rectangle(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.side1, this.side2);
  }

  @Override
  public Rectangle scale(int sideToScale, double newLength) {
    return new Rectangle(this.name, this.position, this.color,
            this.appearTime, this.disappearTime,
            sideToScale == 1 ? newLength : this.side1,
            sideToScale == 2 ? newLength : this.side2);
  }

  @Override
  public String getShapeTypeName() {
    return "rectangle";
  }
}
