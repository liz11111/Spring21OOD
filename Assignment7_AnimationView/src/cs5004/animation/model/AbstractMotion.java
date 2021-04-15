package cs5004.animation.model;

public abstract class AbstractMotion<T> implements Motion<T> {
  protected int startTime;
  protected int endTime;
  protected T startState;
  protected T endState;

  public AbstractMotion(int startTime, int endTime, T startState, T endState)
      throws IllegalArgumentException{
    if (startTime > endTime) {
      throw new IllegalArgumentException("The start time should be no later than the end time");
    }
    this.startTime = startTime;
    this.endTime = endTime;
    this.startState = startState;
    this.endState = endState;
  }

  @Override
  public T getStartState() {
    return this.startState;
  }

  @Override
  public T getEndState() {
    return this.endState;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }

}
