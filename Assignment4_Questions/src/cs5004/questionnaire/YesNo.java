package cs5004.questionnaire;

/**
 * YesNo is an implementation of AbstractQuestion specifying yes or no questions.
 */
public class YesNo extends AbstractQuestion {

  /**
   * Constructor for all questions. It takes in the question prompt as a String and a boolean where
   * true means the question is required.
   *
   * @param prompt     String question prompt
   * @param isRequired boolean whether the question is required
   */
  public YesNo(String prompt, boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String in) throws IllegalArgumentException {
    if (in == null
            || in.length() == 0
            || !(in.equalsIgnoreCase("yes") || in.equalsIgnoreCase("no"))) {
      throw new IllegalArgumentException("YesNo questions must be answered with yes or no.");
    }

    this.answer = in;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public Question copy() {
    Question q = new YesNo(this.prompt, this.isRequired);
    if (this.answer.length() != 0) {
      q.answer(this.answer);
    }
    return q;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof YesNo)) {
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
