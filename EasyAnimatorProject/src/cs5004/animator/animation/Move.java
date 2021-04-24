package cs5004.animator.animation;


import cs5004.animator.shape.Color;
import cs5004.animator.shape.Position;
import cs5004.animator.shape.Shape;

/**
 * Move is an implementation of Animation and support additional feature of moving the shape.
 */
public class Move extends AbstractAnimation {

  /**
   * Constructor for Move.
   *
   * @param fromShape Shape shape to move
   * @param toShape   Position the position to move to
   * @param startTime int start time of move
   * @param endTime   int end time of move
   */
  public Move(Shape fromShape, Shape toShape, int startTime, int endTime) {
    super(fromShape, toShape, startTime, endTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.fromShape.getName() + " ")
            .append("moves from ")
            .append(this.fromShape.getPosition().toString() + " ")
            .append("to ")
            .append(this.toShape.getPosition().toString() + " ")
            .append(String.format("from t=%d to t=%d\n", this.startTime, this.endTime));
    return sb.toString();
  }

  @Override
  public Position getPositionAtTick(int t) {
    if (this.startTime == this.endTime) {
      return new Position(this.fromShape.getPosition().getX(), this.fromShape.getPosition().getY());
    }

    double x = this.fromShape.getPosition().getX() * (this.endTime - t)
            / (this.endTime - this.startTime) +
            this.toShape.getPosition().getX() * (t - this.startTime)
                    / (this.endTime - this.startTime);
    double y = this.fromShape.getPosition().getY() * (this.endTime - t)
            / (this.endTime - this.startTime) +
            this.toShape.getPosition().getY() * (t - this.startTime)
                    / (this.endTime - this.startTime);
    return new Position(x, y);
  }

  @Override
  public Color getColorAtTick(int t) {
    return null;
  }

  @Override
  public double[] getScaleAtTick(int t) {
    return new double[0];
  }
}
