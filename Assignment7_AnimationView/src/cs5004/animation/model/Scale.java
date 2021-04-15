package cs5004.animation.model;

public class Scale extends AbstractMotion<double[]> {

  public Scale(int startTime, int endTime, double[] startState, double[] endState)
      throws IllegalArgumentException {
    super(startTime, endTime, startState, endState);
  }

  @Override
  public double[] getStateAtTick(int t) {
    if (t < this.startTime || t > this.endTime) {
      return null;
    }
    double[] midSize = new double[this.startState.length];
    for (int i = 0; i < this.startState.length; i++) {
      midSize[i] = this.startState[i] * (this.endTime - t) / (this.endTime - this.startTime)
          + this.endState[i] * (t - this.startTime) / (this.endTime - this.startTime);
    }
    return midSize;
  }
}
