package cs5004.animator;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditorView;
import cs5004.animator.view.GraphicsView;
import cs5004.animator.view.VisualView;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TempTest {

  public static void main(String[] args) throws FileNotFoundException {
    //String fileName = "big-bang-big-crunch.txt";
    String fileName = "buildings.txt";
    //String fileName = "smalldemo.txt";
    //String fileName = "toh-3.txt";
    //String fileName = "toh-8.txt";
    String filePath = "C:\\Users\\heyif\\OneDrive\\Desktop\\NEU-2021Spring\\cs5004\\HW7\\" + fileName;
    Readable inFile = new FileReader(filePath);
    AnimationModel model = AnimationReader.parseFile(inFile, new AnimationModelImpl.Builder());

    EditorView view = new VisualView(model);
    Controller c = new Controller(model, view);


  }

}
