package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import cs5004.animator.animation.Animation;
import cs5004.animator.shape.Shape;
import cs5004.animator.model.ReadOnlyModel;

/**
 * TextualView shows a textual description of the animation. It supports a variety of output
 * sources.
 */
public class TextualView implements View {
  private ReadOnlyModel model;
  private PrintStream out;
  private String animationText;

  /**
   * Constructor for TextualView.
   *
   * @param model ReadOnlyModel model to process animation
   * @param out   PrintStream output source
   * @throws IllegalArgumentException if model or out is null
   */
  public TextualView(ReadOnlyModel model, PrintStream out) throws IllegalArgumentException {
    if (model == null || out == null) {
      throw new IllegalArgumentException("Model and out can't be null.");
    }
    this.model = model;
    this.out = out;
  }

  @Override
  public void play(int startTime, int speed) {
    Map<Shape, List<Animation>> animationHistory = model.getAnimationHistory();

    StringBuilder sb = new StringBuilder();
    for (Shape s : animationHistory.keySet()) {
      sb.append(s.toString());
    }

    PriorityQueue<Animation> pq = new PriorityQueue<>(new Comparator<Animation>() {
      @Override
      public int compare(Animation o1, Animation o2) {
        if (o1.getStartTime() == o2.getStartTime()) {
          return 0;
        }
        return o1.getStartTime() < o2.getStartTime() ? -1 : 1;
      }
    });

    for (List<Animation> l : animationHistory.values()) {
      for (int i = 1; i < l.size() - 1; i++) {
        pq.add(l.get(i));
      }
    }

    while (!pq.isEmpty()) {
      Animation a = pq.poll();
      if (a.getStartTime() >= startTime) {
        sb.append(a.toString());
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    out.println(sb.toString());

    this.animationText = sb.toString();
  }

  @Override
  public void showErrorMessage(String errorMessage) {
    out.println(errorMessage);
  }

  /**
   * Save the result as a txt file.
   * @param filePath String file path
   * @throws IOException if the file path not found
   */
  public void saveTxt(String filePath) throws IOException {
    FileWriter writer = new FileWriter(filePath);
    try {
      writer.write(this.animationText.toString());
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
