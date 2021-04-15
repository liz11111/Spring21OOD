package cs5004.animation.model;

public interface AnimationModel extends ReadOnlyModel {

  void setBounds(int left, int top, int width, int height);

  void addShape(String shapeName, String shapeType);

  void removeShape(String shapeName);

  void move(String shapeName, int startTime, int endTime, Position startPosition,
      Position endPosition);

  void scale(String shapeName, int startTime, int endTime, double[] startSize, double[] endSize);

  void changeColor(String shapeName, int startTime, int endTime, Color startColor, Color endColor);
}
