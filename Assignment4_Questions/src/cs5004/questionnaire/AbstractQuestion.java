package cs5004.questionnaire;

/**
 * AbstractQuestion is an abstract class implementing the question interface.
 */
public abstract class AbstractQuestion implements Question {
  protected String prompt;
  protected boolean isRequired;
  protected String answer;

  /**
   * Constructor for all questions. It takes in the question prompt as a String and a boolean where
   * true means the question is required.
   *
   * @param prompt     String question prompt
   * @param isRequired boolean whether the question is required
   */
  protected AbstractQuestion(String prompt, boolean isRequired) {
    this.prompt = prompt;
    this.isRequired = isRequired;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return this.prompt;
  }

  @Override
  public boolean isRequired() {
    return this.isRequired;
  }

}
