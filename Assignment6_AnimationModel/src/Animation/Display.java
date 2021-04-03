package Animation;

import Shape.Position;
import Shape.Shape;

/**
 * Display is an implementation of Animation and support additional feature of displaying the
 * shape.
 */
public class Display extends AbstractAnimation {
  private Position initialPosition;

  /**
   * Constructor for Display.
   *
   * @param shape     Shape shape to display
   * @param startTime int start time of display
   * @param endTime   int end time of display
   */
  public Display(Shape shape, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.initialPosition = shape.getInitialPosition();
  }
}
