package Animation;

import Shape.Shape;

/**
 * AbstractAnimation is an implementation of the Animation interface. It provides a common base
 * class for all animations.
 */
public abstract class AbstractAnimation implements Animation {
  protected Shape shape;
  protected int startTime;
  protected int endTime;

  /**
   * Constructor for animations.
   *
   * @param shape     Shape the shape of this animation
   * @param startTime int start time of this animation
   * @param endTime   int end time of this animation
   * @throws IllegalArgumentException if start time and end time are invalid
   */
  public AbstractAnimation(Shape shape, int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("Invalid time interval.");
    }
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public Shape getShape() {
    return this.shape;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }
}
