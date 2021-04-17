package cs5004.animator.Shape;

/**
 * AbstractShape is an implementation of Shape interface.
 */
public abstract class AbstractShape implements Shape {
  protected String name;
  protected Position position;
  protected Color color;
  protected int appearTime;
  protected int disappearTime;

  /**
   * Constructor for an abstract shape.
   *
   * @param name       String name of the shape
   * @param position   Position position of the shape
   * @param color      Color color of the shape
   * @param appearTime int appear time of the shape
   * @throws IllegalArgumentException if name of time is invalid
   */
  protected AbstractShape(String name, Position position, Color color,
                          int appearTime, int disappearTime)
          throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    } else if (appearTime < 0 || disappearTime < appearTime) {
      throw new IllegalArgumentException("Invalid appear and disappear times.");
    }

    this.name = name;
    this.position = position;
    this.color = color;
    this.appearTime = appearTime;
    this.disappearTime = Integer.MAX_VALUE;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public int getAppearTime() {
    return this.appearTime;
  }

  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof AbstractShape)) {
      return false;
    }

    AbstractShape shapeObj = (AbstractShape) obj;
    return this.name == ((AbstractShape) obj).name;
  }

  @Override
  public void setColor(Color newColor) {
    this.color = newColor;
  }

  @Override
  public void setPosition(Position newPosition) {
    this.position = newPosition;
  }
}
