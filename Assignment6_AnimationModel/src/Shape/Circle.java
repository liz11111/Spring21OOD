package Shape;

public class Circle extends Oval {
  public Circle(String name, Position position, Color color, int appearTime, int disappearTime, double radius) {
    super(name, position, color, appearTime, disappearTime, radius, radius);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "circle\n");
    sb.append("Center: " + position.toString() + ", ");
    sb.append("Radius: " + String.format("%.1f", this.radius) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears: " + appearTime + "\n");
    sb.append("Disappears: " + disappearTime + "\n\n");
    return sb.toString();
  }
}
