/**
 * SentenceElt class is an abstract class for nodes in a sentence.
 */
public abstract class SentenceElt {
  protected String content;

  public SentenceElt(String content) {
    this.content = content;
  }

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

  /**
   * isPunc returns if a node is a punctuation.
   *
   * @return boolean if it is a puncutation node
   */
  public abstract boolean isPunc();

  /**
   * hasZ returns if a node has z.
   *
   * @return boolean if it has z
   */
  public abstract boolean hasZ();

  /**
   * getNumberOfWords returns the number of words in the node.
   *
   * @return int number of words
   */
  public abstract int getNumberOfWords();

  /**
   * longestWord returns the word in a word node.
   * It returns an empty string in a punctuation node.
   *
   * @return String word
   */
  public abstract String longestWord();

  /**
   * clone returns a deep copy of SentenceElt object.
   *
   * @return SentenceElt clone of the node
   */
  public abstract SentenceElt clone();
}
