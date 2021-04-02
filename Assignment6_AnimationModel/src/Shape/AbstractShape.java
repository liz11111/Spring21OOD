package Shape;

public abstract class AbstractShape implements Shape {
  protected String name;
  protected Position position;
  protected Color color;
  protected int appearTime;
  protected int disappearTime;

  protected AbstractShape(String name, Position position, Color color, int appearTime, int disappearTime)
          throws IllegalArgumentException{
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Name cannot be null or empty.");
    } else if (appearTime < 0 || disappearTime <= appearTime) {
      throw new IllegalArgumentException("Invalid appear and disappear times.");
    }

    this.name = name;
    this.position = position;
    this.color = color;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
  }

  @Override
  public Position getInitialPosition() {
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
}
