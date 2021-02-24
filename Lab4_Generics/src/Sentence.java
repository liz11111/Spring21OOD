import java.util.function.Predicate;

/**
 * Sentence interface specifies contracts that implemented classes should follow.
 */
public interface Sentence {
  /**
   * reduce is a higher-order function.
   * It takes in a predicate and reduce the sentence to an integer depending
   * on the input.
   *
   * @return int number of punctuations in a sentence
   */
  int reduce(Predicate<SentenceElt> pred);

  /**
   * translate translates a Piglatin sentence to an English sentence.
   *
   * @return Sentence English representation of the Piglatin input
   */
  Sentence translate();

  /**
   * getNumberOfWords returns the number of words in the sentence.
   *
   * @return int number of words
   */
  int getNumberOfWords();

  /**
   * longestWord returns the longest word in the sentence.
   *
   * @return String longest word in the sentence
   */
  String longestWord();

  /**
   * clone returns a deep copy of the sentence.
   *
   * @return Sentence deep copy of the sentence.
   */
  Sentence clone();

  /**
   * merge merges two sentences together.
   *
   * @param other Sentence other sentence to be merged
   * @return Sentence the merged sentence
   */
  Sentence merge(Sentence other);

  /**
   * toString returns the string representation of the sentence.
   *
   * @return String string representation
   */
  String toString();
}
