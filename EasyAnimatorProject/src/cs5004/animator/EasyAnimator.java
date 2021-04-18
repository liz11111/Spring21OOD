package cs5004.animator;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;

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
    //String fileName = "big-bang-big-crunch.txt";
    //String fileName = "buildings.txt";
    //String fileName = "smalldemo.txt";
    //String fileName = "toh-3.txt";
    //String fileName = "toh-3.txt";
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

    String filePath = "C:\\Users\\tonyh\\IdeaProjects\\NEU CS5004\\EasyAnimatorProject" +
            "\\resources\\";
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
      default:
        throw new IllegalArgumentException("Invalid view choice.");
    }
  }
}
