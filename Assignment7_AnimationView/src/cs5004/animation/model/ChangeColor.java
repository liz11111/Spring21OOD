package cs5004.animation.model;

public class ChangeColor extends AbstractMotion<Color> {

  public ChangeColor(int startTime, int endTime, Color startState,
      Color endState) throws IllegalArgumentException {
    super(startTime, endTime, startState, endState);
  }

  @Override
  public Color getStateAtTick(int t) {
    if (t < this.startTime || t > this.endTime) {
      return null;
    }
    double midR = this.startState.getR() * (this.endTime - t) / (this.endTime - this.startTime)
        + this.endState.getR() * (t - this.startTime) / (this.endTime - this.startTime);
    double midG = this.startState.getG() * (this.endTime - t) / (this.endTime - this.startTime)
        + this.endState.getG() * (t - this.startTime) / (this.endTime - this.startTime);
    double midB = this.startState.getB() * (this.endTime - t) / (this.endTime - this.startTime)
        + this.endState.getB() * (t - this.startTime) / (this.endTime - this.startTime);

    return new Color(midR, midG, midB);
  }
}
