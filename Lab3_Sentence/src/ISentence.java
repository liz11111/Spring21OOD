/**
 * ISentence interface contains all operations to be supported by a sentence.
 */
public interface ISentence {
  /**
   * getNumberOfWords returns the number of words in the sentence.
   * A punctuation does not count as a word.
   *
   * @return int number of words
   */
  int getNumberOfWords();

  /**
   * longestWord returns the longest word in the sentence.
   * The word returned does not contain any punctuations.
   *
   * @return String longest word of the sentence
   */
  String longestWord();

  /**
   * toString returns the String representation of the sentence.
   * If there is no punctuation at the end, this string should end with a period.
   *
   * @return String string representation of the sentence
   */
  String toString();

  /**
   * clone returns a deep copy of the sentence as list.
   *
   * @return ISentence deep copy of the sentence
   */
  ISentence clone();

  /**
   * merge merges two sentences together, leaving original lists unchanged.
   *
   * @param other ISentence the sentence to be merged
   * @return ISentence merged sentence
   */
  ISentence merge(ISentence other);
}
