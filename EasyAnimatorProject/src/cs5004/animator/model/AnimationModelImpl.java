package cs5004.animator.model;

import cs5004.animator.Shape.Oval;
import cs5004.animator.Shape.Rectangle;
import cs5004.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import cs5004.animator.Animation.Animation;
import cs5004.animator.Animation.ChangeColor;
import cs5004.animator.Animation.Display;
import cs5004.animator.Animation.Move;
import cs5004.animator.Animation.Scale;
import cs5004.animator.Animation.Vanish;
import cs5004.animator.Shape.Color;
import cs5004.animator.Shape.Position;
import cs5004.animator.Shape.Shape;

/**
 * AnimationModelImpl implements all functionalities of AnimationModel interface.
 */
public class AnimationModelImpl implements AnimationModel {
  Map<Shape, List<Animation>> animationHistory;
  private int canvasHeight;
  private int canvasWidth;
  private int topBound;
  private int leftBound;

  /**
   * Constructor for AnimationModelImpl.
   */
  public AnimationModelImpl() {
    animationHistory = new HashMap<>();
  }

  public void addShape(Shape shape) throws IllegalStateException {
    if (animationHistory.containsKey(shape)) {
      throw new IllegalStateException("Shape already exists.");
    }
    List<Animation> animations = new ArrayList<>();
    animations.add(new Display(shape, shape, shape.getAppearTime(), shape.getAppearTime()));
    animations.add(new Vanish(shape, shape, shape.getDisappearTime(), shape.getDisappearTime()));
    animationHistory.put(shape, animations);
  }

  public List<Shape> getShapeAtTick(int tickTime) {
    List<Shape> shapeList = new ArrayList<>();
    for (Shape s: animationHistory.keySet()) {
      List<Animation> list = animationHistory.get(s);
      Shape newS = s.getCopy();
      for (Animation animation: list) {
        if (tickTime >= animation.getEndTime()) {
          newS = animation.getShape().getCopy();
        } else if (tickTime >= animation.getStartTime() && tickTime < animation.getEndTime()) {
          if (animation instanceof ChangeColor) {
            newS.setColor(animation.getColorAtTick(tickTime));
          } else if (animation instanceof Scale) {
            newS.setScale(animation.getScaleAtTick(tickTime));
          } else if (animation instanceof Move) {
            newS.setPosition(animation.getPositionAtTick(tickTime));
          }
        }

      }
      if (tickTime >= s.getAppearTime()) {
        shapeList.add(newS);
      }
    }

    return shapeList;


  }

  public void removeShape(Shape shape) {
    animationHistory.remove(shape);
  }

  /**
   * checkWithinLifetime checks whether an animation is within the life time of a shape.
   *
   * @param shape     Shape shape to animate
   * @param startTime int start time of animation
   * @param endTime   int end time of animation
   * @return boolean whether the animation is within the life time
   */
  private boolean checkWithinLifetime(Shape shape, int startTime, int endTime) {
    List<Animation> animations = animationHistory.get(shape);
    // check if move operation is within lifetime of this shape
    if (startTime < animations.get(0).getEndTime()
            || startTime > animations.get(animations.size() - 1).getStartTime()
            || endTime < animations.get(0).getEndTime()
            || endTime > animations.get(animations.size() - 1).getStartTime()) {
      return false;
    }
    return true;
  }

  /**
   * hasConflict checks whether an animation has conflict with existing animations.
   *
   * @param shape         Shape shape to animate
   * @param startTime     int start time of animation
   * @param endTime       int end time of animation
   * @param animationType String animation type : "Move" for move, "Scale" for scale, "Change Color"
   *                      for changing color
   * @return boolean whether it has conflicts
   * @throws IllegalArgumentException if invalid operation type is specified
   */
  private boolean hasConflict(Shape shape, int startTime, int endTime, String animationType)
          throws IllegalArgumentException {
    List<Animation> animations = animationHistory.get(shape);
    // check if a given operation has conflict with existing animations
    switch (animationType) {
      case "Move":
        for (Animation a : animations) {
          if (a instanceof Move) {
            if ((a.getStartTime() <= startTime) && (a.getEndTime() > startTime)) {
              return true;
            } else if ((a.getStartTime() > startTime) && (a.getStartTime() < endTime)) {
              return true;
            }
          }
        }
        break;

      case "Scale":
        for (Animation a : animations) {
          if (a instanceof Scale) {
            if ((a.getStartTime() <= startTime) && (a.getEndTime() > startTime)) {
              return true;
            } else if ((a.getStartTime() > startTime) && (a.getStartTime() < endTime)) {
              return true;
            }
          }
        }
        break;

      case "Change Color":
        for (Animation a : animations) {
          if (a instanceof ChangeColor) {
            if ((a.getStartTime() <= startTime) && (a.getEndTime() > startTime)) {
              return true;
            } else if ((a.getStartTime() > startTime) && (a.getStartTime() < endTime)) {
              return true;
            }
          }
        }
        break;

      default:
        throw new IllegalArgumentException("Invalid operation type.");
    }

    return false;
  }

