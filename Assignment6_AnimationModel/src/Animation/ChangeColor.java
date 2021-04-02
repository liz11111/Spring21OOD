package Animation;

import Shape.Color;
import Shape.Shape;

public class ChangeColor extends AbstractAnimation {
  private Color newColor;

  public ChangeColor(Shape shape, Color newColor, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.newColor = newColor;
  }
}
