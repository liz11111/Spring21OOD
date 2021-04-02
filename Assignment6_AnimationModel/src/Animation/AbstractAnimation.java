package Animation;

import Shape.Shape;

public abstract class AbstractAnimation implements Animation {
  protected Shape shape;
  protected int startTime;
  protected int endTime;

  public AbstractAnimation(Shape shape, int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime <= startTime) {
      throw new IllegalArgumentException("Invalid time interval.");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
