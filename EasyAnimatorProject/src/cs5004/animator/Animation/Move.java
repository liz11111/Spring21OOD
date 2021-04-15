package cs5004.animator.Animation;


import cs5004.animator.Shape.Shape;

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
            .append(this.fromShape.getInitialPosition().toString() + " ")
            .append("to ")
            .append(this.toShape.getInitialPosition().toString() + " ")
            .append(String.format("from t=%d to t=%d\n", this.startTime, this.endTime));
    return sb.toString();
  }
}
