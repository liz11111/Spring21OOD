package Shape;

/**
 * Position of a parallelogram is specified by the bottom left vertex.
 * Shape of a parallelogram is specified by the lengths of two sides and the angle between them.
 * Side1 is the one in the bottom.
 */
public class Parallelogram extends AbstractShape {
  protected double angle;
  protected double side1;
  protected double side2;

  public Parallelogram(String name, Position position, Color color, int appearTime, int disappearTime, double angle, double side1, double side2) throws IllegalArgumentException {
    super(name, position, color, appearTime, disappearTime);
    if (angle < 0 || angle > 180 || side1 < 0 || side2 < 0) {
      throw new IllegalArgumentException("Invalid parallelogram specs.");
    }
    this.angle = angle;
    this.side1 = side1;
    this.side2 = side2;
  }
}
