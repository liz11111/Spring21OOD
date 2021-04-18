package cs5004.animator.view;

import cs5004.animator.Animation.Animation;
import cs5004.animator.Animation.ChangeColor;
import cs5004.animator.Animation.Display;
import cs5004.animator.Animation.Move;
import cs5004.animator.Animation.Scale;
import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
import cs5004.animator.Shape.Shape;
import cs5004.animator.model.ReadOnlyModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class SVGView implements View {
  private ReadOnlyModel model;
  private StringBuilder animationText;

  public SVGView(ReadOnlyModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    this.model = model;
    // initialize the canvas
    animationText = new StringBuilder();
    this.createCanvas();

  }

  private void createCanvas() {
    String canvas = String.format("<svg width=\"%d\" height=\"%d\" version=\"1.1\"\n"
        + "xmlns=\"http://www.w3.org/2000/svg\"> \n", model.getCanvasWidth(), model.getCanvasHeight());
    animationText.append(canvas);
  }


  @Override
  public void play(int startTime, int speed) {
    Map<Shape, List<Animation>> animationHistory = model.getAnimationHistory();
    List<Shape> shapeList = model.getShapeAtTick(startTime);

    for (Shape initialShape: shapeList) {
      // initialize the shape
      // get the shape type
      String shapeType;
      String initialization;

      switch (initialShape.getShapeTypeName()) {
        case ("rectangle"):
          shapeType = "rect";
          initialization = "<%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" "
              + "height=\"%.2f\" fill=\"rgb(%d,%d,%d)\" visibility=\"visible\" > \n";
          initialization = String.format(initialization,
              shapeType, initialShape.getName(), initialShape.getPosition().getX() -
                  this.model.getLeftBound(), initialShape.getPosition().getY() -
                  this.model.getTopBound(), initialShape.getSize()[0], initialShape.getSize()[1],
              initialShape.getColor().getR(), initialShape.getColor().getG(),
              initialShape.getColor().getB());

          break;
        case ("ellipse"):
          shapeType = "ellipse";
          initialization = "<%s id=\"%s\" cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" "
              + "fill=\"rgb(%d,%d,%d)\" visibility=\"visible\"> \n";
          initialization = String.format(initialization,
              shapeType, initialShape.getName(), initialShape.getPosition().getX() -
                  this.model.getLeftBound(), initialShape.getPosition().getY() -
                  this.model.getTopBound(), initialShape.getSize()[0]/2, initialShape.getSize()[1]/2,
              initialShape.getColor().getR(), initialShape.getColor().getG(),
              initialShape.getColor().getB());

          break;
        default:
          throw new IllegalStateException("No such shape");
      }
      animationText.append(initialization);

      List<Animation> animationList = animationHistory.get(initialShape);
      for (Animation animation: animationList) {
        if (startTime >= animation.getStartTime() && startTime < animation.getEndTime()) {
          int beginTime = startTime;
          int endTime = animation.getEndTime();

          if (animation instanceof ChangeColor) {
            this.addChangeColor(beginTime * 1000 / speed, endTime * 1000 / speed,
                initialShape.getColor(), animation.getShape().getColor(),
                startTime * 1000 / speed);
          } else if (animation instanceof Move) {
            this.addMove(beginTime * 1000 / speed, endTime * 1000 / speed,
                initialShape.getPosition(), animation.getShape().getPosition(), shapeType,
                startTime * 1000 / speed);
          } else if (animation instanceof Scale) {
            this.addScale(beginTime * 1000 / speed, endTime * 1000 / speed,
                initialShape.getSize(), animation.getShape().getSize(), shapeType,
                startTime * 1000 / speed);
          }
        } else if (startTime < animation.getStartTime()) {
          int beginTime = animation.getStartTime();
          int endTime = animation.getEndTime();

          if (animation instanceof ChangeColor) {
            this.addChangeColor(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getColorAtTick(beginTime), animation.getShape().getColor(),
                startTime * 1000 / speed);
          } else if (animation instanceof Move) {
            this.addMove(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getPositionAtTick(beginTime), animation.getShape().getPosition(),
                shapeType, startTime * 1000 / speed);
          } else if (animation instanceof Scale) {
            this.addScale(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getScaleAtTick(beginTime), animation.getShape().getSize(), shapeType,
                startTime * 1000 / speed);
          }
        }

      }
      animationText.append(String.format("</%s>\n", shapeType));
    }

    Set<Shape> visitedShape = new HashSet<>(shapeList);

    for (Shape shape: animationHistory.keySet()) {
      String shapeType;
      String initialization;

      if ((!visitedShape.contains(shape))) {

        switch (shape.getShapeTypeName()) {
          case ("rectangle"):
            shapeType = "rect";
            initialization = "<%s id=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" "
                + "height=\"%.2f\" fill=\"rgb(%d,%d,%d)\" visibility=\"visible\" > \n";
            initialization = String.format(initialization,
                shapeType, shape.getName(), shape.getPosition().getX() - this.model.getLeftBound(),
                shape.getPosition().getY() - this.model.getTopBound(),
                shape.getSize()[0], shape.getSize()[1], shape.getColor().getR(),
                shape.getColor().getG(), shape.getColor().getB());
            break;
          case ("ellipse"):
            shapeType = "ellipse";
            initialization = "<%s id=\"%s\" cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" "
                + "fill=\"rgb(%d,%d,%d)\" visibility=\"visible\">";
            initialization = String.format(initialization,
                shapeType, shape.getName(), shape.getPosition().getX() - this.model.getLeftBound(),
                shape.getPosition().getY() - this.model.getTopBound(),
                shape.getSize()[0]/2, shape.getSize()[1]/2, shape.getColor().getR(),
                shape.getColor().getG(), shape.getColor().getB());

            break;
          default:
            throw new IllegalStateException("No such shape");
        }
        // initialization
        animationText.append(initialization);

        List<Animation> animationList = animationHistory.get(shape);
        for (Animation animation: animationList) {
          int beginTime = animation.getStartTime();
          int endTime = animation.getEndTime();

          if (animation instanceof ChangeColor) {
            this.addChangeColor(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getColorAtTick(beginTime), animation.getColorAtTick(endTime),
                startTime * 1000 / speed);
          } else if (animation instanceof Move) {
            this.addMove(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getPositionAtTick(beginTime), animation.getPositionAtTick(endTime),
                shapeType, startTime * 1000 / speed);
          } else if (animation instanceof Scale) {
            this.addScale(beginTime * 1000 / speed, endTime * 1000 / speed,
                animation.getScaleAtTick(beginTime), animation.getScaleAtTick(endTime), shapeType,
                startTime * 1000 / speed);
          }
        }
        animationText.append(String.format("</%s>\n", shapeType));
      }

    }

    this.animationText.append("</svg>");
  }

  @Override
  public void showErrorMessage(String errorMessage) {
    System.out.print(errorMessage);
  }

  public String getStringOutput() {
    return this.animationText.toString();
  }

  public void saveSVG(String filePath) throws IOException {
    FileWriter writer = new FileWriter(filePath);
    try {
      writer.write(this.animationText.toString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void addChangeColor(int beginTime, int endTime, Color fromColor, Color toColor,
      int baseTime) {
    int duration = endTime - beginTime;
    String changeColor = String.format("<animate attributeType=\"xml\" begin=\"%dms\""
        + " dur=\"%dms\" attributeName=\"fill\" fill=\"freeze\" from=\"rgb(%d,%d,%d)\" to=\"rgb(%d,%d,%d)\""
        + " />\n", beginTime - baseTime, duration, fromColor.getR(), fromColor.getG(), fromColor.getB(),
        toColor.getR(), toColor.getG(), toColor.getB());
    animationText.append(changeColor);
  }

  private void addMove(int beginTime, int endTime, Position fromPosition, Position toPosition,
      String shapeType, int baseTime) {
    int duration = endTime - beginTime;
    String moveX, moveY;

    switch(shapeType) {
      case ("rect"):
        moveX = "<animate attributeType=\"xml\" begin=\"%dms\" "
            + "dur=\"%dms\" attributeName=\"x\" from=\"%.2f\" to=\"%.2f\" fill=\"freeze\" />\n";
        moveY = "<animate attributeType=\"xml\" begin=\"%dms\" "
            + "dur=\"%dms\" attributeName=\"y\" from=\"%.2f\" to=\"%.2f\" fill=\"freeze\" />\n";
        break;
      case ("ellipse"):
        moveX = "<animate attributeType=\"xml\" begin=\"%dms\" "
            + "dur=\"%dms\" attributeName=\"cx\" from=\"%.2f\" to=\"%.2f\" fill=\"freeze\" />\n";
        moveY = "<animate attributeType=\"xml\" begin=\"%dms\" "
            + "dur=\"%dms\" attributeName=\"cy\" from=\"%.2f\" to=\"%.2f\" fill=\"freeze\" />\n";
        break;
      default:
        throw new IllegalArgumentException("No such shape");
    }

    moveX = String.format(moveX, beginTime - baseTime, duration, fromPosition.getX() -
            this.model.getLeftBound(), toPosition.getX() - this.model.getLeftBound());
    moveY = String.format(moveY, beginTime - baseTime, duration, fromPosition.getY() -
            this.model.getTopBound(), toPosition.getY() - this.model.getTopBound());
    animationText.append(moveX);
    animationText.append(moveY);
  }

  private void addScale(int beginTime, int endTime, double[] fromScale, double[] toScale,
      String shapeType, int baseTime) {
    int duration = endTime - beginTime;
    String scaleWidth, scaleHeight;

    switch (shapeType) {
      case ("rect"):
        scaleWidth = "<animate attributeName=\"width\" fill=\"freeze\" "
            + "from=\"%.2f\" to=\"%.2f\" begin=\"%dms\" dur=\"%dms\" />\n";
        scaleHeight = "<animate attributeName=\"height\" fill=\"freeze\" "
            + "from=\"%.2f\" to=\"%.2f\" begin=\"%dms\" dur=\"%dms\" />\n";
        scaleWidth = String.format(scaleWidth, fromScale[0], toScale[0],
            beginTime - baseTime, duration);
        scaleHeight = String.format(scaleHeight, fromScale[1], toScale[1],
            beginTime - baseTime, duration);

        break;
      case ("ellipse"):
        scaleWidth = "<animate attributeName=\"rx\" fill=\"freeze\" "
            + "from=\"%.2f\" to=\"%.2f\" begin=\"%dms\" dur=\"%dms\" />\n";
        scaleHeight = "<animate attributeName=\"ry\" fill=\"freeze\" "
            + "from=\"%.2f\" to=\"%.2f\" begin=\"%dms\" dur=\"%dms\" />\n";
        scaleWidth = String.format(scaleWidth, fromScale[0]/2, toScale[0]/2,
            beginTime, duration);
        scaleHeight = String.format(scaleHeight, fromScale[1]/2, toScale[1]/2,
            beginTime, duration);

        break;
      default:
        throw new IllegalArgumentException("No such type");
    }

    animationText.append(scaleWidth);
    animationText.append(scaleHeight);
  }


}
