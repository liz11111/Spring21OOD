import org.junit.Before;
import org.junit.Test;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * QuestionTest class tests all functionalities of the Question interface with Junit tests.
 */
public class QuestionTest {
  private Question yn;
  private Question sa;
  private Question li;

  @Before
  public void setUp() {
    yn = new YesNo("Are you a human?", true);
    sa = new ShortAnswer("Where are you from?", false);
    li = new Likert("Is CS5004 a good course?", true);
  }

  @Test
  public void testGetPrompt() {
    assertEquals("Are you a human?", yn.getPrompt());
    assertEquals("Where are you from?", sa.getPrompt());
    assertEquals("Is CS5004 a good course?", li.getPrompt());
  }

  @Test
  public void testIsRequired() {
    assertTrue(yn.isRequired());
    assertFalse(sa.isRequired());
    assertTrue(li.isRequired());
  }

  @Test
  public void testGetEmptyAnswer() {
    assertEquals("", yn.getAnswer());
    assertEquals("", sa.getAnswer());
    assertEquals("", li.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testYesNoIllegalAnswer() {
    yn.answer("sdfkl");
    yn.answer("");
    yn.answer(null);
  }

  @Test
  public void testYesNoAnswer1() {
    yn.answer("yes");
    assertEquals("Yes", yn.getAnswer());
  }

  @Test
  public void testYesNoAnswer2() {
    yn.answer("nO");
    assertEquals("No", yn.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testShortAnswerIllegalAnswer() {
    sa.answer("");
    sa.answer(null);
  }

  @Test
  public void testShortAnswerAnswer() {
    sa.answer("Shanghai");
    assertEquals("Shanghai", sa.getAnswer());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLikertIllegalAnswer() {
    li.answer("very good");
    li.answer("");
    li.answer(null);
  }

  @Test
  public void testLikertAnswer() {
    li.answer("stRongly agRee");
    assertEquals("Strongly Agree", li.getAnswer());
  }

  @Test
  public void testCopy() {
    // test copy of question without an answer
    Question ynCopy = yn.copy();
    assertFalse(yn == ynCopy);
    assertTrue(yn.equals(ynCopy));

    // test copy of question with an answer
    sa.answer("Shanghai");
    Question saCopy = sa.copy();
    assertFalse(sa == saCopy);
    assertTrue(sa.equals(saCopy));

    li.answer("agree");
    Question liCopy = li.copy();
    assertFalse(li == liCopy);
    assertEquals("Agree", liCopy.getAnswer());
    assertTrue(li.equals(liCopy));
  }
}
