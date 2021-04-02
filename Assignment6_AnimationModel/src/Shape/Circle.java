package Shape;

public class Circle extends Oval {
  public Circle(String name, Position position, Color color, int appearTime, int disappearTime, double radius) {
    super(name, position, color, appearTime, disappearTime, radius, radius);
  }
}
