import java.util.function.Predicate;

/**
 * SentenceElt class is an abstract class for nodes in a sentence.
 */
public abstract class SentenceElt implements Predicate<SentenceElt> {
  protected String content;

  public SentenceElt(String content) {
    this.content = content;
  }

  /**
   * isPunc checks whether a node is an punctuation.
   *
   * @return boolean if it is a punc
   */
  public abstract boolean isPunc();

  /**
   * hasZ checks whether a node has letter z in it.
   *
   * @return boolean if it has z
   */
  public abstract boolean hasZ();

  /**
   * translate translates a word node from English to PigLatin.
   *
   * @return SentenceElt after translation
   */
  public abstract SentenceElt translate();

  /**
   * toString returns the string representation of a word node.
   *
   * @return String representation of a word node
   */
  public abstract String toString();

}
