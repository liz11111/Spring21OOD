package cs5004.animator.Animation;


import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
import cs5004.animator.Shape.Shape;

/**
 * Animation interface specifies all contracts an animation should support.
 */
public interface Animation {
  /**
   * getShape returns the shape of this animation.
   *
   * @return Shape the shape of this animation
   */
  Shape getShape();

  /**
   * getStartTime returns the start time of this animation.
   *
   * @return int start time of this animation
   */
  int getStartTime();

  /**
   * getEndTime returns the end time of this animation.
   *
   * @return int end time of this animation
   */
  int getEndTime();

  Position getPositionAtTick(int t);

  Color getColorAtTick(int t);

  double[] getScaleAtTick(int t);
}
