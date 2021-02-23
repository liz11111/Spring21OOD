
/**
 * Punctuation is a punctuation node in a sentence.
 */
public class Punctuation extends SentenceElt {
  public Punctuation(String content) {
    super(content);
  }

  @Override
  public SentenceElt translate() {
    return new Punctuation(this.content);
  }

  @Override
  public String toString() {
    return this.content;
  }

  public boolean isPunc() {
    return true;
  }

  @Override
  public boolean hasZ() {
    return false;
  }
}
