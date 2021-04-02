package Animation;

import Shape.Shape;

public class Scale extends AbstractAnimation {
  private int sideToScale;
  private double newLength;

  public Scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.sideToScale = sideToScale;
    this.newLength = newLength;
  }
}
