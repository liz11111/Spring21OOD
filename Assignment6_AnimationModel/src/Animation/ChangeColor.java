package Animation;

import Shape.Color;
import Shape.Shape;

/**
 * ChangeColor implements Animation interface and support additional feature of changing color.
 */
public class ChangeColor extends AbstractAnimation {
  private Color newColor;

  /**
   * Constructor for ChangeColor.
   *
   * @param shape     Shape the shape to change color
   * @param newColor  Color new color to change to
   * @param startTime int start time of changing color
   * @param endTime   int end time of changing color
   */
  public ChangeColor(Shape shape, Color newColor, int startTime, int endTime) {
    super(shape, startTime, endTime);
    this.newColor = newColor;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shape ")
            .append(this.shape.getName() + " ")
            .append("changes color from ")
            .append(this.shape.getColor().toString() + " ")
            .append("to ")
            .append(newColor.toString() + " ")
            .append(String.format("from t=%d to t=%d\n", this.startTime, this.endTime));
    return sb.toString();
  }
}
