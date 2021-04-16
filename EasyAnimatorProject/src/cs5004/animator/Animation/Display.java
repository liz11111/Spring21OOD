package cs5004.animator.Animation;


import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
import cs5004.animator.Shape.Shape;

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

  @Override
  public Position getPositionAtTick(int t) {
    return null;
  }

  @Override
  public Color getColorAtTick(int t) {
    return null;
  }

  @Override
  public double[] getScaleAtTick(int t) {
    return new double[0];
  }
}
