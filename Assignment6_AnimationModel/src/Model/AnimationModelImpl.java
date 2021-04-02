package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Animation.*;
import Shape.Shape;
import Shape.Position;
import Shape.Color;

public class AnimationModelImpl implements AnimationModel {
  Map<Shape, List<Animation>> animationHistory;

  public AnimationModelImpl() {
    animationHistory = new HashMap<>();
  }

  public void addShape(Shape shape) throws IllegalStateException {
    if (animationHistory.containsKey(shape)) {
      throw new IllegalStateException("Shape already exists.");
    }
    List<Animation> animations = new ArrayList<>();
    animations.add(new Display(shape, shape.getAppearTime(), shape.getAppearTime()));
    animations.add(new Vanish(shape, shape.getDisappearTime(), shape.getDisappearTime()));
    animationHistory.put(shape, animations);
  }

  public void getShapeAtTick(int tickTime) {
    return;
  }

  public void removeShape(Shape shape) {
    animationHistory.remove(shape);
  }

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

  private boolean hasConflict(Shape shape, int startTime, int endTime, String animationType) throws IllegalArgumentException {
    List<Animation> animations = animationHistory.get(shape);
    // check if a given operation has conflict with existing animations
    switch(animationType) {
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

  private void checkAnimation(Shape shape, int startTime, int endTime) throws IllegalArgumentException {
    if (!animationHistory.containsKey(shape)) {
      throw new IllegalArgumentException("No such shape");
    } else if (startTime < endTime) {
      throw new IllegalArgumentException("Invalid times.");
    } else if (!checkWithinLifetime(shape, startTime, endTime)) {
      throw new IllegalArgumentException("Operation span is outside of shape's lifetime.");
    }
  }

  @Override
  public void move(Shape shape, Position endPosition, int startTime, int endTime) throws IllegalArgumentException {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Move")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    for (int i = 1; i < animations.size(); i++) {
      if (animations.get(i).getStartTime() >= startTime) {
        animations.add(i, new Move(shape, endPosition, startTime, endTime));
      }
    }
  }

  @Override
  public void scale(Shape shape, int sideToScale, double newLength, int startTime, int endTime) throws IllegalArgumentException  {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Scale")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    for (int i = 1; i < animations.size(); i++) {
      if (animations.get(i).getStartTime() >= startTime) {
        animations.add(i, new Scale(shape, sideToScale, newLength, startTime, endTime));
      }
    }
  }

  @Override
  public void changeColor(Shape shape, Color newColor, int startTime, int endTime) {
    checkAnimation(shape, startTime, endTime);
    if (hasConflict(shape, startTime, endTime, "Change Color")) {
      throw new IllegalArgumentException("Has conflict with existing animations.");
    }

    List<Animation> animations = animationHistory.get(shape);
    for (int i = 1; i < animations.size(); i++) {
      if (animations.get(i).getStartTime() >= startTime) {
        animations.add(i, new ChangeColor(shape, newColor, startTime, endTime));
      }
    }
  }

  @Override
  public String toString() {

    return null;
  }
}