  /**
   * checkAnimation checks whether an animation is valid to add
   *
   * @param shape     Shape shape to animate
   * @param startTime int start time of animation
   * @param endTime   int end time of animation
   * @throws IllegalArgumentException if shape or time is invalid
   */
  private void checkAnimation(Shape shape, int startTime, int endTime)
          throws IllegalArgumentException {
    if (!animationHistory.containsKey(shape)) {
      throw new IllegalArgumentException("No such shape");
    } else if (startTime > endTime) {
      throw new IllegalArgumentException("Invalid times.");
    } else if (!checkWithinLifetime(shape, startTime, endTime)) {
      throw new IllegalArgumentException("Operation span is outside of shape's lifetime.");
    }
  }

  @Override
  public void move(Shape shape, Position endPosition, int startTime, int endTime)
          throws IllegalArgumentException {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Move")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    int size = animations.size();
    for (int i = 1; i < size; i++) {
      if (animations.get(i).getStartTime() > startTime) {
        animations.add(i,
                new Move(animations.get(i - 1).getShape(),
                        animations.get(i - 1).getShape().move(endPosition),
                        startTime, endTime));
        break;
      }
    }
  }

  @Override
  public void scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime)
          throws IllegalArgumentException {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Scale")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    int size = animations.size();
    for (int i = 1; i < size; i++) {
      if (animations.get(i).getStartTime() > startTime) {
        animations.add(i,
                new Scale(animations.get(i - 1).getShape(),
                        animations.get(i - 1).getShape().scale(sideToScale, newLength),
                        startTime, endTime));
        break;
      }
    }
  }

  @Override
  public void changeColor(Shape shape, Color newColor, int startTime, int endTime)
          throws IllegalArgumentException {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Change Color")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    int size = animations.size();
    for (int i = 1; i < size; i++) {
      if (animations.get(i).getStartTime() > startTime) {
        animations.add(i,
                new ChangeColor(animations.get(i - 1).getShape(),
                        animations.get(i - 1).getShape().changeColor(newColor),
                        startTime, endTime));
        break;
      }
    }
  }

  @Override
  public int getCanvasHeight() {
    return this.canvasHeight;
  }

  @Override
  public int getCanvasWidth() {
    return this.canvasWidth;
  }

  @Override
  public int getLeftBound() {
    return this.leftBound;
  }

  @Override
  public int getTopBound() {
    return this.topBound;
  }

  public Map<Shape, List<Animation>> getAnimationHistory() {
    return animationHistory;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Shapes: \n");
    for (Shape s : animationHistory.keySet()) {
      sb.append(s.toString());
    }

    PriorityQueue<Animation> pq = new PriorityQueue<>(new Comparator<Animation>() {
      @Override
      public int compare(Animation o1, Animation o2) {
        if (o1.getStartTime() == o2.getStartTime()) {
          return 0;
        }
        return o1.getStartTime() < o2.getStartTime() ? -1 : 1;
      }
    });

    for (List<Animation> l : animationHistory.values()) {
      for (int i = 1; i < l.size() - 1; i++) {
        pq.add(l.get(i));
      }
    }

    while (!pq.isEmpty()) {
      sb.append(pq.poll().toString());
    }

    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  public void setBounds(int x, int y, int width, int height) {
    this.leftBound = x;
    this.topBound = y;
    this.canvasWidth = width;
    this.canvasHeight = height;

  }

  public static class Builder implements AnimationBuilder<AnimationModel> {
    private AnimationModelImpl model = new AnimationModelImpl();
    private Map<String, Shape> shapeMap = new HashMap<>();
    private Map<String, String> nameMap = new HashMap<>();

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
      nameMap.put(name, type);
      shapeMap.put(name, null);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name, int t1, int x1, int y1,
        int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2,
        int g2, int b2) {
      if (shapeMap.get(name) == null) {
        String type = nameMap.get(name);
        switch (type) {
          case "rectangle":
            Rectangle rec = new Rectangle(name, new Position(x1, y1), new Color(r1, g1, b1),
                t1, t1, w1, h1);
            this.model.addShape(rec);
            shapeMap.put(name, rec);
            break;
          case "ellipse":
            Oval oval = new Oval(name, new Position(x1, y1), new Color(r1, g1, b1),
                t1, t1, w1, h1);
            this.model.addShape(oval);
            shapeMap.put(name, oval);
            break;
          default:
            break;
        }
      }

      this.model.move(shapeMap.get(name), new Position(x2, y2), t1, t2);
      this.model.scale(shapeMap.get(name), w1 != w2 ? 1 : 2, w1 != w2? w2:h2, t1, t2);
      this.model.changeColor(shapeMap.get(name), new Color(r2, g2, b2), t1, t2);

//      if (x1 != x1 || y1 != y2) {
//        this.model.move(shapeMap.get(name), new Position(x2, y2), t1, t2);
//      }
//
//      if (w1 != w2 || h1 != h2) {
//        this.model.scale(shapeMap.get(name), w1 != w2 ? 1 : 2, w1 != w2? w2:h2, t1, t2);
//      }
//
//      if (r1 != r2 || g1 != g2 || b1 != b2) {
//        this.model.changeColor(shapeMap.get(name), new Color(r2, g2, b2), t1, t2);
//      }

      return this;
    }
  }
}
