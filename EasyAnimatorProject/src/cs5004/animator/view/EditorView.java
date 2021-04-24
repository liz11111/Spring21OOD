package cs5004.animator.view;

import cs5004.animator.model.ReadOnlyModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 * This interface represents a view of 2D shape animations, specifying all contracts a view should
 * support.
 */
public interface EditorView {

  /**
   * Refresh the view.
   */
  void refresh();

  /**
   * Make the view visible.
   */
  void display();

  /**
   * Start the animation.
   */
  void play();

  /**
   * Pause playing the animation.
   */
  void pause();

  /**
   * Enable the animation to restart right after it finishes.
   */
  void enableLooping();

  /**
   * Not allow the animation to restart after finishing.
   */
  void disableLooping();

  /**
   * Play the animation at a faster speed.
   */
  void speedUp();

  /**
   * Play the animation at a slower speed.
   */
  void slowDown();

  /**
   * Set action listener and key listener.
   * @param actionListener the given action listener
   * @param keyListener the given key listener
   */
  void setListener(ActionListener actionListener, KeyListener keyListener);

  /**
   * Show the view at given time.
   * @param tick the given time
   */
  void getFrameAtTick(int tick);

  /**
   * Return if the animation is playing currently.
   * @return true if the animation is playing
   */
  boolean isPlaying();

  /**
   * Return if looping is allowed.
   * @return true if looping is allowed
   */
  boolean isLooping();

  /**
   * Show error message.
   * @param msg the error message
   */
  void showingErrorMessage(String msg);

  /**
   * Pass the read-only model into the view.
   * @param model the read-only model
   */
  void setModel(ReadOnlyModel model);

  /**
   * Reset the focus to the animation.
   */
  void resetFocus();

}
