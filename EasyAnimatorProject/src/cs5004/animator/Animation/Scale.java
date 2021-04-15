package cs5004.animator.Animation;


import cs5004.animator.Shape.Shape;

/**
 * Scale is an implementation of Animation and support additional feature of scaling the shape.
 */
public class Scale extends AbstractAnimation {

  /**
   * Constructor for Scale.
   *
   * @param fromShape Shape shape to scale
   * @param toShape   Shape to scale to
   * @param startTime int start time of scaling
   * @param endTime   int end time of scaling
   */
  public Scale(Shape fromShape, Shape toShape, int startTime, int endTime) {
    super(fromShape, toShape, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.fromShape.getName() + " ")
            .append("scales from ")
            .append(this.fromShape.getScale())
            .append("to ")
            .append(this.toShape.getScale())
            .append(String.format("from t=%d to t=%d\n", startTime, endTime));
    return sb.toString();
  }
}
