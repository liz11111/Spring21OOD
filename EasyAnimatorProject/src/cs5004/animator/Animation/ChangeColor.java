package cs5004.animator.Animation;


import cs5004.animator.Shape.Shape;

/**
 * ChangeColor implements Animation interface and support additional feature of changing color.
 */
public class ChangeColor extends AbstractAnimation {

  /**
   * Constructor for ChangeColor.
   *
   * @param fromShape Shape the shape to change color
   * @param toShape   Shape new color to change to
   * @param startTime int start time of changing color
   * @param endTime   int end time of changing color
   */
  public ChangeColor(Shape fromShape, Shape toShape, int startTime, int endTime) {
    super(fromShape, toShape, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.fromShape.getName() + " ")
            .append("changes color from ")
            .append(this.fromShape.getColor().toString() + " ")
            .append("to ")
            .append(this.toShape.getColor().toString() + " ")
            .append(String.format("from t=%d to t=%d\n", this.startTime, this.endTime));
    return sb.toString();
  }
}
