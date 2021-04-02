package Shape;

public class Rhombus extends Parallelogram {
  public Rhombus(String name, Position position, Color color, int appearTime, int disappearTime, double angle, double side) {
    super(name, position, color, appearTime, disappearTime, angle, side, side);
  }
}
