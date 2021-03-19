package cs5004.questionnaire;

/**
 * Likert is an implementation of AbstractQuestion specifying likert questions.
 */
public class Likert extends AbstractQuestion {

  /**
   * Constructor for all questions. It takes in the question prompt as a String and a boolean where
   * true means the question is required.
   *
   * @param prompt     String question prompt
   * @param isRequired boolean whether the question is required
   */
  public Likert(String prompt, boolean isRequired) {
    super(prompt, isRequired);
  }

  @Override
  public void answer(String in) throws IllegalArgumentException {
    if (in == null || in.length() == 0) {
      throw new IllegalArgumentException("Need an answer.");
    }
    String lowerIn = in.toLowerCase();
    switch (lowerIn) {
      case "strongly agree":
      case "agree":
      case "neither agree nor disagree":
      case "disagree":
      case "strongly disagree":
        this.answer = in;
        break;
      default:
        throw new IllegalArgumentException("Likert questions must be answered on Likert scale");
    }
  }

  @Override
  public String getAnswer() {
    return this.answer == null ? "" : this.answer;
  }

  @Override
  public Question copy() {
    Question q = new Likert(this.prompt, this.isRequired);
    if (this.answer.length() != 0) {
      q.answer(this.getAnswer());
    }
    return q;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (!(obj instanceof Likert)) {
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
