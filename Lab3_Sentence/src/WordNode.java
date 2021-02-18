/**
 * WordNode contains a word in a sentence. It has fields of word itself and the rest
 * of the sentence. It also supports methods in ISentence interface.
 */
public class WordNode implements ISentence {
  private String word;
  private ISentence rest;

  /**
   * Constructor that instantiate a WordNode object.
   *
   * @param word String word data
   * @param rest ISentence the rest of the sentence
   */
  public WordNode(String word, ISentence rest) {
    this.word = word;
    this.rest = rest;
  }

  /**
   * getNumberOfWords returns the number of words in the sentence.
   * A punctuation does not count as a word.
   *
   * @return int number of words
   */
  @Override
  public int getNumberOfWords() {
    return 1 + rest.getNumberOfWords();
  }

  /**
   * longestWord returns the longest word in the sentence.
   * If two words have the same length, return the first.
   *
   * @return String longest word in the sentence.
   */
  @Override
  public String longestWord() {
    String restLongest = rest.longestWord();
    return word.length() >= restLongest.length() ? word : restLongest;
  }

  /**
   * toString returns the String representation of the sentence.
   * If there is no punctuation at the end, this string should end with a period.
   *
   * @return String string representation of the sentence
   */
  @Override
  public String toString() {
    String restToString = rest.toString();
    if (restToString.length() == 0) {
      return word + ".";
    } else if (Character.isLetter(restToString.charAt(0))) {
      return word + " " + restToString;
    } else {
      return word + restToString;
    }
  }

  /**
   * clone returns a deep copy of the sentence as list.
   *
   * @return ISentence deep copy of the sentence
   */
  @Override
  public ISentence clone() {
    return new WordNode(word, rest.clone());
  }

  /**
   * merge merges two sentences together, leaving original lists unchanged.
   *
   * @param other ISentence the sentence to be merged
   * @return ISentence merged sentence
   */
  @Override
  public ISentence merge(ISentence other) {
    return new WordNode(word, rest.merge(other));
  }
}
