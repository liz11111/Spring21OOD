package cs5004.animation.model;

class ShapeFactory {

  public static Shape createShape(String shapeTypeName, Position position, Color color,
      double[] size) throws IllegalArgumentException {
    switch (shapeTypeName.toLowerCase()) {
      case "oval":
      case "ellipse":
        if (size.length != 2) {
          throw new IllegalArgumentException("Wrong size");
        }
        return new Oval(position, color, size[0], size[1]);
      case "rectangle":
        if (size.length != 2) {
          throw new IllegalArgumentException("Wrong size");
        }
        return new Rectangle(position, color, size[0], size[1]);
      default:
        throw new IllegalArgumentException("No such shape type");
    }
  }
}
