package cs5004.animator.model;

import cs5004.animator.Animation.Animation;
import cs5004.animator.Shape.Shape;
import java.util.List;
import java.util.Map;

public interface ReadOnlyModel {

  /**
   * getShapeAtTick gets the specific information of a shape at specific time tick.
   *
   * @param t int tick time
   */
  List<Shape> getShapeAtTick(int t);

  int getCanvasHeight();

  int getCanvasWidth();

  int getLeftBound();

  int getTopBound();

  Map<Shape, List<Animation>> getAnimationHistory();

}
