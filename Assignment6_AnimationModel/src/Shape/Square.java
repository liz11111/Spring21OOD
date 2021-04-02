package Shape;

public class Square extends Rectangle {
  public Square(String name, Position position, Color color, int appearTime, int disappearTime, double side) {
    super(name, position, color, appearTime, disappearTime, side, side);
  }
}
