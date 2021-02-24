import java.util.HashSet;
import java.util.Set;

/**
 * Word is a word node in a sentence.
 */
public class Word extends SentenceElt {
  public Word(String content) {
    super(content);
  }

  @Override
  public SentenceElt translate() {
    Set<Character> set = new HashSet<>();
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');

    String word;
    if (set.contains(this.content.charAt(0))) {
      word = this.content + "WAY";
    } else {
      word = this.content + this.content.charAt(0) + "AY";
      word = word.substring(1);
    }

    return new Word(word);
  }

  @Override
  public String toString() {
    return " " + this.content;
  }

  @Override
  public boolean isPunc() {
    return false;
  }

  @Override
  public boolean hasZ() {
    return this.content.contains("Z") || this.content.contains("z");
  }

  @Override
  public int getNumberOfWords() {
    return 1;
  }

  @Override
  public String longestWord() {
    return this.content;
  }

  @Override
  public SentenceElt clone() {
    return new Word(this.content);
  }

}
