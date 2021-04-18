package cs5004.animator.shape;

/**
 * Position of a parallelogram is specified by the bottom left vertex. Shape of a parallelogram is
 * specified by the bottom left angle and two sides include the angle. Side1 is the one in the
 * bottom.
 */
public class Parallelogram extends AbstractShape {
  protected double angle;
  protected double side1;
  protected double side2;

  /**
   * Constructor for Parallelogram.
   *
   * @param name          String name of the parallelogram
   * @param position      Position position of the parallelogram
   * @param color         Color color of the parallelogram
   * @param appearTime    int appear time
   * @param disappearTime int disappear time
   * @param angle         double angle
   * @param side1         double bottom side length
   * @param side2         double left side length
   * @throws IllegalArgumentException if inputs are invalid
   */
  public Parallelogram(String name, Position position, Color color,
                       int appearTime, int disappearTime, double angle, double side1, double side2)
          throws IllegalArgumentException {
    super(name, position, color, appearTime, disappearTime);
    if (angle < 0 || angle > 180 || side1 < 0 || side2 < 0) {
      throw new IllegalArgumentException("Invalid parallelogram specs.");
    }
    this.angle = angle;
    this.side1 = side1;
    this.side2 = side2;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Create:\n");
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "parallelogram\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Width: " + String.format("%.1f", side1) + ", "
            + "Height: " + String.format("%.1f", side2) + ", ");
    sb.append("Angle: " + String.format("%.1f", angle) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("\n");
    return sb.toString();
  }

  @Override
  public String getShapeTypeName() {
    return "parallelogram";
  }

  @Override
  public String getScale() {
    return "Angle: "
            + String.format("%.1f", this.angle) + ", "
            + "Side1: "
            + String.format("%.1f", this.side1) + ", "
            + "Side2: "
            + String.format("%.1f", this.side2) + " ";
  }

  @Override
  public double[] getSize() {
    return new double[]{this.side1, this.side2, this.angle};
  }

  @Override
  public Parallelogram move(Position newPosition) {
    return new Parallelogram(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.angle, this.side1, this.side2);
  }

  @Override
  public Parallelogram changeColor(Color newColor) {
    return new Parallelogram(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.angle, this.side1, this.side2);
  }

  @Override
  public Parallelogram scale(int sideToScale, double newLength) {
    return new Parallelogram(this.name, this.position, this.color,
            this.appearTime, this.disappearTime, this.angle,
            sideToScale == 1 ? newLength : this.side1,
            sideToScale == 2 ? newLength : this.side2);
  }

  @Override
  public void setScale(double[] newScale) {
    this.side1 = newScale[0];
    this.side2 = newScale[1];
  }

  @Override
  public Shape getCopy() {
    return null;
  }


}
