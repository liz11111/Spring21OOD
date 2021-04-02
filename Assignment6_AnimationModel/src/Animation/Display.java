package Animation;

import Shape.Position;
import Shape.Shape;

public class Display extends AbstractAnimation {
  private Position initialPosition;

  public Display(Shape shape, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.initialPosition = shape.getInitialPosition();
  }
}
