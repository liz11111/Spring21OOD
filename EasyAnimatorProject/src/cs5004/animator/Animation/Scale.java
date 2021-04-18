package cs5004.animator.Animation;


import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
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

  @Override
  public Position getPositionAtTick(int t) {
    return null;
  }

  @Override
  public Color getColorAtTick(int t) {
    return null;
  }

  @Override
  public double[] getScaleAtTick(int t) {
    if (this.startTime == this.endTime) {
      return new double[]{this.toShape.getSize()[0], this.toShape.getSize()[0]};
    }


    double width = this.fromShape.getSize()[0] * (this.endTime - t) / (this.endTime - this.startTime) +
        this.toShape.getSize()[0] * (t - this.startTime) / (this.endTime - this.startTime);
    double height = this.fromShape.getSize()[1] * (this.endTime - t) / (this.endTime - this.startTime) +
        this.toShape.getSize()[1] * (t - this.startTime) / (this.endTime - this.startTime);

    return new double[]{width, height};

  }
}
