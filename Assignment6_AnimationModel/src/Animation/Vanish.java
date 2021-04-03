package Animation;

import Shape.Shape;

/**
 * Vanish is an implementation of Animation and support additional feature of vanishing a shape.
 */
public class Vanish extends AbstractAnimation {
  /**
   * Constructor for Vanish.
   *
   * @param fromShape Shape shape to vanish
   * @param toShape   Shape shape to vanish
   * @param startTime int start time of vanishing
   * @param endTime   int end time of vanishing
   */
  public Vanish(Shape fromShape, Shape toShape, int startTime, int endTime) {
    super(fromShape, toShape, startTime, endTime);
  }
}
