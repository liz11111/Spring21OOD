package cs5004.animation.model;

import java.util.ArrayList;
import java.util.List;

class ShapeAnimation {
  private String shapeName;
  private ShapeType shapeType;
  private List<ChangeColor> colorChanges;
  private List<Scale> scales;
  private List<Move> moves;

  public ShapeAnimation(String shapeName, String shapeType) throws IllegalArgumentException {
    if (shapeName == null || shapeName.isEmpty() || shapeType == null) {
      throw new IllegalArgumentException("Shape name and Shape type cannot be null or empty");
    }

    switch (shapeType.toLowerCase()) {
      case "oval":
      case "ellipse":
        this.shapeType = ShapeType.OVAL;
        break;
      case "rectangle":
        this.shapeType = ShapeType.RECTANGLE;
        break;
      default:
        throw new IllegalArgumentException("No such shape type");
    }
    this.shapeName = shapeName;

    this.colorChanges = new ArrayList<>();
    this.scales = new ArrayList<>();
    this.moves = new ArrayList<>();
  }

  public Shape getStateAtTick(int t) {
    Color midColor = this.getColorAtTick(t);
    Position midPosition = this.getPositionAtTick(t);
    double[] midSize = this.getSizeAtTick(t);

    if (midColor == null || midPosition == null || midSize == null) {
      return null;
    }

    return ShapeFactory.createShape(this.shapeType.getTypeName(), midPosition, midColor, midSize);

  }

  private Color getColorAtTick(int t) {
    if (this.colorChanges.isEmpty() || t < this.colorChanges.get(0).startTime) {
      return null;
    }

    int i = 0;
    while (i < this.colorChanges.size()) {
      if (t < this.colorChanges.get(i).getStartTime()) {
        return this.colorChanges.get(i - 1).getEndState();
      }

      Color midColor = this.colorChanges.get(i).getStateAtTick(t);

      if (midColor != null) {
        return midColor;
      }
      i += 1;
    }

    return null;
  }

  private Position getPositionAtTick(int t) {
    if (this.moves.isEmpty() || t < this.moves.get(0).startTime) {
      return null;
    }

    int i = 0;
    while (i < this.moves.size()) {
      if (t < this.moves.get(i).getStartTime()) {
        return this.moves.get(i - 1).getEndState();
      }

      Position midPosition = this.moves.get(i).getStateAtTick(t);
      if (midPosition != null) {
        return midPosition;
      }
      i += 1;
    }

    return null;

  }

  private double[] getSizeAtTick(int t) {
    if (this.scales.isEmpty() || t < this.scales.get(0).startTime) {
      return null;
    }

    int i = 0;
    while (i < this.scales.size()) {
      if (t < this.scales.get(i).getStartTime()) {
        return this.scales.get(i - 1).getEndState();
      }
      double[] midScale = this.scales.get(i).getStateAtTick(t);

      if (midScale != null) {
        return midScale;
      }
      i += 1;
    }

    return null;
  }

  public void addChangeColor(int startTime, int endTime, Color startColor, Color endColor)
      throws IllegalArgumentException {
    if (startTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("Start time should be no later than end time");
    }

    if (startColor == null || endColor == null) {
      throw new IllegalArgumentException("Color shouldn't be null");
    }

    int i = 0;
    while (i < this.colorChanges.size()) {
      if (endTime <= this.colorChanges.get(i).getStartTime()) {
        ChangeColor motion = new ChangeColor(startTime, endTime, startColor, endColor);
        this.colorChanges.add(i, motion);
        return;
      } else if (startTime >= this.colorChanges.get(i).getEndTime()) {
        i += 1;
      } else {
        throw new IllegalArgumentException("Time conflict");
      }
    }
    ChangeColor motion = new ChangeColor(startTime, endTime, startColor, endColor);
    this.colorChanges.add(i, motion);

  }

  public void addScale(int startTime, int endTime, double[] startSzie, double[] endSize) {
    if (startTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("Start time should be no later than end time");
    }

    if (startSzie == null || endSize == null) {
      throw new IllegalArgumentException("Size shouldn't be null");
    }

    int i = 0;
    while (i < this.scales.size()) {
      if (endTime <= this.scales.get(i).getStartTime()) {
        Scale motion = new Scale(startTime, endTime, startSzie, endSize);
        this.scales.add(i, motion);
        return;
      } else if (startTime >= this.scales.get(i).getEndTime()) {
        i += 1;
      } else {
        throw new IllegalArgumentException("Time conflict");
      }
    }
    Scale motion = new Scale(startTime, endTime, startSzie, endSize);
    this.scales.add(i, motion);

  }

  public void addMove(int startTime, int endTime, Position startPosition, Position endPosition)
    throws IllegalArgumentException {
    if (startTime < 0 || endTime < startTime) {
      throw new IllegalArgumentException("Start time should be no later than end time");
    }

    if (startPosition == null || endPosition == null) {
      throw new IllegalArgumentException("Position shouldn't be null");
    }

    int i = 0;
    while (i < this.moves.size()) {
      if (endTime <= this.moves.get(i).getStartTime()) {
        Move motion = new Move(startTime, endTime, startPosition, endPosition);
        this.moves.add(i, motion);
        return;
      } else if (startTime >= this.moves.get(i).getEndTime()) {
        i += 1;
      } else {
        throw new IllegalArgumentException("Time conflict");
      }
    }
    Move motion = new Move(startTime, endTime, startPosition, endPosition);
    this.moves.add(i, motion);

  }

}
