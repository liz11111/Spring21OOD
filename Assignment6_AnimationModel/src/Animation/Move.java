package Animation;

import Shape.Position;
import Shape.Shape;

/**
 * Move is an implementation of Animation and support additional feature of moving the shape.
 */
public class Move extends AbstractAnimation {
  private Position endPosition;

  /**
   * Constructor for Move.
   *
   * @param shape       Shape shape to move
   * @param endPosition Position the position to move to
   * @param startTime   int start time of move
   * @param endTime     int end time of move
   */
  public Move(Shape shape, Position endPosition, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.endPosition = endPosition;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.shape.getName() + " ")
            .append("moves from ")
            .append(this.shape.getInitialPosition().toString() + " ")
            .append("to ")
            .append(this.endPosition.toString() + " ")
            .append(String.format("from t=%d to t=%d\n", this.startTime, this.endTime));
    return sb.toString();
  }
}
