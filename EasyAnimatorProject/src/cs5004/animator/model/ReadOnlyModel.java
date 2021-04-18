package cs5004.animator.model;

import cs5004.animator.animation.Animation;
import cs5004.animator.shape.Shape;

import java.util.List;
import java.util.Map;

/**
 * ReadOnlyModel is a read-only version of the model interface.
 */
public interface ReadOnlyModel {

  /**
   * getShapeAtTick gets the specific information of a shape at specific time tick.
   *
   * @param t int tick time
   */
  List<Shape> getShapeAtTick(int t);

  /**
   * getCanvasHeight returns canvas height.
   *
   * @return int canvas height;
   */
  int getCanvasHeight();

  /**
   * getCanvasWidth returns canvas width.
   *
   * @return int canvas width
   */
  int getCanvasWidth();

  /**
   * getLeftBound returns left bound.
   *
   * @return int left bound
   */
  int getLeftBound();

  /**
   * getTopBound returns top bound.
   *
   * @return int top bound
   */
  int getTopBound();

  /**
   * getAnimationHistory returns animation history.
   *
   * @return animation history
   */
  Map<Shape, List<Animation>> getAnimationHistory();

}
