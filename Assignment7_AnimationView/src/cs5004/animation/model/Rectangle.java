package cs5004.animation.model;

public class Rectangle extends RectangularShape {
  private ShapeType shapeType;

  public Rectangle(Position position, Color color, double width, double height) {
    super(position, color, width, height);
    this.shapeType = ShapeType.RECTANGLE;
  }

  @Override
  public String getShapeTypeName() {
    return this.shapeType.getTypeName();
  }

}
