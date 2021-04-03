package Animation;

import Shape.Shape;

/**
 * AbstractAnimation is an implementation of the Animation interface. It provides a common base
 * class for all animations.
 */
public abstract class AbstractAnimation implements Animation {
  protected Shape fromShape;
  protected Shape toShape;
  protected int startTime;
  protected int endTime;

  /**
   * Constructor for animations.
   *
   * @param fromShape Shape from the shape of this animation
   * @param toShape   Shape to the shape of this animation
   * @param startTime int start time of this animation
   * @param endTime   int end time of this animation
   * @throws IllegalArgumentException if start time and end time are invalid
   */
  public AbstractAnimation(Shape fromShape, Shape toShape, int startTime, int endTime) throws IllegalArgumentException {
    if (startTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("Invalid time interval.");
    }
    this.fromShape = fromShape;
    this.toShape = toShape;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public Shape getShape() {
    return this.toShape;
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
