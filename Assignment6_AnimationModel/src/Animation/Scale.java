package Animation;

import Shape.Shape;

/**
 * Scale is an implementation of Animation and support additional feature of scaling the shape.
 */
public class Scale extends AbstractAnimation {
  private int sideToScale;
  private double newLength;

  /**
   * Constructor for Scale.
   *
   * @param shape       Shape shape to scale
   * @param sideToScale int side to scale, 1 or 2
   * @param newLength   double new length to scale to
   * @param startTime   int start time of scaling
   * @param endTime     int end time of scaling
   */
  public Scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.sideToScale = sideToScale;
    this.newLength = newLength;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.shape.getName() + " ")
            .append("scales from ")
            .append(this.shape.getScale())
            .append("to ")
            .append(String.format("new length %.1f on side%d ", this.newLength, this.sideToScale))
            .append(String.format("from t=%d to t=%d\n", startTime, endTime));
    return sb.toString();
  }
}
