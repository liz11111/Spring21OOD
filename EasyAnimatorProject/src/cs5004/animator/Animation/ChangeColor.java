package cs5004.animator.Animation;


import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
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

  @Override
  public Position getPositionAtTick(int t) {
    return null;
  }

  @Override
  public Color getColorAtTick(int t) {
    int midR = this.fromShape.getColor().getR() * (this.endTime - t) / (this.endTime - this.startTime)
            + this.toShape.getColor().getR() * (t - this.startTime) / (this.endTime - this.startTime);
    int midG = this.fromShape.getColor().getG() * (this.endTime - t) / (this.endTime - this.startTime)
            + this.toShape.getColor().getG() * (t - this.startTime) / (this.endTime - this.startTime);
    int midB = this.fromShape.getColor().getB() * (this.endTime - t) / (this.endTime - this.startTime)
            + this.toShape.getColor().getB() * (t - this.startTime) / (this.endTime - this.startTime);

    return new Color(midR, midG, midB);
  }

  @Override
  public double[] getScaleAtTick(int t) {
    return new double[0];
  }
}
