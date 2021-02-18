import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * ISentenceTest tests all functionalities of the ISentence interface.
 */
public class ISentenceTest {
  private ISentence s1;
  private ISentence s2;
  private ISentence s3;
  private ISentence s4;

  @Before
  public void setUp() {
    s1 = new WordNode("Hello",
            new PunctuationNode(",",
                    new WordNode("World",
                            new PunctuationNode("!",
                                    new EmptyNode()))));

    s2 = new WordNode("Get",
            new WordNode("started",
                    new WordNode("with",
                            new WordNode("Java",
                                    new WordNode("today",
                                            new EmptyNode())))));

    s3 = new PunctuationNode("?",
            new EmptyNode());

    s4 = new EmptyNode();
  }

  @Test
  public void testGetNumberOfWords() {
    assertEquals(2, s1.getNumberOfWords());
    assertEquals(5, s2.getNumberOfWords());
    assertEquals(0, s3.getNumberOfWords());
    assertEquals(0, s4.getNumberOfWords());
  }

  @Test
  public void testLongestWord() {
    assertEquals("Hello", s1.longestWord());
    assertEquals("started", s2.longestWord());
    assertEquals("", s3.longestWord());
    assertEquals("", s4.longestWord());
  }

  @Test
  public void testToString() {
    assertEquals("Hello, World!", s1.toString());
    assertEquals("Get started with Java today.", s2.toString());
    assertEquals("?", s3.toString());
    assertEquals("", s4.toString());
  }

  @Test
  public void testClone() {
    ISentence s1c = s1.clone();
    assertFalse(s1 == s1c);
    assertEquals(2, s1c.getNumberOfWords());
    assertEquals("Hello, World!", s1c.toString());
    assertEquals("Hello", s1c.longestWord());

    ISentence s3c = s3.clone();
    assertFalse(s3 == s3c);
    assertEquals(0, s3c.getNumberOfWords());
    assertEquals("?", s3c.toString());
    assertEquals("", s3c.longestWord());

    ISentence s4c = s4.clone();
    assertFalse(s4 == s4c);
    assertEquals(0, s4c.getNumberOfWords());
    assertEquals("", s4c.toString());
    assertEquals("", s4c.longestWord());
  }

  @Test
  public void testMerge() {
    ISentence s1s2 = s1.merge(s2);
    assertFalse(s1s2 == s1);
    assertFalse(s1s2 == s2);
    assertEquals(7, s1s2.getNumberOfWords());
    assertEquals("Hello, World! Get started with Java today.", s1s2.toString());
    assertEquals("started", s1s2.longestWord());

    ISentence s1s3 = s1.merge(s3);
    assertEquals(2, s1s3.getNumberOfWords());
    assertEquals("Hello, World! ?", s1s3.toString());

    ISentence s3s4 = s3.merge(s4);
    assertEquals(0, s3s4.getNumberOfWords());
    assertEquals("?", s3s4.toString());
  }
}
