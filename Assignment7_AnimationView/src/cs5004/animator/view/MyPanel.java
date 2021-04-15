package cs5004.animator.view;

import cs5004.animation.model.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.JPanel;

class MyPanel extends JPanel  {
  private List<Shape> shapeList;
  private int leftBound;
  private int topBound;

  public MyPanel(int left, int right) {
    super();
    this.leftBound = left;
    this.topBound = right;
  }

  public void paintShapes(List<Shape> shapeList) {
    this.shapeList = shapeList;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    for (Shape shape: this.shapeList) {
      g2d.setColor(new Color((int) shape.getColor().getR(), (int) shape.getColor().getG(),
          (int) shape.getColor().getB()));
      switch (shape.getShapeTypeName()) {
        case ("rectangle"):
          g2d.fill(new Rectangle2D.Double(shape.getPosition().getX() - this.leftBound,
              shape.getPosition().getY() - this.topBound,
              shape.getSize()[0], shape.getSize()[1]));
        case ("oval"):
        case ("ellipse"):
          g2d.fill(new Ellipse2D.Double(shape.getPosition().getX() - this.leftBound,
              shape.getPosition().getY() - this.topBound,
              shape.getSize()[0], shape.getSize()[1]));
      }
    }

  }

}
