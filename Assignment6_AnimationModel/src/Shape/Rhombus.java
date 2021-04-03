package Shape;

/**
 * Rhombus is an implementation of Shape that represents a rhombus. A rhombus is specified by it's
 * angle at bottom left corner and a side length.
 */
public class Rhombus extends Parallelogram {
  /**
   * Constructor for Rhombus.
   *
   * @param name          String name
   * @param position      Position position
   * @param color         Color color
   * @param appearTime    int appear time
   * @param disappearTime int disappear time
   * @param angle         double angle of bottom left vertex
   * @param side          double side length
   */
  public Rhombus(String name, Position position, Color color,
                 int appearTime, int disappearTime, double angle, double side) {
    super(name, position, color, appearTime, disappearTime, angle, side, side);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "rhombus\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Side: " + String.format("%.1f", side1) + ", ");
    sb.append("Angle: " + String.format("%.1f", angle) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("Disappears at t=" + disappearTime + "\n\n");
    return sb.toString();
  }

  @Override
  public String getScale() {
    return "Angle: "
            + String.format("%.1f", this.angle) + ", "
            + "Side: "
            + String.format("%.1f", this.side1) + ", ";
  }

  @Override
  public Rhombus move(Position newPosition) {
    return new Rhombus(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.angle, this.side1);
  }

  @Override
  public Rhombus changeColor(Color newColor) {
    return new Rhombus(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.angle, this.side1);
  }

  @Override
  public Rhombus scale(int sideToScale, double newLength) {
    return new Rhombus(this.name, this.position, this.color,
            this.appearTime, this.disappearTime, this.angle, newLength);
  }
}
