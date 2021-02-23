import java.util.function.Predicate;

/**
 * Punctuation is a punctuation node in a sentence.
 */
public class Punctuation extends SentenceElt {
  public Punctuation(String content) {
    super(content);
  }

  @Override
  public boolean isPunc() {
    return true;
  }

  @Override
  public boolean hasZ() {
    return false;
  }

  @Override
  public SentenceElt translate() {
    return new Punctuation(this.content);
  }

  @Override
  public String toString() {
    return this.content;
  }

  @Override
  public boolean test(SentenceElt sentenceElt) {
    return true;
  }
}
