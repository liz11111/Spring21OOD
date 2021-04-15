package cs5004.animation.model;

import cs5004.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimationModelImpl implements AnimationModel {
  private int leftBound;
  private int topBound;
  private int width;
  private int height;
  private Map<String, ShapeAnimation> animationList;

  public AnimationModelImpl() {
    animationList = new HashMap<>();
  }

  @Override
  public void setBounds(int left, int top, int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The sides of the canvas should be positive");
    }
    this.leftBound = left;
    this.topBound = top;
    this.width = width;
    this.height = height;
  }

  @Override
  public void addShape(String shapeName, String shapeType) throws IllegalArgumentException {
    if (this.animationList.containsKey(shapeName)) {
      throw new IllegalArgumentException("The shape has been there");
    }

    ShapeAnimation animation = new ShapeAnimation(shapeName, shapeType);
    this.animationList.put(shapeName, animation);
  }

  @Override
  public void removeShape(String shapeName) {
    this.animationList.remove(shapeName);
  }

  @Override
  public void move(String shapeName, int startTime, int endTime, Position startPosition,
      Position endPosition) throws IllegalArgumentException {
    if (!this.animationList.containsKey(shapeName)) {
      throw new IllegalArgumentException("This shape not exists");
    }
    this.animationList.get(shapeName).addMove(startTime, endTime, startPosition, endPosition);
  }

  @Override
  public void scale(String shapeName, int startTime, int endTime, double[] startSize,
      double[] endSize) throws IllegalArgumentException {
    if (!this.animationList.containsKey(shapeName)) {
      throw new IllegalArgumentException("This shape not exists");
    }
    this.animationList.get(shapeName).addScale(startTime, endTime, startSize, endSize);
  }

  @Override
  public void changeColor(String shapeName, int startTime, int endTime, Color startColor,
      Color endColor) throws IllegalArgumentException {
    if (!this.animationList.containsKey(shapeName)) {
      throw new IllegalArgumentException("This shape not exists");
    }
    this.animationList.get(shapeName).addChangeColor(startTime, endTime, startColor, endColor);
  }

  @Override
  public List<Shape> getShapeAtTick(int t) throws IllegalArgumentException {
    if (t < 0) {
      throw new IllegalArgumentException("The time should be positive");
    }
    List<Shape> shapeList = new ArrayList<>();
    for (ShapeAnimation animation: this.animationList.values()) {
      Shape s = animation.getStateAtTick(t);
      if (s != null) {
        shapeList.add(s);
      }
    }
    return shapeList;
  }

  @Override
  public int getLeftBound() {
    return this.leftBound;
  }

  @Override
  public int getTopBound() {
    return this.topBound;
  }

  @Override
  public int getCanvasWidth() {
    return this.width;
  }

  @Override
  public int getCanvasHeight() {
    return this.height;
  }

  public static final class Builder implements AnimationBuilder<AnimationModel> {
    private AnimationModel model = new AnimationModelImpl();

    @Override
    public AnimationModel build() {
      return model;
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      this.model.setBounds(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      this.model.addShape(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {
      this.model.changeColor(name, t1, t2, new Color(r1, g1, b1), new Color(r2, g2, b2));
      this.model.scale(name, t1, t2, new double[]{w1, h1}, new double[]{w2, h2});
      this.model.move(name, t1, t2, new Position(x1, y1), new Position(x2, y2));
      return this;
    }
  }

}
