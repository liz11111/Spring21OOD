package cs5004.animator;

import cs5004.animation.model.AnimationModel;
import cs5004.animation.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GraphicsView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EasyAnimator {

  public static void main(String[] args) throws FileNotFoundException {
    //String fileName = "big-bang-big-crunch.txt";
    //String fileName = "smalldemo.txt";
    String fileName = "toh-3.txt";
    //String fileName = "toh-8.txt";
    String filePath = "..." + fileName;
    Readable inFile = new FileReader(filePath);
    AnimationModel model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());

    GraphicsView myView = new GraphicsView(model);
    myView.play(1, 1);

  }
}
