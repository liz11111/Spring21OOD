import java.util.function.Predicate;

/**
 * Sentence interface specifies contracts that implemented classes should follow.
 */
public interface Sentence {
  /**
   * numOfPuncs counts and returns the number of punctuation in a sentence.
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
   * toString returns the string representation of the sentence.
   *
   * @return String string representation
   */
  String toString();
}
