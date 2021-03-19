import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import cs5004.questionnaire.Likert;
import cs5004.questionnaire.Question;
import cs5004.questionnaire.Questionnaire;
import cs5004.questionnaire.QuestionnaireImpl;
import cs5004.questionnaire.ShortAnswer;
import cs5004.questionnaire.YesNo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * QuestionnaireTest class tests all functionalities of Questionnaire interface with
 * JUnit tests.
 */
public class QuestionnaireTest {
  private Questionnaire qn;


  @Before
  public void setUp() {
    qn = new QuestionnaireImpl();
    Question yn = new YesNo("Are you a human?", true);
    yn.answer("yes");
    Question sa = new ShortAnswer("Where are you from?", false);
    sa.answer("Shanghai");
    Question li = new Likert("Is CS5004 a good course?", true);
    li.answer("agree");
    qn.addQuestion("human", yn);
    qn.addQuestion("home", sa);
    qn.addQuestion("eval", li);
  }

  @Test
  public void testAddQuestion() {
    Question newQ = new ShortAnswer("Where do you live?", true);
    qn.addQuestion("live", newQ);
    String answer = "Question: Are you a human?\n\n"
            + "Answer: yes\n\n"
            + "Question: Where are you from?\n\n"
            + "Answer: Shanghai\n\n"
            + "Question: Is CS5004 a good course?\n\n"
            + "Answer: agree\n\n"
            + "Question: Where do you live?\n\n"
            + "Answer: ";
    assertEquals(answer, qn.toString());
  }

  @Test(expected = NoSuchElementException.class)
  public void testIllegalRemoveQuestion() {
    qn.removeQuestion("lmao");
  }

  @Test
  public void testRemoveQuestion() {
    qn.removeQuestion("human");
    String answer = "Question: Where are you from?\n\n"
            + "Answer: Shanghai\n\n"
            + "Question: Is CS5004 a good course?\n\n"
            + "Answer: agree";
    assertEquals(answer, qn.toString());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testIllegalGetQuestionByNumber() {
    qn.getQuestion(4);
  }

  @Test
  public void testGetQuestionByNumber() {
    Question number2 = qn.getQuestion(2);
    assertEquals("Where are you from?", number2.getPrompt());
    assertEquals("Shanghai", number2.getAnswer());
  }

  @Test(expected = NoSuchElementException.class)
  public void testIllegalGetQuestionByIdentifier() {
    qn.getQuestion("lmao");
  }

  @Test
  public void testGetQuestionByIdentifier() {
    Question number3 = qn.getQuestion("eval");
    assertEquals("Is CS5004 a good course?", number3.getPrompt());
    assertEquals("agree", number3.getAnswer());
  }

  @Test
  public void testGetRequiredQuestions() {
    List<Question> result = qn.getRequiredQuestions();
    for (Question q : result) {
      assertTrue(q.isRequired());
    }
    assertEquals(2, result.size());
    assertEquals("Are you a human?", result.get(0).getPrompt());
    assertEquals("Is CS5004 a good course?", result.get(1).getPrompt());

    // empty list
    qn.removeQuestion("human");
    qn.removeQuestion("eval");
    result = qn.getRequiredQuestions();
    assertEquals(0, result.size());
  }

  @Test
  public void testGetOptionalQuestions() {
    List<Question> result = qn.getOptionalQuestions();
    for (Question q : result) {
      assertFalse(q.isRequired());
    }
    assertEquals(1, result.size());
    assertEquals("Where are you from?", result.get(0).getPrompt());

    // empty list
    qn.removeQuestion("home");
    result = qn.getOptionalQuestions();
    assertEquals(0, result.size());
  }

  @Test
  public void testIsComplete() {
    // complete
    assertTrue(qn.isComplete());

    // not complete
    Question cat = new YesNo("Do you have a cat?", true);
    qn.addQuestion("cat", cat);
    assertFalse(qn.isComplete());
  }

  @Test
  public void testGetResponses() {
    List<String> responses = new ArrayList<>();
    responses.add("yes");
    responses.add("Shanghai");
    responses.add("agree");
    assertEquals(responses, qn.getResponses());

    // with unanswered questions
    Question cat = new YesNo("Do you have a cat?", true);
    qn.addQuestion("cat", cat);
    responses.add("");
    assertEquals(responses, qn.getResponses());
  }

  @Test
  public void testFilter() {
    Questionnaire newQn = qn.filter((Question q) -> q.isRequired());
    String answer = "Question: Are you a human?\n\n"
            + "Answer: yes\n\n"
            + "Question: Is CS5004 a good course?\n\n"
            + "Answer: agree";
    assertEquals(answer, newQn.toString());
  }

  @Test
  public void testSort() {
    // sort by alphabetical order of the prompt
    qn.sort(new Comparator<Question>() {
      @Override
      public int compare(Question o1, Question o2) {
        if (o1.getPrompt().equals(o2.getPrompt())) {
          return 0;
        }
        return o1.getPrompt().compareTo(o2.getPrompt());
      }
    });

    String answer = "Question: Are you a human?\n\n"
            + "Answer: yes\n\n"
            + "Question: Is CS5004 a good course?\n\n"
            + "Answer: agree\n\n"
            + "Question: Where are you from?\n\n"
            + "Answer: Shanghai";
    assertEquals(answer, qn.toString());
  }

  @Test
  public void testFold() {
    // count number of questions
    Integer result = qn.fold(((question, integer) -> 1 + integer), 0);
    assertEquals(result, Integer.valueOf(3));

    // all responses
    String res = qn.fold(((question, string) -> string + question.getAnswer()), "");
    assertEquals(res, "yesShanghaiagree");
  }
}
