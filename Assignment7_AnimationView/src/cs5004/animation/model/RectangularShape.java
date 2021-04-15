package cs5004.animation.model;

public abstract class RectangularShape extends AbstractShape {
  protected double width;
  protected double height;

  public RectangularShape(Position position, Color color, double width, double height)
      throws IllegalArgumentException {
    super(position, color);
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Height and width should be positive");
    }
    this.height = height;
    this.width = width;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public double[] getSize() {
    return new double[] {this.width, this.height};
  }

}
