package Model;

import Shape.Shape;
import Shape.Position;
import Shape.Color;

public interface AnimationModel {
  void move(Shape shape, Position endPosition, int startTime, int endTime);
  void scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime);
  void changeColor(Shape shape, Color newColor, int startTime, int endTime);
}
