package cs5004.animator.view;

/**
 * This interface represents a view of 2D shape animations, specifying all contracts a view should
 * support.
 */
public interface View {

  /**
   * Plays the animation from the given start time at the provided speed.
   *
   * @param startTime the given start time
   * @param speed     the given speed.
   */
  void play(int startTime, int speed);

  /**
   * Transmit an error message to the view, in case the command could not be processed properly.
   *
   * @param errorMessage the error message sent to the view
   */
  void showErrorMessage(String errorMessage);

}
