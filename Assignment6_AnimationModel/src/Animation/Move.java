package Animation;

import Shape.Position;
import Shape.Shape;

public class Move extends AbstractAnimation {
  private Position endPosition;

  public Move(Shape shape, Position endPosition, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.endPosition = endPosition;
  }
}
