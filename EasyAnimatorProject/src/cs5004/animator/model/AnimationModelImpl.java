package cs5004.animator.model;

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

  public void getShapeAtTick(Shape shape, int tickTime) {
    return;
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
    } else if (startTime >= endTime) {
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
}
