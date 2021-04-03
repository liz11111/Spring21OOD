package Animation;

import Shape.Position;
import Shape.Shape;

/**
 * Display is an implementation of Animation and support additional feature of displaying the
 * shape.
 */
public class Display extends AbstractAnimation {

  /**
   * Constructor for Display.
   *
   * @param fromShape Shape shape to display
   * @param toShape   Shape shape to display
   * @param startTime int start time of display
   * @param endTime   int end time of display
   */
  public Display(Shape fromShape, Shape toShape, int startTime, int endTime) {
    super(fromShape, toShape, startTime, endTime);
  }
}
