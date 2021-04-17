package cs5004.animator;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

public class EasyAnimator {

  public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException {
    //String fileName = "big-bang-big-crunch.txt";
    //String fileName = "smalldemo.txt";
    //String fileName = "toh-3.txt";
    //String fileName = "toh-3.txt";
    String fileName = null;
    String typeOfView = null;
    String output = "";
    PrintStream out = System.out;
    int speed = 1;

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

    String filePath = "C:\\Users\\tonyh\\IdeaProjects\\NEU CS5004\\EasyAnimatorProject\\res\\";
    Readable inFile = new FileReader(filePath + fileName);
    AnimationModel model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());

    switch (output) {
      case "System.out":
      default:
        break;
    }

    switch (typeOfView) {
      case "text":
        View myView = new TextualView(model, out);
        myView.play(1, speed);
        break;
      case "visual":
        myView = new GraphicsView(model);
        myView.play(1, speed);
        break;
      default:
        throw new IllegalArgumentException("Invalid view choice.");
    }
  }
}
