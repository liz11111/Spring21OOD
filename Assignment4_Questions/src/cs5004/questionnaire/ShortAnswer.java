package cs5004.questionnaire;

/**
 * ShortAnswer is an implementation of AbstractQuestion specifying short answer questions.
 */
public class ShortAnswer extends AbstractQuestion {

  /**
   * Constructor for all questions. It takes in the question prompt as a String and a boolean where
   * true means the question is required.
   *
   * @param prompt     String question prompt
   * @param isRequired boolean whether the question is required
   */
  public ShortAnswer(String prompt, boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String in) throws IllegalArgumentException {
    if (in == null || in.length() == 0 || in.length() > 280) {
      throw new IllegalArgumentException("Answer cannot be null or empty.");
    }
    this.answer = in;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question q = new ShortAnswer(this.prompt, this.isRequired);
    if (this.answer.length() != 0) {
      q.answer(this.answer);
    }
    return q;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof ShortAnswer)) {
      return false;
    }

    Question q = (Question) obj;
    return this.getPrompt() == q.getPrompt()
            && this.getAnswer().toLowerCase() == q.getAnswer().toLowerCase()
            && this.isRequired == q.isRequired();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
