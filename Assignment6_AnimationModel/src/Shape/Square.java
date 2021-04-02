package Shape;

public class Square extends Rectangle {
  public Square(String name, Position position, Color color, int appearTime, int disappearTime, double side) {
    super(name, position, color, appearTime, disappearTime, side, side);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "square\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Side: " + String.format("%.1f", side1) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}
