package cs5004.animation.model;

import java.util.List;

public interface ReadOnlyModel {

  List<Shape> getShapeAtTick(int t);

  int getLeftBound();

  int getTopBound();

  int getCanvasWidth();

  int getCanvasHeight();
}
