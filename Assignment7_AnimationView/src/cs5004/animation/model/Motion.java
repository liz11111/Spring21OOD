package cs5004.animation.model;

interface Motion<T> {
  T getStateAtTick(int t);

  T getStartState();

  T getEndState();

  int getStartTime();

  int getEndTime();
}
