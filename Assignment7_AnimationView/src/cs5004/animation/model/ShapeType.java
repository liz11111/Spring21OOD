package cs5004.animation.model;

enum ShapeType {
  OVAL("ellipse"), RECTANGLE("rectangle");

  private String typeName;

  ShapeType(String typeName) {
    this.typeName = typeName;
  }

  public String getTypeName() {
    return this.typeName;
  }

}
