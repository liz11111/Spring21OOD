package cs5004.animator.Animation;


import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
import cs5004.animator.Shape.Shape;

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
