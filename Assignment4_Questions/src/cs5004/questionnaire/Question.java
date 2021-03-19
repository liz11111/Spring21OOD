package cs5004.questionnaire;

/**
 * Question interface specifies the contract questions will adhere to.
 * It contains several methods, including getPrompt(), isRequired(), etc.
 */
public interface Question {
  /**
   * getPrompt returns the question itself.
   *
   * @return String question prompt
   */
  String getPrompt();

  /**
   * isRequired returns if it is required or optional.
   *
   * @return boolean status isRequired
   */
  boolean isRequired();

  /**
   * answer allows one to enter an answer as a string.
   *
   * @param in String input for answer
   */
  void answer(String in) throws IllegalArgumentException;

  /**
   * getAnswer returns the answer to the question, or empty string if there is no answer.
   *
   * @return String answer to the question
   */
  String getAnswer();

  /**
   * copy returns a copy of the question including all its data.
   *
   * @return Question copy of the original question
   */
  Question copy();
}
