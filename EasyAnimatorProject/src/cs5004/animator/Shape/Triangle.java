package cs5004.animator.Shape;

/**
 * Position of a triangle is specified by the vertex in the bottom left corner. Shape of a triangle
 * is specified by the two sides of bottom left corner vertex and the angle between them. Side1 is
 * the one in the bottom.
 */
public class Triangle extends AbstractShape {
  private double angle;
  private double side1;
  private double side2;

  /**
   * Constructor for Triangle.
   *
   * @param name          String name
   * @param position      Position position
   * @param color         Color color
   * @param appearTime    int appear time
   * @param disappearTime int disappear time
   * @param angle         double angle of bottom left vertex
   * @param side1         double bottom side length
   * @param side2         double left side length
   * @throws IllegalArgumentException if inputs are invalid
   */
  public Triangle(String name, Position position, Color color,
                  int appearTime, int disappearTime, double angle, double side1, double side2)
          throws IllegalArgumentException {
    super(name, position, color, appearTime, disappearTime);
    if (angle < 0 || angle > 180 || side1 < 0 || side2 < 0) {
      throw new IllegalArgumentException("Invalids triangle specs.");
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
    sb.append("Type: " + "square\n");
    sb.append("corner: " + position.toString() + ", ");
    sb.append("Side1: " + String.format("%.1f", side1) + ", ");
    sb.append("Side2: " + String.format("%.1f", side2) + ", ");
    sb.append("Angle: " + String.format("%.1f", angle) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("\n");
    return sb.toString();
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
  public Triangle move(Position newPosition) {
    return new Triangle(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.angle, this.side1, this.side2);
  }

  @Override
  public Triangle changeColor(Color newColor) {
    return new Triangle(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.angle, this.side1, this.side2);
  }

  @Override
  public Triangle scale(int sideToScale, double newLength) {
    return new Triangle(this.name, this.position, this.color,
            this.appearTime, this.disappearTime, this.angle,
            sideToScale == 1 ? newLength : this.side1,
            sideToScale == 2 ? newLength : this.side2);
  }

  @Override
  public void setScale(double[] newScale) {

  }

  @Override
  public Shape getCopy() {
    return null;
  }

  @Override
  public String getShapeTypeName() {
    return "triangle";
  }

}
