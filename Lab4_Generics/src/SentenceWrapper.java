import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * SentenceWrapper is an implementation to Sentence interface.
 */
public class SentenceWrapper implements Sentence {
  private List<SentenceElt> sentence;

  /**
   * Constructor that takes in a list of SentenceElt's to create a SentenceWrapper.
   *
   * @param sentence List that contains SentenceElt
   */
  public SentenceWrapper(List<SentenceElt> sentence) {
    this.sentence = sentence;
  }

  /**
   * Constructor thats takes in a string and creates a SentenceWrapper.
   *
   * @param in String input
   */
  public SentenceWrapper(String in) {
    String[] array = in.split(" ");
    sentence = new ArrayList<>();

    for (String s : array) {
      if (Character.isLetter(s.charAt(s.length() - 1))) {
        sentence.add(new Word(s));
      } else {
        sentence.add(new Word(s.substring(0, s.length() - 1)));
        sentence.add(new Punctuation(s.substring(s.length() - 1)));
      }
    }
  }

  @Override
  public int reduce(Predicate<SentenceElt> pred) {
    int result = 0;
    for (SentenceElt node : sentence) {
      if (pred.test(node)) {
        result++;
      }
    }
    return result;
  }

  @Override
  public Sentence translate() {
    List<SentenceElt> result = new ArrayList<>();
    for (SentenceElt node : sentence) {
      result.add(node.translate());
    }
    return new SentenceWrapper(result);
  }

  @Override
  public int getNumberOfWords() {
    int result = 0;
    for (SentenceElt node : sentence) {
      result += node.getNumberOfWords();
    }
    return result;
  }

  @Override
  public String longestWord() {
    String result = "";
    for (SentenceElt node : sentence) {
      result = node.longestWord().length() > result.length() ?
              node.longestWord() : result;
    }
    return result;
  }

  @Override
  public Sentence clone() {
    List<SentenceElt> result = new ArrayList<>();
    for (SentenceElt node : sentence) {
      result.add(node.clone());
    }
    return new SentenceWrapper(result);
  }

  @Override
  public Sentence merge(Sentence other) {
    return new SentenceWrapper(this.toString() + " " + other.toString());
  }

  @Override
  public String toString() {
    String result = "";
    for (SentenceElt node : sentence) {
      result += node.toString();
    }
    return result.substring(1);
  }
}
