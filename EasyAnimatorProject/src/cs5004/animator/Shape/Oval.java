package cs5004.animator.Shape;

/**
 * Oval is an implementation of Shape that represents a oval. An oval is specified by its X radius
 * and Y radius.
 */
public class Oval extends AbstractShape {
  protected double radius;
  private double verticalRadius;

  /**
   * Constructor for oval.
   *
   * @param name             String name of the oval
   * @param position         Position position of the oval
   * @param color            Color color of the oval
   * @param appearTime       int appear time of the oval
   * @param disappearTime    int disappear time of the oval
   * @param horizontalRadius double X radius
   * @param verticalRadius   double Y radius
   * @throws IllegalArgumentException if arguments are invalid
   */
  public Oval(String name, Position position, Color color,
              int appearTime, int disappearTime, double horizontalRadius, double verticalRadius)
          throws IllegalArgumentException {
    super(name, position, color, appearTime, disappearTime);
    if (horizontalRadius < 0 || verticalRadius < 0) {
      throw new IllegalArgumentException("Radii cannot be negative.");
    }
    this.radius = horizontalRadius;
    this.verticalRadius = verticalRadius;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Create:\n");
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "oval\n");
    sb.append("Center: " + position.toString() + ", ");
    sb.append("Horizontal Radius: " + String.format("%.1f", this.radius)
            + ", " + "Vertical Radius: " + String.format("%.1f", this.verticalRadius) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("\n");
    return sb.toString();
  }

  @Override
  public String getShapeTypeName() {
    return "ellipse";
  }

  @Override
  public String getScale() {
    return "X radius: " + String.format("%.1f", this.radius)
            + ", " + "Y Radius: " + String.format("%.1f", this.verticalRadius) + " ";
  }

  @Override
  public double[] getSize() {
    return new double[]{this.radius, this.verticalRadius};
  }

  @Override
  public Oval move(Position newPosition) {
    return new Oval(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.radius, this.verticalRadius);
  }

  @Override
  public Oval changeColor(Color newColor) {
    return new Oval(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.radius, this.verticalRadius);
  }

  @Override
  public Oval scale(int sideToScale, double newLength) {
    return new Oval(this.name, this.position, this.color,
            this.appearTime, this.disappearTime,
            sideToScale == 1 ? newLength : this.radius,
            sideToScale == 2 ? newLength : this.verticalRadius);
  }

  @Override
  public void setScale(double[] newScale) {
    this.radius = newScale[0];
    this.verticalRadius = newScale[1];
  }

  @Override
  public Oval getCopy() {
    return new Oval(this.name, this.position, this.color, this.appearTime, this.disappearTime,
            this.radius, this.verticalRadius);
  }
}
