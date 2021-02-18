/**
 * EmptyNode is a special ending node of a sentence.
 * It also supports methods in ISentence interface.
 */
public class EmptyNode implements ISentence {
  /**
   * getNumberOfWords returns 0 for an empty node.
   *
   * @return 0
   */
  @Override
  public int getNumberOfWords() {
    return 0;
  }

  /**
   * longestWord returns an empty string for an empty node.
   *
   * @return String empty string
   */
  @Override
  public String longestWord() {
    return "";
  }

  /**
   * toString returns an empty string for an empty node.
   *
   * @return String empty string
   */
  @Override
  public String toString() {
    return "";
  }

  @Override
  public ISentence clone() {
    return new EmptyNode();
  }

  @Override
  public ISentence merge(ISentence other) {
    return other.clone();
  }
}
