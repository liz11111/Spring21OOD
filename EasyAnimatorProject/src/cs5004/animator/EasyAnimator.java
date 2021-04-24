package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * The main() method.
 */
public class EasyAnimator {

  /**
   * Program entry.
   * @param args String[] args
   * @throws IOException if IOException
   * @throws IllegalArgumentException if IllegalArgumentException
   */
  public static void main(String[] args) throws IOException, IllegalArgumentException {
    String fileName = null;
    String typeOfView = null;
    String output = "";
    PrintStream out = System.out; //default text output source
    int speed = 1; // default play speed

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        fileName = args[i + 1];
      } else if (args[i].equals("-view")) {
        typeOfView = args[i + 1];
      } else if (args[i].equals("-out")) {
        output = args[i + 1];
      } else if (args[i].equals("-speed")) {
        speed = Integer.valueOf(args[i + 1]);
      }
    }

    String filePath = "resources\\";
    Readable inFile = new FileReader(filePath + fileName);
    AnimationModel model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());

    switch (output) {
      case "PrintStream":
        out = new PrintStream(filePath + fileName + "out");
        break;
      case "System.out":
      default:
        break;
    }

    System.out.println(typeOfView);
    switch (typeOfView) {
      case "text":
        View myView = new TextualView(model, out);
        myView.play(50, speed);
        break;
      case "visual":
        myView = new GraphicsView(model);
        myView.play(1, speed);
        break;
      case "svg":
        SVGView view = new SVGView(model);
        view.play(1, speed);
        view.saveSVG(filePath + "toh-at-20.svg");
        break;
      case "playback":
        EditorView editorView = new VisualView(model);
        Controller c = new Controller(model, editorView);
        break;
      default:
        throw new IllegalArgumentException("Invalid view choice.");
    }
  }
}
