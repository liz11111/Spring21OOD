package cs5004.animator.Shape;

/**
 * Square is an implementation of Shape that represents a square. A square is specified by its
 * radius.
 */
public class Square extends Rectangle {
  /**
   * Constructor for Square.
   *
   * @param name          String name
   * @param position      Position position
   * @param color         Color color
   * @param appearTime    int appear time
   * @param disappearTime int disappear time
   * @param side          double side length
   */
  public Square(String name, Position position, Color color,
                int appearTime, int disappearTime, double side) {
    super(name, position, color, appearTime, disappearTime, side, side);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Create:\n");
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "square\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Side: " + String.format("%.1f", side1) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("\n");
    return sb.toString();
  }

  @Override
  public String getScale() {
    return "Side: " + String.format("%.1f", this.side1) + " ";
  }

  @Override
  public Square move(Position newPosition) {
    return new Square(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.side1);
  }

  @Override
  public Square changeColor(Color newColor) {
    return new Square(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.side1);
  }

  @Override
  public Square scale(int sideToScale, double newLength) {
    return new Square(this.name, this.position, this.color,
            this.appearTime, this.disappearTime, newLength);
  }

  @Override
  public String getShapeTypeName() {
    return "square";
  }

}
