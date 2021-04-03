package Model;

import Shape.Shape;
import Shape.Position;
import Shape.Color;

/**
 * AnimationModel specifies all contracts an animation model implementation should adhere to. It
 * supports all functionalities of an animation model in the MVC pattern.
 */
public interface AnimationModel {
  /**
   * addShape adds a shape to the model.
   *
   * @param shape Shape shape to add
   */
  void addShape(Shape shape);

  /**
   * getShapeAtTick gets the specific information of a shape at specific time tick.
   *
   * @param tickTime int tick time
   */
  void getShapeAtTick(Shape shape, int tickTime);

  /**
   * removeShape removes a shape from the model.
   *
   * @param shape Shape shape to remove
   */
  void removeShape(Shape shape);

  /**
   * toString returns a text description of the animation.
   *
   * @return String text description of the animation
   */
  String toString();

  /**
   * move moves a shape to a position at given time interval.
   *
   * @param shape       Shape shape to move
   * @param endPosition Position end position of movement
   * @param startTime   int start time of movement
   * @param endTime     int end time of movement
   */
  void move(Shape shape, Position endPosition, int startTime, int endTime);

  /**
   * scale scales a shape to a given size at given time interval.
   *
   * @param shape       Shape shape to scale
   * @param sideToScale int side to scale, 1 or 2
   * @param newLength   double new length to scale to
   * @param startTime   int start time of scaling
   * @param endTime     int end time of scaling
   */
  void scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime);

  /**
   * changeColor changes the color of a given shape at given time interval.
   *
   * @param shape     Shape shape to change color
   * @param newColor  Color new color to change to
   * @param startTime int start time of changing color
   * @param endTime   int end time of changing color
   */
  void changeColor(Shape shape, Color newColor, int startTime, int endTime);
}
