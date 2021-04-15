package cs5004.animation.model;

public abstract class AbstractShape implements Shape {
  protected Position position;
  protected Color color;

  public AbstractShape(Position position, Color color) {
    this.color = color;
    this.position = position;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Position getPosition() {
    return position;
  }

}
