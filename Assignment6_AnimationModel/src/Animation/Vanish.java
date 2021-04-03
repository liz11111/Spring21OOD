package Animation;

import Shape.Shape;

/**
 * Vanish is an implementation of Animation and support additional feature of vanishing a shape.
 */
public class Vanish extends AbstractAnimation {
  /**
   * Constructor for Vanish.
   *
   * @param shape     Shape shape to vanish
   * @param startTime int start time of vanishing
   * @param endTime   int end time of vanishing
   */
  public Vanish(Shape shape, int startTime, int endTime) {
    super(shape, startTime, endTime);
  }
}
