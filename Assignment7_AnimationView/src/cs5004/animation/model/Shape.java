package cs5004.animation.model;

import java.awt.Graphics2D;

public interface Shape {

  Color getColor();

  Position getPosition();

  double[] getSize();

  String getShapeTypeName();

}
