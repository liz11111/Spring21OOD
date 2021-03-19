package cs5004.questionnaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * QuestionnaireImpl is an implementation of Questionnaire interface.
 */
public class QuestionnaireImpl implements Questionnaire {
  private List<Question> questions;
  private Map<String, Question> map;

  /**
   * Constructor for QuestionnaireImpl class.
   */
  public QuestionnaireImpl() {
    this.questions = new ArrayList<>();
    this.map = new HashMap<>();
  }

  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.length() == 0) {
      throw new IllegalArgumentException("Identifier cannot be null or empty.");
    }
    questions.add(q);
    map.put(identifier, q);
  }

  @Override
  public void removeQuestion(String identifier) throws NoSuchElementException {
    if (!map.containsKey(identifier)) {
      throw new NoSuchElementException("No such question in the questionnaire.");
    }

    questions.remove(map.get(identifier));
    map.remove(identifier);
  }

  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num > questions.size()) {
      throw new IndexOutOfBoundsException("Question index out of bound.");
    }

    return questions.get(num - 1);
  }

  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException {
    if (!map.containsKey(identifier)) {
      throw new NoSuchElementException("No such question in the questionnaire.");
    }

    return map.get(identifier);
  }

  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> required = new ArrayList<>();
    for (Question q : questions) {
      if (q.isRequired()) {
        required.add(q);
      }
    }
    return required;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> optional = new ArrayList<>();
    for (Question q : questions) {
      if (!q.isRequired()) {
        optional.add(q);
      }
    }
    return optional;
  }

  @Override
  public boolean isComplete() {
    for (Question q : questions) {
      if (q.isRequired() && q.getAnswer().length() == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<String> getResponses() {
    List<String> ans = new ArrayList<>();
    for (Question q : questions) {
      ans.add(q.getAnswer());
    }
    return ans;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    Questionnaire qn = new QuestionnaireImpl();
    for (Question q : questions) {
      if (pq.test(q)) {
        qn.addQuestion(q.getPrompt(), q.copy());
      }
    }
    return qn;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    Collections.sort(questions, comp);
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    for (Question q : questions) {
      seed = bf.apply(q, seed);
    }
    return seed;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Question q : questions) {
      sb.append("Question: ");
      sb.append(q.getPrompt()).append("\n\n");
      sb.append("Answer: ");
      sb.append(q.getAnswer()).append("\n\n");
    }
    return sb.substring(0, sb.length() - 2);
  }
}
