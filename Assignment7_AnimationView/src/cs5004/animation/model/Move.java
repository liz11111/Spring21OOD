package cs5004.animation.model;

public class Move extends AbstractMotion<Position> {

  public Move(int startTime, int endTime, Position startState,
      Position endState) throws IllegalArgumentException {
    super(startTime, endTime, startState, endState);
  }

  @Override
  public Position getStateAtTick(int t) {
    if (t < this.startTime || t > this.endTime) {
      return null;
    }
    double midX = this.startState.getX() * (this.endTime - t) / (this.endTime - this.startTime)
        + this.endState.getX() * (t - this.startTime) / (this.endTime - this.startTime);
    double midY = this.startState.getY() * (this.endTime - t) / (this.endTime - this.startTime)
        + this.endState.getY() * (t - this.startTime) / (this.endTime - this.startTime);
    return new Position(midX, midY);
  }

}
