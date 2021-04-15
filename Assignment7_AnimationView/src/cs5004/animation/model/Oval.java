package cs5004.animation.model;

public class Oval extends RectangularShape {
  private ShapeType shapeType;

  public Oval(Position position, Color color, double horizontalRadius, double verticalRadius) {
    super(position, color, horizontalRadius, verticalRadius);
    this.shapeType = ShapeType.OVAL;
  }

  @Override
  public String getShapeTypeName() {
    return this.shapeType.getTypeName();
  }

}
