package Shape;

public class Rhombus extends Parallelogram {
  public Rhombus(String name, Position position, Color color, int appearTime, int disappearTime, double angle, double side) {
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
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}
