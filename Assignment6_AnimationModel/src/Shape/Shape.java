package Shape;

/**
 * Shape interface specifies all contracts a shape should adhere to.
 */
public interface Shape {
  /**
   * getInitialPosition returns the initial position of the shape.
   *
   * @return Position initial position
   */
  Position getInitialPosition();

  /**
   * getAppearTime returns the appear time of the shape.
   *
   * @return int appear time
   */
  int getAppearTime();

  /**
   * getDisappearTime returns the disappear time of the shape.
   *
   * @return int disappear time
   */
  int getDisappearTime();

  /**
   * getName returns the name of the shape.
   *
   * @return String name of the shape
   */
  String getName();

  /**
   * getColor returns the color of the shape.
   *
   * @return Color color of the shape
   */
  Color getColor();

  /**
   * getScale returns the scale of the shape.
   *
   * @return String scale of the shape
   */
  String getScale();

  /**
   * move returns a copy of the shape with position changed to new position.
   *
   * @param newPosition Position new position to move to
   * @return Shape the copy of shape
   */
  Shape move(Position newPosition);

  /**
   * changeColor returns a copy of the shape with color changed to new color.
   *
   * @param newColor Color to change to
   * @return Shape the copy of shape
   */
  Shape changeColor(Color newColor);

  /**
   * scale returns a copy of the shape with scale change to new scale.
   *
   * @param sideToScale int side to scale, 1 or 2
   * @param newLength   double new length of the side to scale
   * @return Shape the copy of shape
   */
  Shape scale(int sideToScale, double newLength);
}
