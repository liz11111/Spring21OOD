import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * SentenceTest tests all functionalities of the Sentence interface with JUnit tests.
 */
public class SentenceTest {
  private Sentence s1;
  private Sentence s2;
  private Sentence pL;

  @Before
  public void setUp() {
    s1 = new SentenceWrapper("Hello, World!");
    s2 = new SentenceWrapper("Zebra is a horse, with z in its name, zzz.");
    pL = new SentenceWrapper("MAKING A PIG DEAL ABOUT PIG LATIN");
  }

  @Test
  public void testPunc() {
    assertEquals(2, s1.numOfPuncs(new Punctuation("")));
    assertEquals(3, s2.numOfPuncs(new Punctuation("")));
    assertEquals(0, pL.numOfPuncs(new Punctuation("")));
  }

  @Test
  public void testZ() {
    assertEquals(0, s1.numOfWordsWithZ(new Word("")));
    assertEquals(3, s2.numOfWordsWithZ((SentenceElt s) -> s.content.contains("Z")));
    assertEquals(0, pL.numOfWordsWithZ(new Word("")));
  }

  @Test
  public void testTranslate() {
    assertEquals("AKINGMAY AWAY IGPAY EALDAY ABOUTWAY IGPAY ATINLAY",
            pL.translate().toString());
  }

  @Test
  public void testToString() {
    assertEquals("Hello, World!", s1.toString());
    assertEquals("Zebra is a horse, with z in its name, zzz.",
            s2.toString());
    assertEquals("MAKING A PIG DEAL ABOUT PIG LATIN",
            pL.toString());
  }
}
