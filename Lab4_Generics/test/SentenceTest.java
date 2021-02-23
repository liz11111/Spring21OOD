import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

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
    assertEquals(2, s1.reduce(new Predicate<SentenceElt>() {
      @Override
      public boolean test(SentenceElt node) {
        return node.isPunc();
      }
    }));
    assertEquals(3, s2.reduce((SentenceElt node) -> node.isPunc()));
    assertEquals(0, pL.reduce((SentenceElt node) -> node.isPunc()));
  }

  @Test
  public void testZ() {
    assertEquals(0, s1.reduce((SentenceElt node) -> node.hasZ()));
    assertEquals(3, s2.reduce((SentenceElt node) -> node.hasZ()));
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
