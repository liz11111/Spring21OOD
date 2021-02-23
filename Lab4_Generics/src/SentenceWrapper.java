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
  public int numOfPuncs(Predicate<SentenceElt> pred) {
    int puncs = 0;
    for (SentenceElt node : sentence) {
      if ((node instanceof Punctuation) && pred.test(node)) {
        puncs++;
      }
    }
    return puncs;
  }

  @Override
  public int numOfWordsWithZ(Predicate<SentenceElt> pred) {
    int withZ = 0;
    for (SentenceElt node : sentence) {
      if ((node instanceof Word) && pred.test(node)) {
        withZ++;
      }
    }
    return withZ;
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
  public String toString() {
    String result = "";
    for (SentenceElt node : sentence) {
      result += node.toString();
    }
    return result.substring(1);
  }
}
