package cs5004.animator.shape;

/**
 * Circle is an implementation of Shape that represents a circle.
 */
public class Circle extends Oval {
  /**
   * Constructor for circle.
   *
   * @param name          name of the circle
   * @param position      Position position of the circle
   * @param color         Color color of the circle
   * @param appearTime    int appear time of the circle
   * @param disappearTime int disappear time of the circle
   * @param radius        double radius of the circle
   */
  public Circle(String name, Position position, Color color, int appearTime,
                int disappearTime, double radius) {
    super(name, position, color, appearTime, disappearTime, radius, radius);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Create:\n");
    sb.append("Name: " + this.name + "\n");
    sb.append("Type: " + "circle\n");
    sb.append("Center: " + position.toString() + ", ");
    sb.append("Radius: " + String.format("%.1f", this.radius) + ", ");
    sb.append("Color: " + color.toString() + "\n");
    sb.append("Appears at t=" + appearTime + "\n");
    sb.append("\n");
    return sb.toString();
  }

  @Override
  public String getScale() {
    return "Radius: " + String.format("%.1f", this.radius) + " ";
  }

  @Override
  public Circle move(Position newPosition) {
    return new Circle(this.name, newPosition, this.color,
            this.appearTime, this.disappearTime, this.radius);
  }

  @Override
  public Circle changeColor(Color newColor) {
    return new Circle(this.name, this.position, newColor,
            this.appearTime, this.disappearTime, this.radius);
  }

  @Override
  public Circle scale(int sideToScale, double newLength) {
    return new Circle(this.name, this.position, this.color,
            this.appearTime, this.disappearTime, newLength);
  }

  @Override
  public String getShapeTypeName() {
    return "circle";
  }
}
